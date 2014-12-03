package GUI;

import java.util.Observable;
import java.util.Observer;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import Model.*;

public class VisualUserList implements Observer {
	
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
				System.out.println("arg est un user");
				User u = (User)arg;
				if (typeModif.equals("Add")) { 
					model.addElement(u.getHostName());
					System.out.println("add");
				}
				else if (typeModif.equals("Remove")) {
					model.removeElement(u.getHostName());
					System.out.println("remove");
				}
				System.out.println("userlist modifee");
				this.userList = new JList(model);
			}
		}
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

	public DefaultListModel getModel() {
		return model;
	}

	public void setModel(DefaultListModel model) {
		this.model = model;
	}






}
