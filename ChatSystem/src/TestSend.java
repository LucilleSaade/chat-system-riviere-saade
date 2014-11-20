import java.net.SocketException;

import NI.*;


public class TestSend {


	public static void main(String[] args) {
		
			UDPSender sender;
			try {
				sender = new UDPSender("lucille", 9876);
				sender.sendTo(sender.sendGoodbye(),"localhost");
			} catch (SocketException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
