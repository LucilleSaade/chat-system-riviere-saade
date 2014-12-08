package NI;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class TCPServer extends Thread {
	private ServerSocket server;
	private int port;
	

	public TCPServer (ServerSocket server, int port) {
		//this.server = new ServerSocket(port);
		this.server = server;
		this.port = port;

	}
	
	public void run() {	
		Socket soc;
		while(true) {
			try {
				soc = server.accept();
		 		// TODO TCPReceiver receiver = new TCPReceiver(soc);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}



}

