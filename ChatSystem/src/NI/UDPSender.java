package NI;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import Signals.*;


public class UDPSender {

	private String nickname;
	private ByteArrayOutputStream bos;
	private DatagramSocket soc;
	private int destPort;


	public UDPSender(String hostname, int port, DatagramSocket soc) throws SocketException{
		this.nickname = hostname;
		this.bos = new ByteArrayOutputStream(5000);
		this.soc = soc;
		this.destPort = port;
	}
	
	public void sendTo(AbstractMessage obj, String hostname) {
		ObjectOutput out = null;
		InetAddress address;
		String remoteIp;
		try {
			//(obj.getTypeContenu() == typeContenu.HELLO) | (obj.getTypeContenu() == typeContenu.GOODBYE)
			if (hostname == "default") {
				address = InetAddress.getByName("255.255.255.255");
			} else {
				// Preparation de l'adresse destinataire au bon format
				remoteIp = IPAddress.getIPaddress(hostname);
				address = InetAddress.getByName(remoteIp);
				System.out.println(address);
			}
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
	
	public AbstractMessage sendHello() throws UnknownHostException {
		AbstractMessage hello = new Hello(IPAddress.concatLocalhostIP(this.nickname));
		sendTo(hello, "default");
		return hello;
	}

	public AbstractMessage sendHelloAck(String hostname) throws UnknownHostException {
		AbstractMessage hello = new HelloAck(IPAddress.concatLocalhostIP(this.nickname));
		sendTo(hello, hostname);
		return hello;
	}
	
	public AbstractMessage sendGoodbye() throws UnknownHostException {
		AbstractMessage bye = new Goodbye(IPAddress.concatLocalhostIP(this.nickname));
		sendTo(bye, "default");
		return bye;
	}
	
	public AbstractMessage sendMessage(ArrayList<String> Dest, String contenu) throws UnknownHostException {
		AbstractMessage msg = new TextMessage(IPAddress.concatLocalhostIP(this.nickname), contenu, Dest);
		
		ListIterator<String> itr = Dest.listIterator();
		while(itr.hasNext()){
			sendTo(msg, itr.next());
		}
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