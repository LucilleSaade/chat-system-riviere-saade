package GUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JList;

import Model.User;

public class UserList implements MouseListener {
	
	private JList<User> userList;
	
	public UserList() {
		this.setUserList(new JList<User>());
	}
	

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	/* GETTERS AND SETTERS */

	public JList<User> getUserList() {
		return userList;
	}

	public void setUserList(JList<User> userList) {
		this.userList = userList;
	}


}
