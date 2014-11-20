package NI;

import java.io.IOException;
import java.net.SocketException;

import Controller.Controller;


public class ChatNI {
	
	private String nickname;
	private Controller controller;
	private UDPSender usender;
	private UDPReceiver ureceiver;
	
	private int uDestPort = 9876;
	private int uRecvPort = 9876;
	
	
	
	public ChatNI() {
		try {
			this.usender = new UDPSender(this.nickname, this.uDestPort);
			this.ureceiver = new UDPReceiver(this, this.nickname, this.uRecvPort);
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
		this.usender.sendTo(usender.sendHello(),"localhost");
	}
	
	public void sendHelloAck() {
		this.usender.sendTo(usender.sendHelloAck(),"localhost");
	}

	public void sendGoodbye() {
		this.usender.sendTo(usender.sendGoodbye(),"localhost");
	}

	public void sendMessage() {
		this.usender.sendTo(usender.sendMessage(),"localhost");
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
}
