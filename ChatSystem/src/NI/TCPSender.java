package NI;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPSender extends Thread {
	private String hostname;
	private ByteArrayOutputStream bos;
	private ChatNI ni;
	private Socket soc;
	
	
	public TCPSender(ChatNI ni, String hostname, Socket soc, File file){
		this.hostname = hostname;
		this.bos = new ByteArrayOutputStream((int) file.length());
		this.ni = ni;
		this.soc = soc;
	}
	
	
	public void transfert(File file) {
        byte[] bufOut = new byte[(int) file.length()];
        FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
	        ObjectOutputStream oos= new ObjectOutputStream(fos);
	        
	        // Ecriture dans le flux de sortie
	        oos.writeObject(file);
	        // Vide le tampon
	        oos.flush();
	        bufOut = this.bos.toByteArray();
	
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


	public ByteArrayOutputStream getBos() {
		return bos;
	}


	public void setBos(ByteArrayOutputStream bos) {
		this.bos = bos;
	}

}
