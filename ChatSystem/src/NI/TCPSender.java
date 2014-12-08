package NI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPSender extends Thread {
	private String hostname;
	private ChatNI ni;
	private Socket soc;
	
	
	public TCPSender(ChatNI ni, String hostname, Socket soc){
		this.hostname = hostname;
		this.ni = ni;
		this.soc = soc;
	}
	
	
	public void transfert(File file) {
        FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
	        ObjectOutputStream oos= new ObjectOutputStream(fos);
	
	        // Ecriture dans le flux de sortie
	        oos.writeObject(file);
	
	        // Vide le tampon
	        oos.flush();
	
	    	oos.close();
	    	fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
	
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
	
	
	//////////////////////////////////////////
	//         GETTER ET SETTER             //
	//////////////////////////////////////////	
	
	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public ChatNI getNi() {
		return ni;
	}

	public void setNi(ChatNI ni) {
		this.ni = ni;
	}

	public Socket getSoc() {
		return soc;
	}

	public void setSoc(Socket soc) {
		this.soc = soc;
	}

}
