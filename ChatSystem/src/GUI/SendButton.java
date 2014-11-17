package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class SendButton implements ActionListener {
	
	private JButton bSend ;
	
	public SendButton () {
		this.setbSend(new JButton("Send"));
		this.bSend.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO ;
	}
	
	/* GETTERS AND SETTERS */

	public JButton getbSend() {
		return bSend;
	}

	public void setbSend(JButton bSend) {
		this.bSend = bSend;
	}
}