package GUI;

import Controller.Controller;

public class ChatGUI {
	
	private DisconnectedWindow disconnectedWindow ;
	private ConnectedWindow connectedWindow ;
	private Controller controller;
	
	public ChatGUI (Controller control) {
		this.setController(control);
		this.setDisconnectedWindow(new DisconnectedWindow(control));
	}
	
	//////////////////////////////////////////
	//         GETTER ET SETTER             //
	//////////////////////////////////////////

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

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

}
