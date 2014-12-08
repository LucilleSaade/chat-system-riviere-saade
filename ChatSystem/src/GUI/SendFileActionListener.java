package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFileChooser;

import Controller.Controller;

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
		File fichier = selectFile();
		/*
		if (fichier == null) {
			System.out.println("Erreur : Fichier null");
		}
		else {
			byte[] fileByte = convertFileToByte(fichier);

		}*/
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