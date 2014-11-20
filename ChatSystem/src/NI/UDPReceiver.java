package NI;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import Signals.*;


public class UDPReceiver extends Thread {
	
	private String nickname;
	private InetAddress address ;
	private DatagramSocket server ;
	private byte[] bufIn;
	private int recvPort;
	

	public UDPReceiver(String nick, int port) throws IOException {
		this.nickname = nick;
		this.recvPort = port;
        this.server = new DatagramSocket(this.recvPort, address);
        bufIn = new byte[5000];
	}
	
	public void start() {
		ObjectInput in = null;
		try {
			// le socket bloque jusqu'a ce qu'il re coive un DatagramPacket
			DatagramPacket packet = new DatagramPacket(bufIn, bufIn.length);
			this.server.receive(packet);
			
			// Traitement du packet pour le re-transformer en AbstractMessage
			ByteArrayInputStream byteIn = new ByteArrayInputStream(bufIn);
			in = new ObjectInputStream(byteIn);
			AbstractMessage aMessage = (AbstractMessage) in.readObject();
		  
			if (aMessage.getTypeContenu() == typeContenu.HELLO){
				Hello helloSerialise = (Hello) aMessage;
				System.out.println(helloSerialise.getNickname() + " : C'est un HELLO ! " );
			} else if (aMessage.getTypeContenu() == typeContenu.HELLOACK) {
				HelloAck helloackSerialise = (HelloAck) aMessage;
				System.out.println(helloackSerialise.getNickname() + " : C'est un HELLOACK ! " );
			} else if (aMessage.getTypeContenu() == typeContenu.GOODBYE) {
				Goodbye GoodbyeSerialise = (Goodbye) aMessage;
				System.out.println(GoodbyeSerialise.getNickname() + " : C'est un GOODBYE ! ");
			} else if (aMessage.getTypeContenu() == typeContenu.TEXTMESSAGE) {
				TextMessage msg = (TextMessage) aMessage;
				System.out.println(msg.getNickname() + ":" + msg.getMessage());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	  
	}
	
	
	
	
	//////////////////////////////////////////
	//         GETTER ET SETTER             //
	//////////////////////////////////////////

	public DatagramSocket getServer() {
		return server;
	}

	public void setServer(DatagramSocket server) {
		this.server = server;
	}
	
} 
