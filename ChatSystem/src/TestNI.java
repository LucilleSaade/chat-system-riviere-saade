import java.net.SocketException;
import java.net.UnknownHostException;

import Controller.Controller;
import NI.*;


public class TestNI {


	public static void main(String[] args) {
			
		/* tester le broadcast de hello !!!!!! */
		Controller c = new Controller();
		c.getNI().sendHello();
		
	}

}
