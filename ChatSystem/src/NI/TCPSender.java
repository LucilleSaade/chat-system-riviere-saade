package NI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TCPSender extends Thread {
	private String hostname;
	private ChatNI ni;
	
	
	
	public byte[] convertFileToByte (File fichier) {
		byte[] fileByte = new byte[(int) fichier.length()];
        FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(fichier);
			fileInputStream.read(fileByte);
		} catch (FileNotFoundException e1) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("IOException : convertFileToByte error");
		}
        return fileByte;
	}

}
