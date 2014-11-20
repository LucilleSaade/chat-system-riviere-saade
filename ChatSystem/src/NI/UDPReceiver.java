package NI;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;

import Signals.*;


public class UDPReceiver extends Thread {
	
	private int port = 9876 ;
	private InetAddress address ;
	private DatagramSocket server ;
	private String nickname; 
	private byte[] bufIn;
	

	public UDPReceiver() throws IOException {
        this.server = new DatagramSocket(this.port, address);
        bufIn = new byte[5000];
	}
	
	public void start() {
		ObjectInput in = null;
		try {
			// le socket bloque jusqu'a ce qu'il recoive un DatagramPacket
			DatagramPacket packet = new DatagramPacket(bufIn, bufIn.length);
			this.server.receive(packet);
			
			// Traitement du packet pour le re-transformer en AbstractMessage
			ByteArrayInputStream byteIn = new ByteArrayInputStream(bufIn);
			in = new ObjectInputStream(byteIn);
			AbstractMessage aMessage = (AbstractMessage) in.readObject();
		  
			if (aMessage.getTypeContenu() == typeContenu.HELLO){
				Hello helloSerialise = (Hello) aMessage;
				System.out.println("C'est un HELLO ! " + helloSerialise.getNickname());
			} else if (aMessage.getTypeContenu() == typeContenu.HELLOACK) {
				HelloAck helloackSerialise = (HelloAck) aMessage;
				System.out.println("C'est un HELLOACK ! " + helloackSerialise.getNickname());
			} else if (aMessage.getTypeContenu() == typeContenu.GOODBYE) {
				Goodbye GoodbyeSerialise = (Goodbye) aMessage;
				System.out.println("C'est un GOODBYE ! " + GoodbyeSerialise.getNickname());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	  
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public DatagramSocket getServer() {
		return server;
	}

	public void setServer(DatagramSocket server) {
		this.server = server;
	}
	
} 
