package NI;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class TCPServer extends Thread {
	private String hostname;
	private ServerSocket server;
	private ChatNI ni;
	private int port;
	

	public TCPServer (String hostname, ServerSocket server, ChatNI ni, int port) {
		this.hostname = hostname;
		//this.server = new ServerSocket(port);
		this.server = server;
		this.ni = ni;
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

		
	
	//////////////////////////////////////////
	//         GETTER ET SETTER             //
	//////////////////////////////////////////	
	
	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public ChatNI getNi() {
		return ni;
	}

	public void setNi(ChatNI ni) {
		this.ni = ni;
	}

}

