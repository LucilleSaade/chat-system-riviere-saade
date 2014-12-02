package GUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import Model.*;

public class VisualUserList implements MouseListener , Observer {
	
	private JList userList;
	private DefaultListModel model;
	
	public VisualUserList() {
		this.setUserList(new JList());
		this.model = new DefaultListModel();
	}
	
	public void update(Observable o, Object arg) {
		System.out.println("update");
		if (o instanceof DataModel) {
			System.out.println("o est un datamodel");
			String typeModif = ((DataModel) o).getTypeModification();
			if (arg instanceof User) {
				System.out.println("arf est un user");
				User u = (User)arg;
				if (typeModif.equals("Add")) 
					model.addElement(u.getHostName());
				else if (typeModif.equals("Remove"))
					model.removeElement(u.getHostName());
				this.userList = new JList(model);
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

	public JList getUserList() {
		return userList;
	}

	public void setUserList(JList userList) {
		this.userList = userList;
	}






}
