package Model;

import java.net.InetAddress;

public class User {
	
	private String nickname;
	private InetAddress address;
	
	public User (String nickname, InetAddress address) {
		this.setNickname(nickname);
		this.setAddress(address);
	}
	
	//////////////////////////////////////////
	//         GETTER ET SETTER             //
	//////////////////////////////////////////

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public InetAddress getAddress() {
		return address;
	}

	public void setAddress(InetAddress address) {
		this.address = address;
	}

}
