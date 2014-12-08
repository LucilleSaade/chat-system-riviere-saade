package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import Controller.Controller;
import Model.FileMessage;

public class SendFileActionListener implements ActionListener {
	
	private Controller cont;
	
	public SendFileActionListener(Controller cont){
		super();
		this.setCont(cont);
	}
	
	public File selectFile() {
		JFileChooser dialogue = new JFileChooser(new File("."));
		File fichier = null;	
		if (dialogue.showOpenDialog(null)== JFileChooser.APPROVE_OPTION) {
			fichier = dialogue.getSelectedFile();
		}		
		return fichier;
	}

	public void actionPerformed(ActionEvent arg0) {
		
		if (cont.getGui().getConnectedWindow().getUl().getSelectedValues().length == 0) {
			cont.notifyEmptyDestList();
		}
		else {
			File fichier = selectFile();
					
			if (fichier == null) {
				System.out.println("Erreur : Fichier null");
			}
			else {
				Object[] listDest = cont.getGui().getConnectedWindow().getUl().getSelectedValues();
				String emetteur = cont.getModel().getLocalUser().getHostName();
				FileMessage fileToSend = new FileMessage(emetteur, fichier);
				fileToSend.addDests(listDest);
				cont.sendFile(fileToSend);				
			}
		}
	}
	
	//////////////////////////////////////////
	//         GETTER ET SETTER             //
	//////////////////////////////////////////

	public Controller getCont() {
		return cont;
	}

	public void setCont(Controller cont) {
		this.cont = cont;
	}
}