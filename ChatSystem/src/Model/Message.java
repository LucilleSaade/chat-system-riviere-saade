package Model;

public class Message {
	
	private String emetteur ;
	private String contenu ;
	
	
	public Message(String emetteur, String contenu) {
		this.emetteur = emetteur;
		this.contenu = contenu;
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




}
