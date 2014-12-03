package GUI;

import java.util.Observable;
import java.util.Observer;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import Controller.Controller;
import Model.*;

public class VisualUserList extends JList {
	//implements Observer 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Controller c;
	
	public VisualUserList() {
		super();
	}
	
	public VisualUserList(Controller c) {
		super(c.getModel());
		this.c = c;
	}
	
	
	/*
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
	}*/

}
