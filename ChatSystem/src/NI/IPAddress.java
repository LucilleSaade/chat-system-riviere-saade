package NI;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPAddress {

	public static String getIPaddress(String nickname) {
		return nickname.substring(nickname.indexOf('@')+1);
	}
	
	public static String getnickname(String nickname) {
		return nickname.substring(0, nickname.indexOf('@'));
	}
	
	// Renvoie un nickname = "name@IP_du_localhost"
	public static String concatLocalhostIP(String name) throws UnknownHostException {
		return name + "@" + InetAddress.getLocalHost().getHostName();
	}
	
}
