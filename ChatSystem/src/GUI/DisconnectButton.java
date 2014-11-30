package GUI;

import javax.swing.JButton;

public class DisconnectButton {
	
	private JButton bDisconnect ;
	
	public DisconnectButton () {
		this.setbDisconnect(new JButton("Deconnexion"));
	}

	//////////////////////////////////////////
	//         GETTER ET SETTER             //
	//////////////////////////////////////////

	public JButton getbDisconnect() {
		return bDisconnect;
	}

	public void setbDisconnect(JButton bDisconnect) {
		this.bDisconnect = bDisconnect;
	}


}