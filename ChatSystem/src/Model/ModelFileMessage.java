package Model;

import java.io.File;

public class ModelFileMessage extends Message {
	
	private File file ;
	private String fileName ;
	
	/**
	 * ModelFileMessage constructor : received file
	 * @param emetteur
	 * @param name
	 */
	public ModelFileMessage(String emetteur, String name) {
		super(emetteur, "");
		this.setFileName(name);
		this.setFile(null);
	}

	/**
	 * ModelFileMessage constructor : sent file
	 * @param emetteur
	 * @param file
	 */
	public ModelFileMessage(String emetteur, File file) {
		super(emetteur, "");
		this.setFileName(file.getName());
		this.setFile(file);
	}
	
	
	//////////////////////////////////////////
	//         GETTER ET SETTER             //
	//////////////////////////////////////////

	/**
	 * getFile()
	 * @return File
	 */
	public File getFile() {
		return file;
	}

	/**
	 * setFile
	 * @param file
	 */
	public void setFile(File file) {
		this.file = file;
	}

	/**
	 * getFileName()
	 * @return String fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * setFileName
	 * @param String fileName
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	

}
