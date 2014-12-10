package Controller;

import java.util.ArrayList;

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
		// fermeture de la disconnect window
		this.gui.getDisconnectedWindow().dispose();
		
		
		// ouverture de la connected window
		model = new DataModel(new User(hostname,this),this);
		this.gui.setConnectedWindow(new ConnectedWindow(this));
		this.getGui().getConnectedWindow().setUl(new VisualUserList(this));
		this.getModel().getLocalUser().addObserverToHistArea();
		this.getGui().getConnectedWindow().initComponents();
		this.ni = new ChatNI(this);
		sendHello();
	}
	
	public void performDisconnect() {
		sendGoodbye();
		// fermeture de la connected window
		this.getGui().getConnectedWindow().dispose() ;
		// TODO : fermer threads / sockets ??
		this.getNI().closeSocAndThreads();
		this.setGui(new ChatGUI(this));
		//System.exit(0);
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
	
	public void sendMessage(ModelTxtMessage m) { 
		ArrayList<String> Dest = m.getListDest(); 
		String contenu = m.getContenu();
		// on ajoute le message dans la liste des messages
		this.getModel().getLocalUser().addTxtMessage(m);
		// on envoie le message
		this.ni.sendMessage(Dest, contenu);
	}
	

	public void sendFile(ModelFileMessage f) {
		ArrayList<String> Dest = f.getListDest(); 
		this.getModel().getLocalUser().addSentFile(f);
		// on envoie le message
		this.ni.sendFile(f.getFile(),f.getListDest());
	}
	
	
	//////////////////////////////////////////
	//       A DESTINATION DE CHATGUI       //
	//////////////////////////////////////////
	
	public void addToUserList(String hostname) {
		this.model.addToList(hostname);
		this.gui.getConnectedWindow().notifyConnection(hostname);
	}
	
	public void removeFromUserList(String hostname) {
		this.model.removeFromList(hostname);
		this.gui.getConnectedWindow().notifyDisconnection(hostname);
	}
	
	public void messageReceived(String hostname, String msg, ArrayList<String> listDest) {
		this.model.getLocalUser().addReceivedMessage(hostname, msg, listDest);
	}
	
	public void fileReceived(String hostname, String fileName, ArrayList<String> listDest) {
		this.model.getLocalUser().addReceivedFile(hostname, fileName, listDest);
		System.out.println("Fichier recu");
	}
	
	public void notifyEmptyMessage() {
		this.gui.getConnectedWindow().notifyEmptyMessage();
	}
	
	public void notifyEmptyDestList() {
		this.gui.getConnectedWindow().notifyEmptyDestList();
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
