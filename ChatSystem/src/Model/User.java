package Model;

import java.util.ArrayList;
import java.util.Observable;

import Controller.Controller;

public class User extends Observable {
	
	private String hostName;
	private Controller controller;
	private ArrayList<Message> messages;
	private Message currentMessage ;
	private boolean currentMessageCree;
	
	public User (String hostName, Controller controller) {
		this.controller = controller;
		this.setHostName(hostName);
		this.messages = new ArrayList<Message>();
		this.currentMessageCree = false;		
	}
	
	public void addObserverToHistArea () {
		this.addObserver(this.controller.getGui().getConnectedWindow().getHistoricArea());
	}
	
	public void addReceivedMessage(String hostname, String msg){
		TxtMessage m = new TxtMessage(hostname,msg);
		m.addDest(this.hostName);
		this.messages.add(m);
		setChanged();
		notifyObservers(m);
	}
	
	public void addTxtMessage (TxtMessage m) {
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

	public Message getCurrentMessage() {
		return currentMessage;
	}

	public void setCurrentMessage(Message currentMessage) {
		this.currentMessage = currentMessage;
	}

	public boolean isCurrentMessageCree() {
		return currentMessageCree;
	}

	public void setCurrentMessageCree(boolean currentMessageCree) {
		this.currentMessageCree = currentMessageCree;
	}

}
