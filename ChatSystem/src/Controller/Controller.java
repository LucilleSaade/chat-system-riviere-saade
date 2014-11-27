package Controller;

import NI.*;
import GUI.*;

public class Controller {
	
	private ChatNI ni;
	private ChatGUI gui;
	
	public Controller () {
		this.ni = new ChatNI(this);
		//this.gui = new ChatGUI(this);
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
