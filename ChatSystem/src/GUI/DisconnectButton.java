package GUI;

import javax.swing.JButton;

public class DisconnectButton {
	
	private JButton bDisconnect ;
	
	/**
	 * DisconnectButton : button used to disconnect the user
	 */
	public DisconnectButton () {
		this.setbDisconnect(new JButton("Disconnect"));
	}

	//////////////////////////////////////////
	//         GETTER ET SETTER             //
	//////////////////////////////////////////

	/**
	 * getbDisconnect
	 * @return JButton bDisconnect
	 */
	public JButton getbDisconnect() {
		return bDisconnect;
	}

	/**
	 * setbDisconnect
	 * @param JButton bDisconnect
	 */
	public void setbDisconnect(JButton bDisconnect) {
		this.bDisconnect = bDisconnect;
	}


}