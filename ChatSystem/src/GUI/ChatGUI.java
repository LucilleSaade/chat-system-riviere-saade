package GUI;

import Controller.Controller;

public class ChatGUI {
	
	private DisconnectedWindow disconnectedWindow ;
	private ConnectedWindow connectedWindow ;
	private Controller controller;
	
	public ChatGUI (/*Controller control*/) {
		//this.controller = control;
		this.disconnectedWindow = new DisconnectedWindow();
		//this.connectedWindow = new ConnectedWindow();
	}

}
