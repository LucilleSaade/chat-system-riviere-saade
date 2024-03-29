package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import Controller.Controller;
import Model.*;

public class SendMsgActionListener implements ActionListener {
	
	private Controller cont;
	
	/**
	 * SendMsgActionListener
	 * @param controller cont
	 */
	public SendMsgActionListener(Controller cont){
		super();
		this.cont = cont;
	}

	/**
	 * actionPerformed(ActionEvent arg0)
	 * checks that a receiver is selected and the message is not empty
	 * creates the ModelTxtMessage messageToSend and calls sendMessage(messageToSend)
	 */
	public void actionPerformed(ActionEvent arg0) {
		
		String contenuToSend = cont.getGui().getConnectedWindow().getSendTextArea().getTxtArea().getText();
	
		if (cont.getGui().getConnectedWindow().getUl().getSelectedValues().length == 0)
			cont.notifyEmptyDestList();
		else if (contenuToSend.equals("")) {
			cont.notifyEmptyMessage() ;
		}
		else {
			Object[] listDest = cont.getGui().getConnectedWindow().getUl().getSelectedValues();
			String emetteur = cont.getModel().getLocalUser().getHostName();
			ModelTxtMessage messageToSend = new ModelTxtMessage(emetteur,contenuToSend);
			messageToSend.addDests(listDest);
			cont.sendMessage(messageToSend);	
			// on vide la SendTextArea
			cont.getGui().getConnectedWindow().getSendTextArea().getTxtArea().setText("");
		}
	}
}