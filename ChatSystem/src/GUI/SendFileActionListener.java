package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controller.Controller;

public class SendFileActionListener implements ActionListener {
	
	private Controller cont;
	
	public SendFileActionListener(Controller cont){
		super();
		this.setCont(cont);
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO
	}
	
	//////////////////////////////////////////
	//         GETTER ET SETTER             //
	//////////////////////////////////////////

	public Controller getCont() {
		return cont;
	}

	public void setCont(Controller cont) {
		this.cont = cont;
	}
}