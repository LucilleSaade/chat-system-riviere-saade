package Controller;

import NI.*;
import GUI.*;

public class Controller {
	
	private ChatNI ni;
	private ChatGUI gui;
	
	public Controller () {
		this.ni = new ChatNI(this);
		this.gui = new ChatGUI(this);
	}
	//////////////////////////////////////////
	//       A DESTINATION CHATNI           //
	//////////////////////////////////////////
	
	
	
	//////////////////////////////////////////
	//       A DESTINATION DE CHATGUI       //
	//////////////////////////////////////////
	
	public void addToUser(String nick) {
		
	}
	
	public void removeFromUserList(String nick) {
		
	}
	
	
}
