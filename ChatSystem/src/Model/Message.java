package Model;

import java.util.ArrayList;
import java.util.List;

public class Message {
	
	private String emetteur ;
	private ArrayList<String> listDest ;
	private String contenu ;
	
	
	public Message(String emetteur, String contenu) {
		this.listDest = new ArrayList<String>();
		this.emetteur = emetteur;
		this.contenu = contenu;
	}
	
	public void addDests (List<String> listDest) {
		this.listDest = new ArrayList<String>(listDest);
	}
	
	
	public void addDest(String d) {
		this.listDest.add(d);
	}
	
	public void removeDest(String dest) {
		if (this.listDest.contains(dest))
			this.listDest.remove(this.listDest.indexOf(dest));	
		else
			System.out.println("Tentative de suppression de "+dest);
	}
	
	//////////////////////////////////////////
	//         GETTER ET SETTER             //
	//////////////////////////////////////////

	public String getEmetteur() {
		return emetteur;
	}

	public void setEmetteur(String emetteur) {
		this.emetteur = emetteur;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public ArrayList<String> getListDest() {
		return listDest;
	}

	public void setListDest(ArrayList<String> listDest) {
		this.listDest = listDest;
	}






}
