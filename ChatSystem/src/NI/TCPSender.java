package NI;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
	
	
	/**
	 * TCPSender constructor :
	 * instantiate the user field, the dest field, the bos field, the port, field, the file field,
	 * the fmsg field (FileMessage object), and the Nickname of the fmsg field.
	 * @param user : String
	 * @param dest : ArrayList<String>
	 * @param file : File
	 * @param port: int
	 */
	public TCPSender(String user, ArrayList<String> dest, File file, int port){
		this.user= user;
		this.dest = dest;
		this.bos = new ByteArrayOutputStream((int) file.length());
		this.port = port;
		this.file = file;
		this.fmsg = new FileMessage(file.getName(), dest, file.length());
		this.fmsg.setNickname(user);
	}		
		
	
	/**
	 * run() : for each recipient, serialise the fmsg and send it.
	 */
	public void run() {
        byte[] bufOut = new byte[(int) file.length()];
        FileInputStream fis;
        Socket soc;
		try {
			ListIterator<String> itr = dest.listIterator();
			while(itr.hasNext()){
				soc = new Socket(IPAddress.getIPaddress(itr.next()), this.port);
				//Preparation des objets necessaires pour l'envoie des file et filemsg
				OutputStream os = soc.getOutputStream();
		        ObjectOutputStream oos= new ObjectOutputStream(bos);
		        oos.flush();

		        // Ecriture dans le flux de sortie, envoie du file message ne contenant que le nom et la taille du fichier
		        oos.writeObject(this.fmsg);
		        
		        bufOut = this.bos.toByteArray();
		        os.write(bufOut);
	
		        fis = new FileInputStream(this.file);
		        //bufOut = this.bos.toByteArray();
		        byte[] buffer = new byte[(int) this.file.length()];
		        //Ecriture du file dans le bufOut
		        fis.read(buffer);
		        //Envoie du file
		        os.write(buffer);
		        
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

	/**
	 * GETTERS AND SETTERS
	 */
	
	/**
	 * getDest()
	 * @return dest : ArrayList<String>
	 */
	public ArrayList<String> getDest() {
		return dest;
	}

	/**
	 * setDest()
	 * @param dest : ArrayList<String>
	 */
	public void setDest(ArrayList<String> dest) {
		this.dest = dest;
	}

	/**
	 * getNi()
	 * @return ni : ChatNI
	 */
	public ChatNI getNi() {
		return ni;
	}

	/**
	 * setNi()
	 * @param ni : ChatNI
	 */
	public void setNi(ChatNI ni) {
		this.ni = ni;
	}

	/**
	 * getBos()
	 * @return bos : ByteArrayOutputStream
	 */
	public ByteArrayOutputStream getBos() {
		return bos;
	}

	/**
	 * setBos()
	 * @param bos : ByteArrayOutputStream
	 */
	public void setBos(ByteArrayOutputStream bos) {
		this.bos = bos;
	}

}
