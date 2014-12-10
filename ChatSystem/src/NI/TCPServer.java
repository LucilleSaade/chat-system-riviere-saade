package NI;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;


public class TCPServer extends Thread {
	private ServerSocket server;
	private ChatNI ni;
	
	public TCPServer (ServerSocket server, ChatNI ni) {
		this.server = server;
		this.ni = ni;
		System.out.println("Serveur créé");
	}

	public void run() {	
		Socket soc;
		try {
			while(true) {

				System.out.println("Création nouveau socket");
				soc = server.accept();
			 	TCPReceiver receiver = new TCPReceiver(soc, this.ni);
			 	System.out.println("lancement du receiver");
			 	receiver.start();
			}	
			
		} catch (SocketException e) {
			this.interrupt();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	//////////////////////////////////////////
	//         GETTER ET SETTER             //
	//////////////////////////////////////////
	
	public ServerSocket getServer() {
		return server;
	}

}

