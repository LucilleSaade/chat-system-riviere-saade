package NI;

import java.io.IOException;
import java.net.DatagramSocket;
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
	private TCPSender tsender;
	private DatagramSocket soc ;
	private Socket socTcp;
	
	private int portUDP = 9876;
	private int portTCP = 6789 ;
	
	

	public ChatNI(Controller control) {
		try {
			this.controller = control;
			this.hostname = this.controller.getModel().getLocalUser().getHostName();
			this.soc = new DatagramSocket(this.portUDP);
			this.socTcp = new Socket(this.hostname, this.port);
			this.soc.setBroadcast(true);
			this.usender = new UDPSender(this.hostname, this.portUDP, soc);
			this.ureceiver = new UDPReceiver(this, this.hostname, soc);	
			this.tserver = new TCPServer(this, this.hostname, socTcp);
			this.tsender = new TCPSender(this, this.hostname, socTcp);

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
	
	public void processMessage(String hostname, String msg){
		this.controller.messageReceived(hostname, msg);
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
	
	public Socket getSocTcp() {
		return socTcp;
	}

	public void setSocTcp(Socket socTcp) {
		this.socTcp = socTcp;
	}

	public TCPServer getTserver() {
		return tserver;
	}

	public void setTserver(TCPServer tserver) {
		this.tserver = tserver;
	}
	

	public TCPSender getTsender() {
		return tsender;
	}

	public void setTsender(TCPSender tsender) {
		this.tsender = tsender;
	}
}
