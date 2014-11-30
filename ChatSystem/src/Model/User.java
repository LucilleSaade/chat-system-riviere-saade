package Model;

import java.util.ArrayList;
import java.util.Observable;

public class User extends Observable {
	
	private String hostName;
	private ArrayList<Message> messages;
	
	public User (String hostName) {
		this.setHostName(hostName);
		this.messages = new ArrayList<Message>();
	}
	
	public void addMessage (String hostname, String msg) {
		TxtMessage m = new TxtMessage(hostname,msg);
		messages.add(m);
		setChanged();
		notifyObservers(m);
	}
	
	public void addFile (String hostname, byte[]File) {
		// TODO
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
