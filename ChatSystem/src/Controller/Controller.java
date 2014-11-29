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
	
	/* connexion de l'utilisateur local */
	public void performConnect(String nickname) {
		model = new DataModel(new User(nickname,"localhost"));
		this.ni = new ChatNI(this);
		sendHello();
		
		// fermeture de la disconnect window
		this.gui.getDisconnectedWindow().dispose();
		// ouverture de la connected window
		this.gui.setConnectedWindow(new ConnectedWindow(this));
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
		this.ni.sendHello();
		System.out.println("Salut");
	}
	

	public void sendGoodbye() {
		this.ni.sendGoodbye();
		System.out.println("Envoi de goodbye");
	}
	
	//////////////////////////////////////////
	//       A DESTINATION DE CHATGUI       //
	//////////////////////////////////////////
	
	public void addToUser(String hostname) {
		//this.model.addToList(new User(nick, hostname));
	}
	
	public void removeFromUserList(String hostname) {
		this.model.removeFromList(this.model.getUserByNickname(nick));
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
