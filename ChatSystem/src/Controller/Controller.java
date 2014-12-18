package Controller;

import java.util.ArrayList;

import Model.*;
import NI.*;
import GUI.*;

public class Controller {
	
	private ChatNI ni;
	private ChatGUI gui;
	private DataModel model ;
	
	/**
	 * Controller constructor
	 * creates a ChatGUI object
	 */
	public Controller () {
		this.gui = new ChatGUI(this);
	}
	
	//////////////////////////////////////////
	//       CONNEXION / DECONNEXION        //
	//////////////////////////////////////////
	
	/**
	 * performConnect(String hostname)
	 * connects the user "hostname" to the chatsystem
	 * Details :
	 * closes the disconnected window 
	 * opens the connected window
	 * creates a ChatNI object
	 * call sendHello()
	 * @param String hostname
	 */
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
	
	/**
	 * performDisconnect()
	 * disconnects the user from the chatsystem
	 * Details :
	 * call sendGoodbye()
	 * closes the connected window 
	 * closes active sockets and threads
	 * creates a new chatGUI (opens a disconnected window)
	 */
	public void performDisconnect() {
		sendGoodbye();
		// fermeture de la connected window
		this.getGui().getConnectedWindow().dispose() ;
		this.getNI().closeSocAndThreads();
		this.setGui(new ChatGUI(this));
		//System.exit(0);
	}
	
	//////////////////////////////////////////
	//       A DESTINATION CHATNI           //
	//////////////////////////////////////////	

	/**
	 * sendHello()
	 * call NI.sendHello()
	 */
	public void sendHello() {
		System.out.println("Envoie de Hello");
		this.ni.sendHello();
	}
	
	/**
	 * sendGoodbye()
	 * call NI.sendGoodbye()
	 */
	public void sendGoodbye() {
		System.out.println("Envoi de Goodbye");
		this.ni.sendGoodbye();
	}
	
	/**
	 * sendMessage
	 * call NI.sendMessage()
	 * @param ModelTxtMessage m
	 */
	public void sendMessage(ModelTxtMessage m) { 
		ArrayList<String> Dest = m.getListDest(); 
		String contenu = m.getContenu();
		// on ajoute le message dans la liste des messages
		this.getModel().getLocalUser().addTxtMessage(m);
		// on envoie le message
		this.ni.sendMessage(Dest, contenu);
	}
	
	/**
	 * sendFile
	 * call NI.sendFile()
	 * @param ModelFileMessage f
	 */
	public void sendFile(ModelFileMessage f) {
		this.getModel().getLocalUser().addSentFile(f);
		// on envoie le message
		this.ni.sendFile(f.getFile(),f.getListDest());
	}
	
	
	//////////////////////////////////////////
	//       A DESTINATION DE CHATGUI       //
	//////////////////////////////////////////
	
	/**
	 * addToUserList
	 * add the remote user hostname to the model 
	 * notify the local user that hostname is connected
	 * @param String hostname
	 */
	public void addToUserList(String hostname) {
		this.model.addToList(hostname);
		this.gui.getConnectedWindow().notifyConnection(hostname);
	}
	
	/**
	 * removeFromUserList
	 * remove the remote user hostname from the model 
	 * notify the local user that hostname is disconnected
	 * @param String hostname
	 */
	public void removeFromUserList(String hostname) {
		this.model.removeFromList(hostname);
		this.gui.getConnectedWindow().notifyDisconnection(hostname);
	}
	
	/**
	 * messageReceived
	 * call User.addReceivedMessage
	 * @param hostname
	 * @param msg
	 * @param listDest
	 */
	public void messageReceived(String hostname, String msg, ArrayList<String> listDest) {
		this.model.getLocalUser().addReceivedMessage(hostname, msg, listDest);
	}
	
	/**
	 * fileReceived
	 * Call User.addReceivedFile
	 * @param hostname
	 * @param fileName
	 * @param listDest
	 */
	public void fileReceived(String hostname, String fileName, ArrayList<String> listDest) {
		this.model.getLocalUser().addReceivedFile(hostname, fileName, listDest);
		System.out.println("Fichier recu");
	}
	
	/**
	 * notifyEmptyMessage
	 * call GUI.notifyEmptyMessage()
	 */
	public void notifyEmptyMessage() {
		this.gui.getConnectedWindow().notifyEmptyMessage();
	}
	
	/**
	 * notifyEmptyDestList
	 * call GUI.notifyEmptyDestList()
	 */
	public void notifyEmptyDestList() {
		this.gui.getConnectedWindow().notifyEmptyDestList();
	}
	
	
	//////////////////////////////////////////
	//           GETTER ET SETTER           //
	//////////////////////////////////////////
	
	/**
	 * getModel
	 * @return DataModel model
	 */
	public DataModel getModel() {
		return model;
	}

	/**
	 * setModel
	 * @param DataModel model
	 */
	public void setModel(DataModel model) {
		this.model = model;
	}

	/**
	 * getNI()
	 * @return ChatNI ni
	 */
	public ChatNI getNI() {
		return ni;
	}
	
	/**
	 * setNI
	 * @param ChatNI ni
	 */
	public void setNI(ChatNI ni) {
		this.ni = ni;
	}
		
	/**
	 * getGui()
	 * @return ChatGUI gui
	 */
	public ChatGUI getGui() {
		return gui;
	}
	
	/**
	 * setGui
	 * @param ChatGUI gui
	 */
	public void setGui(ChatGUI gui) {
		this.gui = gui;
	}




	
}
