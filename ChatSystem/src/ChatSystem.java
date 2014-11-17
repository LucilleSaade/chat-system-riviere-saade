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
		try {
			DatagramSocket socket = new DatagramSocket(9876, InetAddress.getByName("geitp105-03"));
		
			UDPSender sender = new UDPSender("lucille");
			sender.send(sender.sendHello());
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch( UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
