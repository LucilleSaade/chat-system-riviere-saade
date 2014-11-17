package GUI;

import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ConnectedWindow extends JFrame {
	
	private UserList ul ;
	private DisconnectButton disconnectB;
	
	public ConnectedWindow() {
		this.ul = new UserList() ;
		this.disconnectB = new DisconnectButton();
		initComponents();
	}
	
	private void initComponents() {
		this.setTitle("ChatSystem");
        this.setSize(1000, 600);
        this.setLocation(100, 100);
        JPanel panneau = (JPanel)getContentPane();
        panneau.setLayout(new BoxLayout(panneau, BoxLayout.Y_AXIS));
        panneau.add(disconnectB.getDisconnectPanel());
        panneau.add(ul.getListPanel());
        this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}


}
