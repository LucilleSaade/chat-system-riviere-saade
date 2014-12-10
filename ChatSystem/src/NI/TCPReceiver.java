package NI;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import org.omg.CORBA.portable.InputStream;

import Signals.AbstractMessage;
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
			ByteArrayInputStream byteIn = new ByteArrayInputStream(bufIn);
	
			InputStream is;
			is = (InputStream) soc.getInputStream();
			
	        ObjectInput oi= new ObjectInputStream(byteIn);
	        
	        // Lecture du filemsg
			FileMessage fmsg = (FileMessage) oi.readObject();
	        
			// configuration du bufIn et du FileOutputStream
			bufIn = new byte[(int) fmsg.getFileSize()];
			FileOutputStream fos = new FileOutputStream("./" + fmsg.getNamefile());
			
	        // Lecture du file
	        is.read(bufIn);
	        
	        // Ecriture dans le "fmsg.getNameFile()" du file orésent dans le bufIn
	        fos.write(bufIn);
	        
	    	fos.close();
	    	oi.close();
	    	is.close();
	    
	    	this.ni.rcvdFile(fmsg.getNickname(), fmsg.getNamefile());
	    	
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
