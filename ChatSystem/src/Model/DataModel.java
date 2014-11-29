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
	
	public User getUserByNickname(String nick) {
		boolean trouve = false;
		User u;
		int i = 0;
		while (!trouve && i <= userList.size()) {
			if (userList.get(i).getNickname().equals(nick)) {
				u = userList.get(i);
				trouve = true;
				return userList.get(userList.indexOf(u));
			}
		}
		System.out.println("Erreur getUserByNickname : Utilisateur non trouve");
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


}
