package Model;


import javax.swing.DefaultListModel;
import Controller.Controller;

public class DataModel extends DefaultListModel {

	/**
	 * Datamodel used to update dynamically the visual userlist
	 */
	private User localUser ;
	private Controller controller;
	
	/**
	 * DataModel(User localUser, Controller c) constructor
	 * @param User localUser
	 * @param Controller c
	 */
	public DataModel(User localUser, Controller c) {
		this.controller = c ;
		this.setLocalUser(localUser);
	}	
	
	/**
	 * addToList
	 * add the user u to the list
	 * @param String u
	 */
	public void addToList (String u) {
		this.addElement(u);
	}
	
	/**
	 * removeFromList 
	 * remove the user u from the list
	 * @param String u
	 */
	public void removeFromList (String u) {
		this.removeElement(u);
	}

	/* Local user methods */
	
	/**
	 * getLocalUser()
	 * @return User localUser
	 */
	public User getLocalUser() {
		return localUser;
	}

	/**
	 * setLocalUser
	 * @param User localUser
	 */
	public void setLocalUser(User localUser) {
		this.localUser = localUser;
	}


}
