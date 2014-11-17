package GUI;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class UserList {
	
	private JPanel listPanel ;
	private String[] tabConnectedUsers = {} ;
	private JList userList;
	
	public UserList() {
		this.userList = new JList(tabConnectedUsers);
		this.listPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		this.listPanel.add(new JLabel("Utilisateurs connectés"));
		this.listPanel.add(new JScrollPane(userList)); 
	}
	
	/* GETTERS AND SETTERS */

	public JList getUserList() {
		return userList;
	}

	public void setUserList(JList userList) {
		this.userList = userList;
	}
	
	public JPanel getListPanel() {
		return listPanel;
	}

	public void setListPanel(JPanel listPanel) {
		this.listPanel = listPanel;
	}

	public String[] getTabConnectedUsers() {
		return tabConnectedUsers;
	}

	public void setTabConnectedUsers(String[] tabConnectedUsers) {
		this.tabConnectedUsers = tabConnectedUsers;
	}


}
