package NI;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class TCPServer extends Thread {
	private ServerSocket server;
	private String hostname;
	private int port;
	
	public TCPServer (ServerSocket server, String hostname, int port) {
		this.server = server;
		this.hostname = hostname;
		this.port = port;
	}
	
	public void run() {	
		Socket soc;
		while(true) {
			try {
				soc = new Socket(IPAddress.getIPaddress(this.hostname), this.port);
		 		TCPReceiver receiver = new TCPReceiver(soc);
		 		receiver.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}



}

