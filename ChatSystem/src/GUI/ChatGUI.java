package GUI;

import Controller.Controller;

public class ChatGUI {
	
	/**
	 * graphic interface
	 * composed of a disconnected window and a connected window
	 * knows the controller
	 */
	
	private DisconnectedWindow disconnectedWindow ;
	private ConnectedWindow connectedWindow ;
	private Controller controller;
	
	/**
	 * ChatGui constructor : 
	 * instantiate the controller and set the disconnected window
	 * @param control : controller
	 */
	public ChatGUI (Controller control) {
		this.controller = control;
		this.setDisconnectedWindow(new DisconnectedWindow(control));
	}
	
	//////////////////////////////////////////
	//         GETTER ET SETTER             //
	//////////////////////////////////////////
	
	/**
	 * getDisconnectedWindow()
	 * @return DisconnectedWindow 
	 */
	public DisconnectedWindow getDisconnectedWindow() {
		return disconnectedWindow;
	}

	/**
	 * setDisconnectedWindow()
	 * @param disconnectedWindow
	 */
	public void setDisconnectedWindow(DisconnectedWindow disconnectedWindow) {
		this.disconnectedWindow = disconnectedWindow;
	}
	
	
	/**
	 * getConnectedWindow
	 * @return ConnectedWindow
	 */
	public ConnectedWindow getConnectedWindow() {
		return connectedWindow;
	}

	/**
	 * setConnectedWindow
	 * @param connectedWindow
	 */
	public void setConnectedWindow(ConnectedWindow connectedWindow) {
		this.connectedWindow = connectedWindow;
	}

}
