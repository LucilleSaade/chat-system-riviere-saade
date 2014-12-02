package Model;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import Controller.Controller;

public class DataModel extends Observable {
	
	private User localUser ;
	private Controller controller;
	private ArrayList<User> userList ;
	private String typeModification ;
	
	public DataModel(User localUser, Controller c) {
		this.controller = c ;
		this.setLocalUser(localUser);
		this.setUserList(new ArrayList<User>());
		this.typeModification = "Add" ;
		this.addObserver(c.getGui().getConnectedWindow().getUl());
	}
	
	/* UserList methods */
	
	public void notifyAdd(User u) {
		this.typeModification = "Add" ;
        this.notifyObservers(u);
	}
	
	public void addToList (User u) {
		userList.add(u);
		setChanged();
		notifyAdd(u);
	}
	
	public void notifyRemove(User u) {
		this.typeModification = "Remove" ;
        this.notifyObservers(u);
	}
	
	public void removeFromList (User u) {
		userList.remove(u);
		setChanged();
        this.notifyRemove(u);
	}
	
	public User getUserByHostname(String hostname) {
		boolean trouve = false;
		User u;
		int i = 0;
		while (!trouve && i <= userList.size()) {
			if (userList.get(i).getHostName().equals(hostname)) {
				u = userList.get(i);
				trouve = true;
				return userList.get(userList.indexOf(u));
			}
		}
		System.out.println("Erreur getUserByHostname : Utilisateur non trouve");
		return null;		
	}
	

	public ArrayList<User> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}
	
	/* Local user methods */
	
	public User getLocalUser() {
		return localUser;
	}

	public void setLocalUser(User localUser) {
		this.localUser = localUser;
	}

	public String getTypeModification() {
		return typeModification;
	}

	public void setTypeModification(String typeModification) {
		this.typeModification = typeModification;
	}


}
