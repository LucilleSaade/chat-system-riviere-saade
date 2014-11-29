package Model;

public class User {
	
	private String nickname;
	private String hostName;
	
	public User (String nickname, String hostName) {
		this.setNickname(nickname);
		this.setHostName(hostName);
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

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

}
