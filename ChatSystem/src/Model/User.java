package Model;

import java.util.ArrayList;
import java.util.Observable;

import Controller.Controller;

public class User extends Observable {
	
	private String hostName;
	private Controller controller;
	private ArrayList<Message> messages;
	
	/**
	 * User constructor
	 * @param hostName
	 * @param controller
	 */
	public User (String hostName, Controller controller) {
		this.controller = controller;
		this.setHostName(hostName);
		this.messages = new ArrayList<Message>();
	}

	/**
	 * addObserverToHistArea
	 * add an observer to the historic area
	 */
	public void addObserverToHistArea () {
		this.addObserver(this.controller.getGui().getConnectedWindow().getHistoricArea());
	}
	
	/**
	 * addReceivedMessage
	 * add the received message to the model 
     * add the message to the historic area thanks to the observer
	 * @param hostname : user who sent the message
	 * @param msg : received message
	 * @param listDest : recipients of the message
	 */
	public void addReceivedMessage(String hostname, String msg, ArrayList<String> listDest){
		ModelTxtMessage m = new ModelTxtMessage(hostname,msg);
		for (String host : listDest)
			m.addDest(host);
		this.messages.add(m);
		setChanged();
		notifyObservers(m);
	}
	

	/**
	 * addReceivedFile
	 * add the received file to the model 
     * add the file received notification to the historic area thanks to the observer
	 * @param hostname : user who sent the message
	 * @param fileName : name of the received file
	 * @param listDest : recipients of the message
	 */
	public void addReceivedFile(String hostname, String fileName, ArrayList<String> listDest) {
		ModelFileMessage m = new ModelFileMessage(hostname, fileName);
		for (String host : listDest)
			m.addDest(host);
		messages.add(m);
		setChanged();
		notifyObservers(m);
	}
	
	/**
	 * addTxtMessage
	 * add the ModelTxtMessage m to the model and the historic area
	 * @param ModelTxtMessage m
	 */
	public void addTxtMessage (ModelTxtMessage m) {
		messages.add(m);
		setChanged();
		notifyObservers(m);
	}
	
	/**
	 * addSentFile
	 * add the ModelFileMessage m to the model and the historic area
	 * @param ModelFileMessage m
	 */
	public void addSentFile (ModelFileMessage f) {
		messages.add(f);
		setChanged();
		notifyObservers(f);
	}
	

	
	//////////////////////////////////////////
	//         GETTER ET SETTER             //
	//////////////////////////////////////////

	/**
	 *  getHostName() 
	 * @return String hostName
	 */
	public String getHostName() {
		return hostName;
	}

	/**
	 * setHostName
	 * @param String hostName
	 */
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	
	/**
	 * getMessages()
	 * @return ArrayList<Message> messages
	 */
	public ArrayList<Message> getMessages() {
		return messages;
	}

	/**
	 * setMessages
	 * @param ArrayList<Message> messages
	 */
	public void setMessages(ArrayList<Message> messages) {
		this.messages = messages;
	}


}
