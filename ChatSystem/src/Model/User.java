package Model;

import java.util.ArrayList;

public class User {
	
	private String hostName;
	private ArrayList<Message> messages;
	
	public User (String hostName) {
		this.setHostName(hostName);
		this.messages = new ArrayList<Message>();
	}
	
	public void addMessage (String hostname, String msg) {
		Message m = new Message(hostname,msg);
		messages.add(m);
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
	
	public ArrayList<Message> getMessages() {
		return messages;
	}

	public void setMessages(ArrayList<Message> messages) {
		this.messages = messages;
	}

}
