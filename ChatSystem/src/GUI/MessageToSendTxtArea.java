package GUI;

import javax.swing.JTextArea;

public class MessageToSendTxtArea {
	
	private JTextArea txtArea ;
	
	/**
	 * MessageToSendTxtArea() constructor
	 * txtArea is a JTextArea which contains the message to send
	 */
	public MessageToSendTxtArea() {
		this.txtArea = new JTextArea();
	}
	
	//////////////////////////////////////////
	//         GETTER ET SETTER             //
	//////////////////////////////////////////

	/**
	 * getTxtArea() 
	 * @return JTextArea txtArea
	 */
	public JTextArea getTxtArea() {
		return txtArea;
	}

	/**
	 * setTxtArea()
	 * @param JTextArea txtArea
	 */
	public void setTxtArea(JTextArea txtArea) {
		this.txtArea = txtArea;
	}

}
