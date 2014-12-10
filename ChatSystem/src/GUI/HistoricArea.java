package GUI;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextArea;

import Model.*;

public class HistoricArea implements Observer {
	
	private JTextArea hist; 
	
	public HistoricArea() {
		this.setHist(new JTextArea());
	}
	
	public void update(Observable obs, Object arg) {
		if (obs instanceof User) {
			if (arg instanceof ModelTxtMessage) {
				addTxtMessageToHist((ModelTxtMessage) arg);
			}			
			else if (arg instanceof ModelFileMessage) {
				// si cest un fichier envoyé
				if (((ModelFileMessage) arg).getFile() != null) {
					addFileSentToHist((ModelFileMessage) arg);
				}
				// fichier recu
				else {
					addReceivedFileToHist((ModelFileMessage) arg);
				}
			}				
		}
	}
	
	public void addTxtMessageToHist (ModelTxtMessage m) {
		String emetteur = m.getEmetteur();
		String mess = m.getContenu();
		ArrayList<String> listDest = m.getListDest();
		this.hist.append(emetteur+" to ");
		for (String s : listDest)
			this.hist.append(s+" ");
		this.hist.append(" : \n"+mess+"\n\n");
	}
	
	public void addFileSentToHist(ModelFileMessage m) {
		String emetteur = m.getEmetteur();
		ArrayList<String> listDest = m.getListDest();
		String fileName = m.getFileName();
		this.hist.append(emetteur+" to ");
		for (String s : listDest)
			this.hist.append(s+" ");
		this.hist.append(" : \nFile sent : "+fileName+"\n\n");
	}
	
	public void addReceivedFileToHist (ModelFileMessage m) {
		String emetteur = m.getEmetteur();
		ArrayList<String> listDest = m.getListDest();
		String fileName = m.getFileName();
		this.hist.append(emetteur+" to ");
		for (String s : listDest)
			this.hist.append(s+" ");
		this.hist.append(" : \nFile received  : "+fileName+"\n\n");
	}
	
	
	//////////////////////////////////////////
	//         GETTER ET SETTER             //
	//////////////////////////////////////////


	public JTextArea getHist() {
		return hist;
	}

	public void setHist(JTextArea hist) {
		this.hist = hist;
	}


}
