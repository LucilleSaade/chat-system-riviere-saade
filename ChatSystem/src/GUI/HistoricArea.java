package GUI;

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
				this.hist.append(emetteur+" : "+mess+"\n");
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
