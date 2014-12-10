package Model;

import java.io.File;

public class ModelFileMessage extends Message {
	
	private File file ;
	private String fileName ;
	
	public ModelFileMessage(String emetteur, String name) {
		super(emetteur, "");
		this.setFileName(name);
		this.setFile(null);
	}

	public ModelFileMessage(String emetteur, File file) {
		super(emetteur, "");
		this.setFileName(file.getName());
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

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	

}
