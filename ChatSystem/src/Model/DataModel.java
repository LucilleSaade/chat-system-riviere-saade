package Model;

import java.util.ArrayList;

public class DataModel {
	
	private User localUser ;
	private ArrayList<User> userList ;
	
	public DataModel(User localUser) {
		this.setLocalUser(localUser);
		this.setUserList(new ArrayList<User>());
	}
	
	/* UserList methods */
	
	public void addToList (User u) {
		userList.add(u);
	}
	
	public void removeFromList (User u) {
		userList.remove(u);
	}
	
	public void getUser(User u) {
		userList.get(userList.indexOf(u));
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
	
}
