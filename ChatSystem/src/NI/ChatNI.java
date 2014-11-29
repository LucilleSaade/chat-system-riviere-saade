package NI;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.UnknownHostException;

import Controller.Controller;


public class ChatNI {
	
	private String hostname;
	private Controller controller;
	private UDPSender usender;
	private UDPReceiver ureceiver;
	protected DatagramSocket soc ;

	
	private int port = 9876;
	
	

	public ChatNI(Controller control) {
		try {
			this.controller = control;
			this.hostname = this.controller.getModel().getLocalUser().getNickname() ;
			this.soc = new DatagramSocket(this.port);
			this.soc.setBroadcast(true);
			this.usender = new UDPSender(this.hostname, this.port, soc);
			this.ureceiver = new UDPReceiver(this, this.hostname, soc);	

			ureceiver.start();
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

	public void sendMessage() {
		//this.usender.sendMessage();
	}

	
	
	//////////////////////////////////////////
	//          POUR UDP RECEIVER           //
	//////////////////////////////////////////

	public void processHello(String hostname){
		//this.controller.addToUser(hostname);
		sendHelloAck(hostname);
	}
	
	public void processHelloAck(String hostname){
		this.controller.addToUser(hostname);
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

	public void setNickname(String hostname) {
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
}
