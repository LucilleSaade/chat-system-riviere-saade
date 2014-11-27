package NI;

public class IPAddress {

	public static String getIPaddress(String nickname) {
		return nickname.substring(nickname.indexOf('@')+1);
	}
	
	public static String getnickname(String nickname) {
		return nickname.substring(0, nickname.indexOf('@'));
	}
	
	
}
