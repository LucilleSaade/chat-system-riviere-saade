package GUI;

import javax.swing.JList;

import Controller.Controller;

public class VisualUserList extends JList {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Controller c;
	
	/**
	 * VisualUserList constructor :
	 * creates a JList 
	 */
	public VisualUserList() {
		super();
	}
	
	/**
	 * VisualUserList constructor :
	 * creates a JList using a DefaultListModel
	 * @param controller
	 */
	public VisualUserList(Controller c) {
		super(c.getModel());
		this.c = c;
	}
	
}
