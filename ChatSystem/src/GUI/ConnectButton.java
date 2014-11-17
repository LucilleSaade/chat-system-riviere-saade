package GUI;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnectButton implements ActionListener {
	
	private JButton bConnect ;
	
	public ConnectButton () {
		this.setbConnect(new JButton("Connexion"));
		this.bConnect.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO ;
	}
	
	/* GETTERS AND SETTERS */

	public JButton getbConnect() {
		return bConnect;
	}

	public void setbConnect(JButton bConnect) {
		this.bConnect = bConnect;
	}



}
