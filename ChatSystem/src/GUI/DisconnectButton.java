package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class DisconnectButton implements ActionListener {
	
	private JButton bDisconnect ;
	
	public DisconnectButton () {
		this.setbDisconnect(new JButton("Deconnexion"));
		this.bDisconnect.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO ;
	}
	
	/* GETTERS AND SETTERS */

	public JButton getbDisconnect() {
		return bDisconnect;
	}

	public void setbDisconnect(JButton bDisconnect) {
		this.bDisconnect = bDisconnect;
	}


}