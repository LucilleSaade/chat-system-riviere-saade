package NI;

import java.io.File;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;

import Controller.Controller;


public class ChatNI {
	
	/**
	 * Facade between the classes which permit to send and receive message/file and the controller
	 * knows the controller.
	 */
	
	private String hostname;
	private Controller controller;
	private UDPSender usender;
	private UDPReceiver ureceiver;
	private TCPServer tserver;
	private DatagramSocket soc;
	
	private int portUDP = 9876;
	private int portTCP = 6789;
	
	
	/**
	 * ChatNI constructor :
	 * instantiate the controller, the hostname, the Datagram socket for UDPSender and UDPReceiver fields, 
	 * instantiate the UDPSender and the UDPReceiver fields, the TCPServer field
	 * launch the thread of the UDPReceiver and the TCPServer objects
	 * @param control : controller
	 */
	
	public ChatNI(Controller control) {
		try {
			this.controller = control;
			this.hostname = this.controller.getModel().getLocalUser().getHostName();
			this.soc = new DatagramSocket(this.portUDP);
			this.soc.setBroadcast(true);
			this.usender = new UDPSender(this.hostname, this.portUDP, this.soc);
			this.ureceiver = new UDPReceiver(this, this.soc);
			this.tserver = new TCPServer(new ServerSocket(portTCP), this);
			ureceiver.start();
			tserver.start();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	*     FOR UDP SENDER            
	*/
	
	
	/**
	 * sendHello() : call the sendHello() method of the UDPSender object
	 */
	public void sendHello() {
		try {
			this.usender.sendHello();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * sendHelloAck() : call the sendHelloAck() method of the UDPSender object.
	 * It give it the hostname of recipient of the helloAck.
	 * @param hostname : String
	 */
	public void sendHelloAck(String hostname) {
		try {
			this.usender.sendHelloAck(hostname);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * sendGoodbye() : call the sendGoodbye() method of the UDPSender object
	 */
	public void sendGoodbye() {
		try {
			this.usender.sendGoodbye();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * sendMessage() : call the sendMessage method of the UDPSender object.
	 * It give it the message to send and recipient(s) of the message.
	 * @param dest : ArrayList<String>
	 * @param msg : String
	 */
	public void sendMessage(ArrayList<String> dest, String msg) {
		try {
			this.usender.sendMessage(dest, msg);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	/**
	 * FOR UDP RECEIVER
	 */
	
	/**
	 * processHello() : if the hostname of the emitter of the Hello is not ourself, call the sendHelloAck() method.
	 * It give it the hostname of the recipient of the HelloAck (or the emitter of the Hello)
	 * Call the addToUserList of Controller object and  give it the hostname of the emitter of the Hello.
	 * @param hostname : String
	 */
	public void processHello(String hostname){
		if (!this.hostname.equals(hostname)) {
			sendHelloAck(hostname);
			this.controller.addToUserList(hostname);
			System.out.println("Envoie de Helloack");
		}
		
	}
	
	/**
	 * processHelloAck() : call the addToUserList of the Controller object and give it the hostname of the emitter of the HelloAck.
	 * @param hostname : String
	 */
	public void processHelloAck(String hostname){
		this.controller.addToUserList(hostname);
	}
	
	/**
	 * processGoodbye : call the removeToUserList of the Controller object and give it the hostname of the emitter of the Goodbye.
	 * @param hostname : String
	 */
	public void processGoodbye(String hostname){
		this.controller.removeFromUserList(hostname);
	}
	
	/**
	 * processMessage : call the messageReceived of the Controller object 
	 * and give it the hostname of the emitter of the message, the message and the list of all the recipient of this message.
	 * @param hostname : String
	 * @param msg : String
	 * @param listDest : ArrayList<String>
	 */
	public void processMessage(String hostname, String msg, ArrayList<String> listDest){
		this.controller.messageReceived(hostname, msg, listDest);
	}

	/**
	 * FOR TCP SENDER
	 */
	
		
	/**
	 * sendFile(): instantiate a new TCPSender object, and launch the thread of this object.
	 * @param file : File
	 * @param dest : ArrayList<String>
	 */
	public void sendFile(File file, ArrayList<String> dest) {
		TCPSender tsender = new TCPSender(this.hostname, dest, file, this.portTCP);
		tsender.start();
	}

	
	/**
	 * FOR TCP SERVER
	 */
	
	
	/**
	 * rcvdFile() : call the fileReceived method of the Controller object 
	 * and give it the hostname of the emitter of the fileMessage, the name of the file and the list of all the recipient of this FileMessage.
	 * @param hostSource : String
	 * @param fileName : String
	 * @param listDest : ArrayList<String>
	 */	
	public void rcvdFile(String hostSource, String fileName, ArrayList<String> listDest) {
		this.controller.fileReceived(hostSource, fileName, listDest);
	}
	
	
	
	/**
	 * DECONNEXION
	 */
	
	/**
	 * closeSocAndThreads() : close the Server socket of the TCPServer object,
	 * close Datagram sockets of the UDPSender and the UDPReceiver objects.
	 *  
	 */
	public void closeSocAndThreads () {
		try {
			tserver.getServer().close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		usender.getSoc().close();
		ureceiver.getServer().close();
		
	}
	
	/**
	 *  GETTERS AND SETTERS
	 */
	
	/**
	 * getHostname()
	 * @return hostname : String
	 */
	public String getHostname() {
		return hostname;
	}

	/**
	 * setHostname()
	 * @param hostname : String
	 */
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	
	/**
	 *getUsender() 
	 * @return usender : UDPSender
	 */
	public UDPSender getUsender() {
		return usender;
	}

	/**
	 * setUsender()
	 * @param usender : UDPSender
	 */
	public void setUsender(UDPSender usender) {
		this.usender = usender;
	}
	
	/**
	 * getUreceiver()
	 * @return ureceiver : UDPReceiver
	 */
	public UDPReceiver getUreceiver() {
		return ureceiver;
	}
	
	/**
	 * setUreceiver()
	 * @param ureceiver : UDPReceiver
	 */
	public void setUreceiver(UDPReceiver ureceiver) {
		this.ureceiver = ureceiver;
	}

	/**
	 * setSoc()
	 * @param soc DatagramSocket
	 */
	public void setSoc(DatagramSocket soc) {
		this.soc = soc;
	}
	
	/**
	 * getSoc()
	 * @return soc : DatagramSocket
	 */
	public DatagramSocket getSoc() {
		return soc;
	}
	
	/**
	 * getTserver()
	 * @return tserver : TCPServer
	 */
	public TCPServer getTserver() {
		return tserver;
	}

	/**
	 * setTserver()
	 * @param tserver TCPServer
	 */
	public void setTserver(TCPServer tserver) {
		this.tserver = tserver;
	}
	
}
