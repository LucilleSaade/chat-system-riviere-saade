package GUI;

import java.awt.GridLayout;
import javax.swing.JFrame;

public class DisconnectedWindow extends JFrame {
	
private ConnectButton connectB;
private NicknameTextArea nicknameArea ;
	
	public DisconnectedWindow () {
		this.connectB = new ConnectButton();
		this.nicknameArea = new NicknameTextArea() ;
		initComponents();
	}
	
	private void initComponents() {
		this.setTitle("Connexion au ChatSystem");
        this.setSize(600, 80);
        this.setLocation(100, 100);
		// configures the JFrame layout using a border layout
		this.setLayout(new GridLayout(1,3));
		// places the components in the layout
		this.add(nicknameArea.getNicknameLabel());
		this.add(nicknameArea.getNicknameTA());	
		this.add(connectB.getbConnect());	
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 }

}
