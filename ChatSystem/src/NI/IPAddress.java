package NI;

public class IPAddress {

	public String getIPaddress(String nickname) {
		return nickname.substring(nickname.indexOf('@')+1);
	}
	
	public String getnickname(String nickname) {
		return nickname.substring(0, nickname.indexOf('@'));
	}
	
	
}
