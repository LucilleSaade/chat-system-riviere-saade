package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controller.Controller;

public class DisconnectActionListener implements ActionListener {
	
	private Controller cont;
	
	public DisconnectActionListener(Controller cont){
		this.cont = cont;
	}

	public void actionPerformed(ActionEvent arg0) {
		cont.performDisconnect() ;
	}
	
	

}
