package Model;

public class User {
	
	private String hostName;
	
	public User (String hostName) {
		this.setHostName(hostName);
	}
	
	//////////////////////////////////////////
	//         GETTER ET SETTER             //
	//////////////////////////////////////////

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

}
