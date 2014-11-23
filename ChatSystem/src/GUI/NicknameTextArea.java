package GUI;

import javax.swing.JLabel;
import javax.swing.JTextArea;

public class NicknameTextArea {
	
	private JTextArea nicknameTA ;
	private JLabel nicknameLabel ;
	
	public NicknameTextArea() {
		this.nicknameTA = new JTextArea() ;
		this.nicknameLabel = new JLabel ("Entrez votre nom d'utilisateur :");
	}
	
	
	/* GETTERS AND SETTERS */

	public JTextArea getNicknameTA() {
		return nicknameTA;
	}

	public void setNicknameTA(JTextArea nicknameTA) {
		this.nicknameTA = nicknameTA;
	}

	public JLabel getNicknameLabel() {
		return nicknameLabel;
	}

	public void setNicknameLabel(JLabel nicknameLabel) {
		this.nicknameLabel = nicknameLabel;
	}

}
