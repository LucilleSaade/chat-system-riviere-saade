import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

import Controller.Controller;
import NI.*;


public class TestNI {


	public static void main(String[] args) throws SocketException {
		int tour = 1;
		Enumeration en = NetworkInterface.getNetworkInterfaces();
		while(en.hasMoreElements()){
		    NetworkInterface ni=(NetworkInterface) en.nextElement();
		    System.out.println(ni.getName());
		    Enumeration ee = ni.getInetAddresses();
		    while(ee.hasMoreElements()) {
		    	while(ee.hasMoreElements()) {
			        InetAddress ia= (InetAddress) ee.nextElement();
			        System.out.println("coucou");
			        if(!ia.isLoopbackAddress() & !ia.isLinkLocalAddress())
			        	System.out.println(ia.getHostAddress());
			    }
		    }
		 }
	}

}
