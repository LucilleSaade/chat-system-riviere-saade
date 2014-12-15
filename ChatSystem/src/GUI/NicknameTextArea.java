package GUI;

import javax.swing.JLabel;
import javax.swing.JTextArea;

public class NicknameTextArea {
	
	private JTextArea nicknameTA ;
	private JLabel nicknameLabel ;
	
	/**
	 * NicknameTextArea() constructor
	 * JTextArea nicknameTA : text area containing the nickname of the user
	 */
	public NicknameTextArea() {
		this.nicknameTA = new JTextArea() ;
		this.nicknameLabel = new JLabel ("Nickname :");
	}
	
	
	//////////////////////////////////////////
	//         GETTER ET SETTER             //
	//////////////////////////////////////////

	/**
	 * getNicknameTA()
	 * @return JTextArea nicknameTA
	 */
	public JTextArea getNicknameTA() {
		return nicknameTA;
	}

	/**
	 * setNicknameTA
	 * @param JTextArea nicknameTA
	 */
	public void setNicknameTA(JTextArea nicknameTA) {
		this.nicknameTA = nicknameTA;
	}

	/**
	 * getNicknameLabel()
	 * @return JLabel nicknameLabel
	 */
	public JLabel getNicknameLabel() {
		return nicknameLabel;
	}

	/**
	 * setNicknameLabel
	 * @param JLabel nicknameLabel
	 */
	public void setNicknameLabel(JLabel nicknameLabel) {
		this.nicknameLabel = nicknameLabel;
	}

}
