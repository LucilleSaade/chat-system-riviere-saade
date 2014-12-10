package NI;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;

import Signals.*;


public class UDPReceiver extends Thread {
	
	private ChatNI ni;
	private DatagramSocket server ;
	private byte[] bufIn;
	

	public UDPReceiver(ChatNI n, DatagramSocket soc) throws IOException {
		this.ni = n;
        this.server = soc;
        bufIn = new byte[5000];
	}
	
	public void run() {
		ObjectInput in = null;
		ByteArrayInputStream byteIn = new ByteArrayInputStream(bufIn);
		try {
			
			while (true) { 
				// le socket bloque jusqu'a ce qu'il recoive un DatagramPacket			
				DatagramPacket packet = new DatagramPacket(bufIn, bufIn.length);
				this.server.receive(packet);
				
				// Traitement du packet pour le re-transformer en AbstractMessage
				byteIn.reset();
				in = new ObjectInputStream(byteIn);
				AbstractMessage aMessage = (AbstractMessage) in.readObject();

				if (aMessage.getTypeContenu() == typeContenu.HELLO){
					Hello helloSerialise = (Hello) aMessage;
					System.out.println(helloSerialise.getNickname() + " : C'est un HELLO ! " );
					this.ni.processHello(helloSerialise.getNickname());
				} else if (aMessage.getTypeContenu() == typeContenu.HELLOACK) {
					HelloAck helloackSerialise = (HelloAck) aMessage;
					System.out.println(helloackSerialise.getNickname() + " : C'est un HELLOACK ! " );
					this.ni.processHelloAck(helloackSerialise.getNickname());
				} else if (aMessage.getTypeContenu() == typeContenu.GOODBYE) {
					Goodbye goodbyeSerialise = (Goodbye) aMessage;
					System.out.println(goodbyeSerialise.getNickname() + " : C'est un GOODBYE ! ");
					this.ni.processGoodbye(goodbyeSerialise.getNickname());
				} else if (aMessage.getTypeContenu() == typeContenu.TEXTMESSAGE) {
					TextMessage msg = (TextMessage) aMessage;
					System.out.println(msg.getNickname() + ":" + msg.getMessage());
					ArrayList<String> listNicknamesDest = msg.getListNicknamesDest();
					this.ni.processMessage(msg.getNickname(), msg.getMessage(), listNicknamesDest);
				}
			}
		} catch (SocketException e) {
			this.interrupt();
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
