package NI;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class TCPServer extends Thread {
	private ServerSocket server;
	private String hostname;
	private int port;
	private ChatNI ni;
	
	public TCPServer (ServerSocket server, String hostname, int port, ChatNI ni) {
		this.server = server;
		this.hostname = hostname;
		this.port = port;
		this.ni = ni;
	}
	
	public void run() {	
		Socket soc;
		while(true) {
			try {
				System.out.println("Création nouveau socket");
				soc = new Socket(IPAddress.getIPaddress(this.hostname), this.port);
		 		TCPReceiver receiver = new TCPReceiver(soc, this.ni);
		 		System.out.println("lancement du receiver");
		 		receiver.start();
		 		
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}



}

