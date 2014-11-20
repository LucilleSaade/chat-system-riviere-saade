import java.io.IOException;
import java.net.SocketException;

import NI.*;


public class TestReceiver {


	public static void main(String[] args) {
		
			UDPReceiver recv;
			try {
				recv = new UDPReceiver(9876);
				recv.start();
			} catch (SocketException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
}
