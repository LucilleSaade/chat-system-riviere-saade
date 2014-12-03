package GUI;

import javax.swing.JList;

import Controller.Controller;

public class VisualUserList extends JList {
	
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
	
}
