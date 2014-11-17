import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import NI.*;


public class ChatSystem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			UDPSender sender;
			try {
				sender = new UDPSender("lucille");
				sender.send(sender.sendHello());
			} catch (SocketException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
