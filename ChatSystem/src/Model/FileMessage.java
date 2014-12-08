package Model;

import java.io.File;

public class FileMessage extends Message {
	
	private File file ;

	public FileMessage(String emetteur, File file) {
		super(emetteur, "");
		this.setFile(file);
	}
	
	
	//////////////////////////////////////////
	//         GETTER ET SETTER             //
	//////////////////////////////////////////

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
	
	

}
