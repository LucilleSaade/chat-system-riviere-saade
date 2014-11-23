package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class SendFileButton implements ActionListener {
	
	private JButton bSendFile ;
	
	public SendFileButton () {
		this.setbSendFile(new JButton("Add file"));
		this.bSendFile.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO ;
	}
	
	/* GETTERS AND SETTERS */

	public JButton getbSendFile() {
		return bSendFile;
	}

	public void setbSendFile(JButton bSendFile) {
		this.bSendFile = bSendFile;
	}
}