import java.net.SocketException;
import java.net.UnknownHostException;

import Controller.Controller;
import NI.*;


public class TestNI {


	public static void main(String[] args) {
		
			ChatNI ni = new ChatNI();
			try {
				ni.getUsender().sendHello();
				
				// = new UDPReceiver(9876);
				//recv.start();
				
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
