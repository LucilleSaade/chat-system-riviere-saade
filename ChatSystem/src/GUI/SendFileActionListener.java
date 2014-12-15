package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import Controller.Controller;
import Model.ModelFileMessage;

public class SendFileActionListener implements ActionListener {
	
	private Controller cont;
	
	/**
	 * SendFileActionListener
	 * @param controller cont
	 */
	public SendFileActionListener(Controller cont){
		super();
		this.setCont(cont);
	}
	
	/**
	 * selectFile() : select a file in a directory chosen by the user
	 * @return File
	 */
	public File selectFile() {
		JFileChooser dialogue = new JFileChooser(new File("."));
		File fichier = null;	
		if (dialogue.showOpenDialog(null)== JFileChooser.APPROVE_OPTION) {
			fichier = dialogue.getSelectedFile();
		}		
		return fichier;
	}

	/**
	 * actionPerformed(ActionEvent arg0)
	 * checks that a receiver is selected
	 * creates the ModelFileMessage fileToSend and calls sendFile(fileToSend) 
	 */
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
				ModelFileMessage fileToSend = new ModelFileMessage(emetteur, fichier);
				fileToSend.addDests(listDest);
				cont.sendFile(fileToSend);				
			}
		}
	}
	
	//////////////////////////////////////////
	//         GETTER ET SETTER             //
	//////////////////////////////////////////

	/**
	 * getCont()
	 * @return Controller cont
	 */
	public Controller getCont() {
		return cont;
	}

	/**
	 * setCont(Controller cont)
	 * @param Controller cont
	 */
	public void setCont(Controller cont) {
		this.cont = cont;
	}
}