package NI;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.DatagramSocket;
import java.net.SocketException;

import Signals.*;


public class UDPSender {

	private String nickname;
	private ByteArrayOutputStream bos;
	private DatagramSocket soc;


	public UDPSender(String nickname) throws SocketException{
		this.nickname = nickname;
		this.bos = new ByteArrayOutputStream();
		this.soc = new DatagramSocket();
	}
	
	public void send(AbstractMessage obj) {
		ObjectOutput out = null;
		try {
		  out = new ObjectOutputStream(this.bos);   
		  out.writeObject(obj);
		  byte[] bufOut = bos.toByteArray();
		
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
	
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}