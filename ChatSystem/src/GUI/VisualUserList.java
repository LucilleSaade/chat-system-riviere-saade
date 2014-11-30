package GUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import Model.*;

public class VisualUserList implements MouseListener , Observer {
	
	private JList<String> userList;
	private DefaultListModel<String> model;
	
	public VisualUserList() {
		this.setUserList(new JList<String>());
		this.model = new DefaultListModel<String>();
	}
	
	public void update(Observable o, Object arg) {
		
		if (o instanceof DataModel) {
			String typeModif = ((DataModel) o).getTypeModification();
			if (arg instanceof User) {
				User u = (User)arg;
				if (typeModif.equals("Add")) 
					model.addElement(u.getHostName());
				else if (typeModif.equals("Remove"))
					model.removeElement(u.getHostName());
				this.userList = new JList<String>(model);
			}
		}
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
	
	//////////////////////////////////////////
	//         GETTER ET SETTER             //
	//////////////////////////////////////////

	public JList<String> getUserList() {
		return userList;
	}

	public void setUserList(JList<String> userList) {
		this.userList = userList;
	}






}
