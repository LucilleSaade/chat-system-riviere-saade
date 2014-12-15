package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Controller.Controller;
import NI.IPAddress;

public class DisconnectedWindow extends JFrame implements ActionListener {
	
	/**
	 * Frame displayed when the user is disconnected
	 */
	private static final long serialVersionUID = 1L;
	private Controller controller ;
	private ConnectButton connectB;
	private NicknameTextArea nicknameArea ;
	
	/**
	 * DisconnectedWindow constructor
	 * @param controller
	 */
	public DisconnectedWindow (Controller c) {
		this.controller = c;
		this.connectB = new ConnectButton();
		this.connectB.getbConnect().addActionListener(this);
		this.nicknameArea = new NicknameTextArea() ;
		initComponents();
	}
	
	/**
	 * initComponents() :
	 * init all the components and add them into the frame
	 */
	private void initComponents() {
		this.setTitle("Connection to the ChatSystem");
        this.setSize(500, 80);
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
	
	
	/* LORSQU'ON CLIQUE SUR LE BOUTTON DE CONNEXION */
	
	/**
	 * actionPerformed :
	 * method called when the user clicks on the connect button
	 * verify that the nickname is correct
	 * call controller.performConnect(localHostname) if the localHostname is correct
	 */
	public void actionPerformed(ActionEvent arg0) {
		// on verifie que le nickname a ete saisi
		if (this.nicknameArea.getNicknameTA().getText().equals("")) {
			JOptionPane.showMessageDialog(this,"You can't choose an empty nickname.");
		}
		else if (this.nicknameArea.getNicknameTA().getText().contains("@")) {
			JOptionPane.showMessageDialog(this,"Your username can't contain the @ character.");
		}
		else {
			String localNickname = this.nicknameArea.getNicknameTA().getText();
			String localHostname;
			try {
				localHostname = IPAddress.concatLocalhostIP(localNickname);
				controller.performConnect(localHostname);
			} catch (UnknownHostException e) {
				System.out.println("Erreur lors du actionPerformed du boutton connect : localhost not found");
			} catch (SocketException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}					
	}

}
