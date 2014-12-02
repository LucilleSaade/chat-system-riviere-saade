package Controller;

import Model.*;
import NI.*;
import GUI.*;

public class Controller {
	
	private ChatNI ni;
	private ChatGUI gui;
	private DataModel model ;
	
	public Controller () {
		this.gui = new ChatGUI(this);
	}
	
	//////////////////////////////////////////
	//       CONNEXION / DECONNEXION        //
	//////////////////////////////////////////
	
	public void performConnect(String hostname) {
		model = new DataModel(new User(hostname), this);
		// fermeture de la disconnect window
		this.gui.getDisconnectedWindow().dispose();
		// ouverture de la connected window
		this.gui.setConnectedWindow(new ConnectedWindow(this));
		this.ni = new ChatNI(this);
		sendHello();
	}
	
	public void performDisconnect() {
		sendGoodbye();
		// fermeture de la connected window
		this.getGui().getConnectedWindow().dispose() ;
		// TODO : fermer threads / sockets ??
		System.exit(0);
	}
	
	
	
	//////////////////////////////////////////
	//       A DESTINATION CHATNI           //
	//////////////////////////////////////////	

	public void sendHello() {
		System.out.println("Envoie de Hello");
		this.ni.sendHello();
	}
	

	public void sendGoodbye() {
		System.out.println("Envoi de Goodbye");
		this.ni.sendGoodbye();
	}
	
	//public void sendMessage() { }
	
	
	//////////////////////////////////////////
	//       A DESTINATION DE CHATGUI       //
	//////////////////////////////////////////
	
	public void addToUserList(String hostname) {
		this.model.addToList(new User(hostname));
		this.gui.getConnectedWindow().notifyConnection(hostname);
	}
	
	public void removeFromUserList(String hostname) {
		this.model.removeFromList(this.model.getUserByHostname(hostname));
		this.gui.getConnectedWindow().notifyDisconnection(hostname);
	}
	
	public void messageReceived(String hostname, String msg) {
		this.model.getLocalUser().addMessage(hostname, msg);
	}
	
	
	//////////////////////////////////////////
	//           GETTER ET SETTER           //
	//////////////////////////////////////////
	
	public DataModel getModel() {
		return model;
	}

	public void setModel(DataModel model) {
		this.model = model;
	}

	
	public ChatNI getNI() {
		return ni;
	}
	
	public void setNI(ChatNI ni) {
		this.ni = ni;
	}
		
	
	public ChatGUI getGui() {
		return gui;
	}
	
	public void setGui(ChatGUI gui) {
		this.gui = gui;
	}
	
}
