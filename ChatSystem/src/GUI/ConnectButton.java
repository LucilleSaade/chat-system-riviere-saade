package GUI;

import javax.swing.JButton;

public class ConnectButton {
	
	private JButton bConnect ;
	
	/**
	 * ConnectButton : constructor 
	 * Button used to connect the user to the chatsystem
	 */
	public ConnectButton () {
		this.setbConnect(new JButton("Connect"));
	}
	
	//////////////////////////////////////////
	//         GETTER ET SETTER             //
	//////////////////////////////////////////

	/**
	 * getbConnect
	 * @return JButton bConnect
	 */
	public JButton getbConnect() {
		return bConnect;
	}

	/**
	 * setbConnect
	 * @param bConnect
	 */
	public void setbConnect(JButton bConnect) {
		this.bConnect = bConnect;
	}



}
