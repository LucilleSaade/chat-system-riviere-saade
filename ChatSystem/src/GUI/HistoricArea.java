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
			if (arg instanceof TxtMessage) {
				String emetteur = ((TxtMessage) arg).getEmetteur();
				String mess = ((TxtMessage) arg).getContenu();
				ArrayList<String> listDest = ((TxtMessage) arg).getListDest();
				this.hist.append(emetteur+" to ");
				for (String s : listDest)
					this.hist.append(s+" ");
				this.hist.append(" : \n"+mess+"\n\n");
			}			
			else if (arg instanceof ModelFileMessage) {
				// si cest un fichier envoyé
				if (((ModelFileMessage) arg).getFile() != null) {
					String emetteur = ((ModelFileMessage) arg).getEmetteur();
					ArrayList<String> listDest = ((ModelFileMessage) arg).getListDest();
					String fileName = ((ModelFileMessage) arg).getFileName();
					this.hist.append(emetteur+" to ");
					for (String s : listDest)
						this.hist.append(s+" ");
					this.hist.append(" : \n Envoi du fichier : "+fileName+"\n\n");
				}
				// fichier recu
				else {
					String emetteur = ((ModelFileMessage) arg).getEmetteur();
				}
			}				
		}
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
