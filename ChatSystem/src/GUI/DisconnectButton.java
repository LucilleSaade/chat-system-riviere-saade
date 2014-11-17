package GUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DisconnectButton implements ActionListener {
	
	private JButton bDisconnect ;
	private JPanel disconnectPanel ;
	
	public DisconnectButton () {
		this.setbDisconnect(new JButton("Déconnexion"));
		this.bDisconnect.addActionListener(this);
		this.disconnectPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		this.disconnectPanel.add(new JLabel("Se déconnecter"));
		this.disconnectPanel.add(bDisconnect);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO ;
	}
	
	/* GETTERS AND SETTERS */

	public JButton getbDisconnect() {
		return bDisconnect;
	}

	public void setbDisconnect(JButton bDisconnect) {
		this.bDisconnect = bDisconnect;
	}

	public JPanel getDisconnectPanel() {
		return disconnectPanel;
	}

	public void setDisconnectPanel(JPanel disconnectPanel) {
		this.disconnectPanel = disconnectPanel;
	}
	
	



}