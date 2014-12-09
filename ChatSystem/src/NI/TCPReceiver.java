package NI;

import java.net.Socket;

public class TCPReceiver extends Thread {
	
	Socket soc;
	
	public Socket getSoc() {
		return soc;
	}
	
	public void run() {

	}

	public void setSoc(Socket soc) {
		this.soc = soc;
	}

	public TCPReceiver (Socket soc) {
		this.soc = soc;
	}

}
