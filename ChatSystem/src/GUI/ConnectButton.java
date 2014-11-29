package GUI;

import javax.swing.JButton;

public class ConnectButton {
	
	private JButton bConnect ;
	
	public ConnectButton () {
		this.setbConnect(new JButton("Connexion"));
	}
	
	//////////////////////////////////////////
	//         GETTER ET SETTER             //
	//////////////////////////////////////////

	public JButton getbConnect() {
		return bConnect;
	}

	public void setbConnect(JButton bConnect) {
		this.bConnect = bConnect;
	}



}
