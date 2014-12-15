package Model;

import java.util.ArrayList;

public class Message {
	
	private String emetteur ;
	private ArrayList<String> listDest ;
	private String contenu ;
	
	/**
	 * Message constructor
	 * @param emetteur 
	 * @param contenu 
	 */
	public Message(String emetteur, String contenu) {
		this.listDest = new ArrayList<String>();
		this.emetteur = emetteur;
		this.contenu = contenu;
	}
	
	/**
	 * addDests :
	 * add the recipients using an array
	 * @param Object[] tabDests
	 */
	public void addDests (Object[] tabDests) {
		this.listDest = new ArrayList<String>();
		for (int i = 0; i < tabDests.length; i++) {
			listDest.add((String) tabDests[i]);
		}
	}
	
	/**
	 * addDest
	 * add a single dest to the message
	 * @param String d
	 */
	public void addDest(String d) {
		this.listDest.add(d);
	}
	
	
	//////////////////////////////////////////
	//         GETTER ET SETTER             //
	//////////////////////////////////////////

	/**
	 * getEmetteur()
	 * @return String emetteur
	 */
	public String getEmetteur() {
		return emetteur;
	}

	/**
	 * setEmetteur
	 * @param  String emetteur
	 */
	public void setEmetteur(String emetteur) {
		this.emetteur = emetteur;
	}

	/**
	 * getContenu()
	 * @return String contenu
	 */
	public String getContenu() {
		return contenu;
	}

	/**
	 * setContenu
	 * @param String contenu
	 */
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	/**
	 * getListDest()
	 * @return ArrayList<String> listDest
	 */
	public ArrayList<String> getListDest() {
		return listDest;
	}

	/**
	 * setListDest
	 * @param ArrayList<String> listDest
	 */
	public void setListDest(ArrayList<String> listDest) {
		this.listDest = listDest;
	}


}
