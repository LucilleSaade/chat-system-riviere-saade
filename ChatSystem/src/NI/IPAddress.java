package NI;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class IPAddress {

	public static String getIPaddress(String nickname) {
		return nickname.substring(nickname.indexOf('@')+1);
	}
	
	public static String getNickname(String nickname) {
		return nickname.substring(0, nickname.indexOf('@'));
	}
	
	// Renvoie un nickname = "name@IP_du_localhost"
	public static String concatLocalhostIP(String name) throws UnknownHostException, SocketException {
		String hostname = "0";
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
			        	hostname = name + "@" + ia.getHostAddress();
			        	System.out.println(hostname);
			    }
		    }
		 }
		return hostname;
	}
	
}
