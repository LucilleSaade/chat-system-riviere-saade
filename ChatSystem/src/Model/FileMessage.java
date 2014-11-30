package Model;

public class FileMessage extends Message {
	
	private byte[] File ;

	public FileMessage(String emetteur, byte[] file) {
		super(emetteur, "");
		this.setFile(file);
	}
	
	
	//////////////////////////////////////////
	//         GETTER ET SETTER             //
	//////////////////////////////////////////

	public byte[] getFile() {
		return File;
	}

	public void setFile(byte[] file) {
		File = file;
	}
	
	

}
