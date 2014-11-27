package NI;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.UnknownHostException;

import Controller.Controller;


public class ChatNI {
	
	private String nickname;
	private Controller controller;
	private UDPSender usender;
	private UDPReceiver ureceiver;
	protected DatagramSocket soc ;

	
	private int port = 9876;
	
	

	public ChatNI(/*Controller control*/) {
		try {
			this.nickname = "lucille";
			//this.controller = control;
			this.soc = new DatagramSocket(this.port);
			this.soc.setBroadcast(true);
			this.usender = new UDPSender(this.nickname, this.port, soc);
			this.ureceiver = new UDPReceiver(this, this.nickname, soc);	

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
	
	// A regler comment savoir pour quel dest et quel message. Probablement qu'on doit le récupérer d'un signal entre Chat GUI et NI.
	public void sendHello() {
		try {
			this.usender.sendHello();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendHelloAck() {
		try {
			this.usender.sendHelloAck();
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
		//this.usender.sendTo(usender.sendMessage(),"localhost");
	}

	
	
	//////////////////////////////////////////
	//          POUR UDP RECEIVER           //
	//////////////////////////////////////////

	public void processHello(String remoteNickname){
		this.controller.addToUser(remoteNickname);
	}
	
	public void processHelloAck(String remoteNickname){
		this.controller.addToUser(remoteNickname);
	}
	
	public void processGoodbye(String remoteNickname){
		this.controller.removeFromUserList(remoteNickname);
	}
	
	
	//////////////////////////////////////////
	//         GETTER ET SETTER             //
	//////////////////////////////////////////

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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
