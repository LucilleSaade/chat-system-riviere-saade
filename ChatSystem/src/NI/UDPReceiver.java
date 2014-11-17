package NI;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;

import Signals.*;


public class UDPReceiver extends Thread {
	
	private int port ;
	private InetAddress address ;
	private ServerSocket server ;
	private String nickname; 
	private byte[] bufIn;
	

	public UDPReceiver() throws IOException {
        this.server = new ServerSocket(9876, 20, address);
	}
	
	public void start() {
		ObjectInput in = null;
		try {
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

	public ServerSocket getServer() {
		return server;
	}

	public void setServer(ServerSocket server) {
		this.server = server;
	}
	
} 
