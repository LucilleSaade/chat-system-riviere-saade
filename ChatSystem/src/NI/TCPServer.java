package NI;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class TCPServer extends Thread {
	private ServerSocket server;

	public TCPServer (ServerSocket server) {
		//this.server = new ServerSocket(port);
		this.server = server;
	}
	
	public void run() {	
		TCPReceiver soc;
		while(true) {
			try {
				soc = new TCPReceiver(server.accept());
		 		// TODO TCPReceiver receiver = new TCPReceiver(soc);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}



}

