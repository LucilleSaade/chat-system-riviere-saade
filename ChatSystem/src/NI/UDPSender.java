package NI;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;

import Signals.*;


public class UDPSender {

	private String nickname;
	private ByteArrayOutputStream bos;
	private DatagramSocket soc;
	private int destPort;


	public UDPSender(String nickname, int port) throws SocketException{
		this.nickname = nickname;
		this.bos = new ByteArrayOutputStream(5000);
		this.soc = new DatagramSocket();
		this.destPort = port;
	}
	
	public void sendTo(AbstractMessage obj, String hostname) {
		ObjectOutput out = null;
		try {
			// Preparation de l'adresse destinataire au bon format
			InetAddress address = InetAddress.getByName(hostname);
			
			// Serialisation de l'obj a envoyer
			out = new ObjectOutputStream(this.bos);
			out.flush();
			out.writeObject(obj);
			out.flush();
			byte[] bufOut = bos.toByteArray();
			
			// Transformation en DatagramPacket
			DatagramPacket packet = new DatagramPacket(bufOut, bufOut.length, address, this.destPort);
		
			// Envoie du packet par le socket
			soc.send(packet);
			out.close();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	 
	}
	
	public AbstractMessage sendHello() {
		AbstractMessage hello = new Hello(this.nickname);
		return hello;
	}

	public AbstractMessage sendHelloAck() {
		AbstractMessage hello = new HelloAck(this.nickname);
		return hello;
	}
	
	public AbstractMessage sendGoodbye() {
		AbstractMessage bye = new Goodbye(this.nickname);
		return bye;
	}
	
	public AbstractMessage sendMessage(ArrayList<String> Dest, String contenu) {
		AbstractMessage msg = new TextMessage(this.nickname, contenu, Dest);
		return msg;
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