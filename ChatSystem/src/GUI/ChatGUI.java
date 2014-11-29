package GUI;

import Controller.Controller;

public class ChatGUI {
	
	private DisconnectedWindow disconnectedWindow ;
	private ConnectedWindow connectedWindow ;
	private Controller controller;
	
	public ChatGUI (Controller control) {
		this.controller = control;
		this.setDisconnectedWindow(new DisconnectedWindow(control));
	}

	public DisconnectedWindow getDisconnectedWindow() {
		return disconnectedWindow;
	}

	public void setDisconnectedWindow(DisconnectedWindow disconnectedWindow) {
		this.disconnectedWindow = disconnectedWindow;
	}

	public ConnectedWindow getConnectedWindow() {
		return connectedWindow;
	}

	public void setConnectedWindow(ConnectedWindow connectedWindow) {
		this.connectedWindow = connectedWindow;
	}

}
