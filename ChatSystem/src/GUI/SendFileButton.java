package GUI;

import javax.swing.JButton;

public class SendFileButton {
	
	private JButton bSendFile ;
	
	/**
	 * SendFileButton constructor
	 * bSendFile : JButton used to send a file
	 */
	public SendFileButton () {
		this.setbSendFile(new JButton("Send file"));
	}

	//////////////////////////////////////////
	//         GETTER ET SETTER             //
	//////////////////////////////////////////

	/**
	 * getbSendFile()
	 * @return JButton bSendFile
	 */
	public JButton getbSendFile() {
		return bSendFile;
	}

	/**
	 * setbSendFile
	 * @param JButton bSendFile
	 */
	public void setbSendFile(JButton bSendFile) {
		this.bSendFile = bSendFile;
	}
}