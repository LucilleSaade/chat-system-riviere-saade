package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controller.Controller;

public class DisconnectActionListener implements ActionListener {
	
	private Controller cont;
	
	/**
	 * DisconnectActionListener : 
	 * ActionListener used when the user selects the disconnect button
	 * @param controller
	 */
	public DisconnectActionListener(Controller cont){
		super();
		this.cont = cont;
	}

	/**
	 * actionPerformed : call performDisconnect()
	 */
	public void actionPerformed(ActionEvent arg0) {
		cont.performDisconnect() ;
	}
	
	

}
