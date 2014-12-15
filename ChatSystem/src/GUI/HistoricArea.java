package GUI;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextArea;

import Model.*;

public class HistoricArea implements Observer {
	
	/**
	 * hist : JTextArea, contains all the messages 
	 */
	private JTextArea hist; 
	
	/**
	 * HistoricArea constructor
	 */
	public HistoricArea() {
		this.setHist(new JTextArea());
	}
	
	/**
	 *  update(Observable obs, Object arg)
	 *  Method called when a message is sent or received
	 *  add this message to the historic area
	 */
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
	
	/**
	 * addTxtMessageToHist
	 * Add a text message to the historic area
	 * @param ModelTxtMessage m
	 */
	public void addTxtMessageToHist (ModelTxtMessage m) {
		String emetteur = m.getEmetteur();
		String mess = m.getContenu();
		ArrayList<String> listDest = m.getListDest();
		this.hist.append(emetteur+" to ");
		for (String s : listDest)
			this.hist.append(s+" ");
		this.hist.append(" : \n"+mess+"\n\n");
	}
	
	/**
	 * addFileSentToHist
	 * Add a sent file message to the historic area
	 * @param ModelFileMessage m
	 */
	public void addFileSentToHist(ModelFileMessage m) {
		String emetteur = m.getEmetteur();
		ArrayList<String> listDest = m.getListDest();
		String fileName = m.getFileName();
		this.hist.append(emetteur+" to ");
		for (String s : listDest)
			this.hist.append(s+" ");
		this.hist.append(" : \nFile sent : "+fileName+"\n\n");
	}
	
	/**
	 * addReceivedFileToHist
	 * Add a received file message to the historic area
	 * @param ModelFileMessage m
	 */
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


	/**
	 * getHist()
	 * @return JTextArea hist
	 */
	public JTextArea getHist() {
		return hist;
	}

	/**
	 * setHist(JTextArea hist)
	 * @param JTextArea hist
	 */
	public void setHist(JTextArea hist) {
		this.hist = hist;
	}


}
