package GUI;

import javax.swing.JButton;

public class SendButton {
	
	private JButton bSend ;
	
	public SendButton () {
		this.setbSend(new JButton("Send"));
	}

	/* GETTERS AND SETTERS */

	public JButton getbSend() {
		return bSend;
	}

	public void setbSend(JButton bSend) {
		this.bSend = bSend;
	}
}