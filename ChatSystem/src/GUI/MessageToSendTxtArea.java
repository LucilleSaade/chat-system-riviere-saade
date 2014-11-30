package GUI;

import javax.swing.JTextArea;

public class MessageToSendTxtArea {
	
	private JTextArea txtArea ;
	
	public MessageToSendTxtArea() {
		this.txtArea = new JTextArea();
	}
	
	//////////////////////////////////////////
	//         GETTER ET SETTER             //
	//////////////////////////////////////////

	public JTextArea getTxtArea() {
		return txtArea;
	}

	public void setTxtArea(JTextArea txtArea) {
		this.txtArea = txtArea;
	}

}
