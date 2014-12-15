package GUI;

import javax.swing.JButton;

public class SendButton {
	
	private JButton bSend ;
	
	/**
	 * SendButton constructor
	 * bSend : JButton used to send a message
	 */
	public SendButton () {
		this.setbSend(new JButton("Send"));
	}

	//////////////////////////////////////////
	//         GETTER ET SETTER             //
	//////////////////////////////////////////

	/**
	 * getbSend()
	 * @return JButton bSend
	 */
	public JButton getbSend() {
		return bSend;
	}

	/**
	 * setbSend
	 * @param JButton bSend
	 */
	public void setbSend(JButton bSend) {
		this.bSend = bSend;
	}
}