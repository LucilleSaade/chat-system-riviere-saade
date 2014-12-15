package Model;


import javax.swing.DefaultListModel;

import Controller.Controller;

public class DataModel extends DefaultListModel {

	private User localUser ;
	private Controller controller;
	
	/**
	 * 
	 * @param User localUser
	 * @param Controller c
	 */
	public DataModel(User localUser, Controller c) {
		this.controller = c ;
		this.setLocalUser(localUser);
	}	
	
	public void addToList (String u) {
		this.addElement(u);
	}
	
	public void removeFromList (String u) {
		this.removeElement(u);
	}

	/* Local user methods */
	
	public User getLocalUser() {
		return localUser;
	}

	public void setLocalUser(User localUser) {
		this.localUser = localUser;
	}


}
