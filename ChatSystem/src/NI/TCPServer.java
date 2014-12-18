package NI;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;


public class TCPServer extends Thread {
	private ServerSocket server;
	private ChatNI ni;
	
	/**
	 * This class allows to create a TCPServer to receive files from remote users
	 */
	
	/**
	 * TCPServer constructor
	 * instantiate the ServerSocket and the chatNI
	 * @param ServerSocket server
	 * @param ChatNI ni
	 */
	
	public TCPServer (ServerSocket server, ChatNI ni) {
		this.server = server;
		this.ni = ni;
		System.out.println("Serveur cree");
	}
	
	/**
	 * run() : thread method
	 * Creates a new TCPReceiver() when the ServerSocket accepts a connexion
	 */

	public void run() {	
		Socket soc;
		try {
			while(true) {

				System.out.println("Creation nouveau socket");
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
	
	/**
	 * getServer() 
	 * @return ServerSocket server
	 */
	public ServerSocket getServer() {
		return server;
	}

}

