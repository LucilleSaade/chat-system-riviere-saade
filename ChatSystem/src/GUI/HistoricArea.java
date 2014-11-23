package GUI;

import javax.swing.JTextPane;

public class HistoricArea {
	
	private JTextPane hist; 
	
	public HistoricArea() {
		this.setHist(new JTextPane());
	}

	public JTextPane getHist() {
		return hist;
	}

	public void setHist(JTextPane hist) {
		this.hist = hist;
	}

}
