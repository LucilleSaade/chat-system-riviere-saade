package NI;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class IPAddress {

	/**
	 * Class which is used to manage the form of the nickname ("name@IP")
	 */
	
	
	
	/**
	 * getIPadress() : return the IPadress of an host from his nickname (nickname = "name@IPadress")
	 * @param nickname : String
	 * @return String
	 */
	public static String getIPaddress(String nickname) {
		return nickname.substring(nickname.indexOf('@')+1);
	}
	
	/**
	 * getNickname() : return the name of an host from his nickname  (nickname = "name@IPadress")
	 * @param nickname : String
	 * @return nickname : String
	 */
	public static String getNickname(String nickname) {
		return nickname.substring(0, nickname.indexOf('@'));
	}
	
	
	/**
	 * concatLocalhostIP() : return a nickname constitute like "name@IP"
	 * @param name : String
	 * @return nickname : String
	 * @throws UnknownHostException
	 * @throws SocketException
	 */
	// Renvoie un nickname = "name@IP_du_localhost"
	public static String concatLocalhostIP(String name) throws UnknownHostException, SocketException {
		
		boolean find = false;
		String hostname = "0";
		Enumeration en = NetworkInterface.getNetworkInterfaces();
		
		while(en.hasMoreElements()){
		    NetworkInterface ni=(NetworkInterface) en.nextElement();
		    Enumeration ee = ni.getInetAddresses();
		    while(ee.hasMoreElements()) {
		    	while(ee.hasMoreElements()) {
			        InetAddress ia= (InetAddress) ee.nextElement();
			        if(!ia.isLoopbackAddress() & !ia.isLinkLocalAddress() & !find){
			        	hostname = name + "@" + ia.getHostAddress();
			        	find = true;
			        }
			    }
		    }
		 }
		return hostname;
	}
	
}
