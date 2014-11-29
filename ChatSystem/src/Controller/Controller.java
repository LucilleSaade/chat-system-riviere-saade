package Controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import Model.*;
import NI.*;
import GUI.*;

public class Controller {
	
	private ChatNI ni;
	private ChatGUI gui;
	private DataModel model ;
	

	public Controller () {
		this.ni = new ChatNI(this);
		//this.gui = new ChatGUI(this);
	}
	
	/* connexion de l'utilisateur local */
	public void performConnect(String nickname) {
		try {
			model = new DataModel(new User(nickname,InetAddress.getLocalHost()));
		} catch (UnknownHostException e) {
			System.out.println("Erreur lors du performConnect");
		}
		sendHello();	
	}
	
	//////////////////////////////////////////
	//       A DESTINATION CHATNI           //
	//////////////////////////////////////////
	

	public void sendHello() {
		this.ni.sendHello();
		System.out.println("Salut");
	}
	
	//////////////////////////////////////////
	//       A DESTINATION DE CHATGUI       //
	//////////////////////////////////////////
	
	public void addToUser(String nick) {
		
	}
	
	public void removeFromUserList(String nick) {
		
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
