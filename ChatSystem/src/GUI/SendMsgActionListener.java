package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controller.Controller;
import Model.*;

public class SendMsgActionListener implements ActionListener {
	
	private Controller cont;
	
	public SendMsgActionListener(Controller cont){
		super();
		this.cont = cont;
	}

	public void actionPerformed(ActionEvent arg0) {
		
		// si aucun message n'a ete cree
		// alors il faut choisir au moins un dest + ecrire contenu
		if (!cont.getModel().getLocalUser().isCurrentMessageCree()){
			cont.notifyEmptyDestList();
		}
		else {
			TxtMessage messageToSend = (TxtMessage) cont.getModel().getLocalUser().getCurrentMessage() ;
			String contenuToSend = cont.getGui().getConnectedWindow().getSendTextArea().getTxtArea().getText();
			// si le contenu est vide
			if (contenuToSend.equals("")) {
				cont.notifyEmptyMessage() ;
			}
			else {
				// si le message est correct : contenu non vide + dest OK
				messageToSend.setContenu(contenuToSend);
				cont.sendMessage(messageToSend);				
			}
		}
	}
}