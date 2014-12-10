package NI;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.net.Socket;

import Signals.FileMessage;

public class TCPReceiver extends Thread {
	
	private Socket soc;
	private ChatNI ni;
	
	public TCPReceiver (Socket soc, ChatNI ni) {
		this.soc = soc;
		this.ni = ni;
	}
	

	public void run() {
		byte[] bufIn = new byte[1024];
	
		try {
			InputStream is = (InputStream) soc.getInputStream();
	        // Lecture du filemsg
	        is.read(bufIn);
			ByteArrayInputStream byteIn = new ByteArrayInputStream(bufIn);
	        ObjectInput oi= new ObjectInputStream(byteIn);
	        
	        System.out.println("reception du filmsg");
	        // Lecture du filemsg
			FileMessage fmsg = (FileMessage) oi.readObject();
			FileOutputStream fos = new FileOutputStream("./" + fmsg.getNamefile());
	        
			// appel au NI
			this.ni.rcvdFile(fmsg.getNickname(), fmsg.getNamefile(), fmsg.getDest());
			
			// configuration du bufIn et du FileOutputStream
			bufIn = null;
			bufIn = new byte[(int) fmsg.getFileSize()];
			
			System.out.println("Reception du file dans le buffer");
	        
	        System.out.println("enregistrement du file sur le disque");
	        // Ecriture dans le "fmsg.getNameFile()" du file present dans le bufIn
	        while(is.read(bufIn, 0, bufIn.length) != -1) {
	        	fos.write(bufIn, 0, bufIn.length);
	        }
	        
	    	fos.close();
	    	oi.close();
	    	is.close();
	    	
	    	soc.close();
    	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	//////////////////////////////////////////
	//         GETTER ET SETTER             //
	//////////////////////////////////////////	
	
	public Socket getSoc() {
		return soc;
	}
	
	public void setSoc(Socket soc) {
		this.soc = soc;
	}

}
