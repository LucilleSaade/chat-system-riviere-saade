package NI;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
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
	
	/*
	public void run2() {
	
		File f = this.file; 
		if(f.exists()) { 
			System.out.println("Envoi du fichier "+f.toURI().toURL()); 
			Socket s = new Socket(InetAddress.getByName(serv),port); 

			OutputStream fluxsortie = s.getOutputStream(); 
			
			long taillefichier =f.length(); 

			System.out.println("Taille : "+ taillefichier); 

			long nbpassagesuposé=taillefichier / 4096; 

			System.out.println("Passages supposés : "+nbpassagesuposé); 

			InputStream in = new BufferedInputStream(new FileInputStream(f)); 
			ByteArrayOutputStream tableaubytes = new ByteArrayOutputStream(); 
			BufferedOutputStream tampon = new BufferedOutputStream(tableaubytes); 

			int lu = in.read(); 
			int[] aecrire = new int[4096]; 
			int compteur = 0; 
			long ouonestrendu=0; 
		
			//Tant qu'on est pas à la fin du fichier 
			while(lu > -1) { 
				//On lit les données du fichier 
				aecrire[compteur] = lu; 
				lu = in.read(); 
				compteur++; 
				//Quand on a rempli le tableau, on envoie un paquet de 4096 octets 
				if(compteur == 4096) { 
					compteur=0; 
					ouonestrendu++; 
					//On remplit le tampon 
					for(int x=0;x<4096;x++) 
						tampon.write(aecrire[x]); 
				
					//Et on l'envoie 
					fluxsortie.write(tableaubytes.toByteArray()); 
				
					tableaubytes.reset(); 
					System.out.println("Avancement : "+(float) ouonestrendu/nbpassagesuposé * 100+"%"); 
				} 
			} 

				//On envoie le dernier paquet, qui ne fait pas forcément 4096 octets 
				//On remplit le tampon 
			for(int x=0;x<4096;x++) 
				tampon.write(aecrire[x]); 

			//Et on l'envoie 
			tampon.flush(); 
			fluxsortie.write(tableaubytes.toByteArray()); 
			fluxsortie.flush(); 
		
			System.out.println("Avancement: "+(float) ouonestrendu/nbpassagesuposé * 100+"%"); 
		
			System.out.println("Youpi finished"); 
			in.close(); 
			tampon.close(); 
			System.out.println("Passages effectués : "+ouonestrendu); 
			s.close(); 
		} 
		else { 
			System.out.println("Le fichier "+f+" est introuvable"); 
		} 
	} */

		
		
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
