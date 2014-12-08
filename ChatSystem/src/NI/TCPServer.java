package NI;

import java.net.Socket;


public class TCPServer extends Thread {
	private String hostname;
	private ChatNI ni;
	private Socket soc;
	
	public TCPServer(ChatNI ni, String hostname, Socket soc){
		this.setHostname(hostname);
		this.setNi(ni);
		this.setSoc(soc);
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

	public Socket getSoc() {
		return soc;
	}

	public void setSoc(Socket soc) {
		this.soc = soc;
	}

}
