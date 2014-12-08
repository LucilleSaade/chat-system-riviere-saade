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
import java.util.ArrayList;
import java.util.ListIterator;

import Signals.FileMessage;

public class TCPSender extends Thread {
	private String user;
	private ArrayList<String> dest;
	private ByteArrayOutputStream bos;
	private ChatNI ni;
	private File file;
	private FileMessage fmsg;
	private int port;
	
	
	
	public TCPSender(String user, ArrayList<String> dest, File file, int port){
		this.user= user;
		this.dest = dest;
		this.bos = new ByteArrayOutputStream((int) file.length());
		this.port = port;
		this.file = file;
		this.fmsg = new FileMessage(file.getName(), dest, file.length());
		this.fmsg.setNickname(user);
	}
	
	
	public void run() {
        byte[] bufOut;
        FileInputStream fis;
        Socket soc;
		try {
			ListIterator<String> itr = dest.listIterator();
			while(itr.hasNext()){
				soc = new Socket(IPAddress.getIPaddress(itr.next()), this.port);
				//Preparation des objets necessaires pour l'envoie des file et filemsg
				OutputStream os = soc.getOutputStream();
		        ObjectOutputStream oos= new ObjectOutputStream(bos);
		        
		        // Ecriture dans le flux de sortie, envoie du file message ne contenant que le nom et la taille du fichier
		        oos.writeObject(this.fmsg);
	
		        fis = new FileInputStream(this.file);
		        bufOut = this.bos.toByteArray();
		        
		        //Ecriture du file dans le bufOut
		        fis.read(bufOut);
		        //Envoie du file
		        os.write(bufOut);
		        
		        // Vide le tampon
		        oos.flush();
	
		    	fis.close();
		    	oos.close();
		    	os.close();
		    	soc.close();
			}
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
	
	public ArrayList<String> getDest() {
		return dest;
	}

	public void setDest(ArrayList<String> dest) {
		this.dest = dest;
	}

	public ChatNI getNi() {
		return ni;
	}

	public void setNi(ChatNI ni) {
		this.ni = ni;
	}

	public ByteArrayOutputStream getBos() {
		return bos;
	}


	public void setBos(ByteArrayOutputStream bos) {
		this.bos = bos;
	}

}
