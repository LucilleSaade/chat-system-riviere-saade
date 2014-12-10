package NI;

import java.io.File;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;

import Controller.Controller;


public class ChatNI {
	
	private String hostname;
	private Controller controller;
	private UDPSender usender;
	private UDPReceiver ureceiver;
	private TCPServer tserver;
	private DatagramSocket soc;
	
	private int portUDP = 9876;
	private int portTCP = 6789;
	
	

	public ChatNI(Controller control) {
		try {
			this.controller = control;
			this.hostname = this.controller.getModel().getLocalUser().getHostName();
			this.soc = new DatagramSocket(this.portUDP);
			this.soc.setBroadcast(true);
			this.usender = new UDPSender(this.hostname, this.portUDP, this.soc);
			this.ureceiver = new UDPReceiver(this, this.soc);
			this.tserver = new TCPServer(new ServerSocket(portTCP), this.hostname, this.portTCP, this);
			ureceiver.start(); // TODO
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//////////////////////////////////////////
	//          POUR UDP SENDER             //
	//////////////////////////////////////////
	
	public void sendHello() {
		try {
			this.usender.sendHello();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendHelloAck(String hostname) {
		try {
			this.usender.sendHelloAck(hostname);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sendGoodbye() {
		try {
			this.usender.sendGoodbye();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sendMessage(ArrayList<String> dest, String msg) {
		try {
			this.usender.sendMessage(dest, msg);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	//////////////////////////////////////////
	//          POUR UDP RECEIVER           //
	//////////////////////////////////////////

	public void processHello(String hostname){
		if (!this.hostname.equals(hostname)) {
			sendHelloAck(hostname);
			this.controller.addToUserList(hostname);
			System.out.println("Envoie de Helloack");
		}
		
	}
	
	public void processHelloAck(String hostname){
		this.controller.addToUserList(hostname);
	}
	
	public void processGoodbye(String hostname){
		this.controller.removeFromUserList(hostname);
	}
	
	public void processMessage(String hostname, String msg, ArrayList<String> listDest){
		this.controller.messageReceived(hostname, msg, listDest);
	}

	
	//////////////////////////////////////////
	//           POUR TCP SENDER            //
	//////////////////////////////////////////
	
	public void sendFile(File file, ArrayList<String> dest) {
		TCPSender tsender = new TCPSender(this.hostname, dest, file, this.portTCP);
		tsender.start();
	}

	
	
	
	//////////////////////////////////////////
	//           POUR TCP SERVER            //
	//////////////////////////////////////////
	
	public void rcvdFile(String hostSource, String fileName) {
		this.controller.fileReceived(hostSource, fileName);
	}
	
	
	
	//////////////////////////////////////////
	//         GETTER ET SETTER             //
	//////////////////////////////////////////

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	
	public UDPSender getUsender() {
		return usender;
	}

	public void setUsender(UDPSender usender) {
		this.usender = usender;
	}
	
	public UDPReceiver getUreceiver() {
		return ureceiver;
	}

	public void setUreceiver(UDPReceiver ureceiver) {
		this.ureceiver = ureceiver;
	}


	public void setSoc(DatagramSocket soc) {
		this.soc = soc;
	}
	
	public DatagramSocket getSoc() {
		return soc;
	}
	
	public TCPServer getTserver() {
		return tserver;
	}

	public void setTserver(TCPServer tserver) {
		this.tserver = tserver;
	}
	
}
