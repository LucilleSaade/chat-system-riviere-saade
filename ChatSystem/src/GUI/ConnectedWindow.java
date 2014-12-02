package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import Controller.Controller;

public class ConnectedWindow extends JFrame {
	
	private final int WIDTH = 800;
	private final int HEIGHT = 600;
	
	private Controller controller ;
	private VisualUserList ul;
	private DisconnectButton disconnectB;
	private MessageToSendTxtArea sendTextArea;
	private SendButton sendB;
	private SendFileButton sendFileB ;
	private HistoricArea historicArea;
	
	private JPanel disconnectPanel;
	private JPanel chatPanel;
	private JPanel sendPanel;
	private JPanel txtPanel;
	private JPanel userListPanel;
	private JPanel histPanel ;
	
	public ConnectedWindow(Controller c) {
		this.controller = c;
		this.ul = new VisualUserList() ;
		this.disconnectB = new DisconnectButton();
		this.disconnectB.getbDisconnect().addActionListener(new DisconnectActionListener(c));
		this.sendB = new SendButton();
		this.sendB.getbSend().addActionListener(new SendMsgActionListener(c));
		this.sendFileB = new SendFileButton();
		this.sendFileB.getbSendFile().addActionListener(new SendFileActionListener(c));
		this.sendTextArea = new MessageToSendTxtArea();
		this.historicArea = new HistoricArea();
		this.disconnectPanel = new JPanel();
		this.chatPanel = new JPanel();
		this.sendPanel = new JPanel();
		this.txtPanel = new JPanel();
		this.userListPanel = new JPanel();
		this.histPanel = new JPanel();
		initComponents();
	}
	
	private void initComponents() {
		
		disconnectPanel.setLayout(new BorderLayout());
		disconnectPanel.add(disconnectB.getbDisconnect(),BorderLayout.CENTER);
		
		userListPanel.setLayout(new BorderLayout());
		userListPanel.add(ul.getUserList(), BorderLayout.CENTER);
	
		sendPanel.setLayout(new GridLayout(2,1));
		sendPanel.add(sendB.getbSend());
		sendPanel.add(sendFileB.getbSendFile());

		txtPanel.setLayout(new BorderLayout());
		txtPanel.add(new JScrollPane(sendTextArea.getTxtArea()),BorderLayout.CENTER);
		txtPanel.add(sendPanel,BorderLayout.EAST);
		txtPanel.add(disconnectPanel, BorderLayout.SOUTH);
		
		histPanel.setLayout(new BorderLayout());
		histPanel.add(new JScrollPane(historicArea.getHist()),BorderLayout.CENTER);

		chatPanel.setLayout(new BorderLayout());
		//chatPanel.add(historicArea.getHist(),BorderLayout.CENTER);
		chatPanel.add(histPanel,BorderLayout.CENTER);
		chatPanel.add(txtPanel,BorderLayout.SOUTH);
		chatPanel.setMinimumSize(new Dimension((int) (0.8*WIDTH), chatPanel.getHeight()));

		this.setTitle("ChatSystem");
        this.setSize(WIDTH, HEIGHT);
        this.setLocation(100, 100);
		this.setLayout(new BorderLayout());
		JSplitPane splitPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, userListPanel, chatPanel);
		splitPanel.setDividerLocation(150);
		this.add(splitPanel,BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(WIDTH, HEIGHT);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	
	public void notifyConnection(String hostname) {
		// si l'utilisateur n'est pas l'utilisateur local, on affiche le message
		if (!controller.getModel().getLocalUser().getHostName().equals(hostname))
		JOptionPane.showMessageDialog(this,hostname+" vient de se connecter.");
	}
	
	public void notifyDisconnection(String hostname) {
		JOptionPane.showMessageDialog(this,hostname+" vient de se deconnecter.");
	}




}
