package GUI;

import javax.swing.JButton;

public class SendFileButton {
	
	private JButton bSendFile ;
	
	public SendFileButton () {
		this.setbSendFile(new JButton("Send file"));
	}

	//////////////////////////////////////////
	//         GETTER ET SETTER             //
	//////////////////////////////////////////

	public JButton getbSendFile() {
		return bSendFile;
	}

	public void setbSendFile(JButton bSendFile) {
		this.bSendFile = bSendFile;
	}
}