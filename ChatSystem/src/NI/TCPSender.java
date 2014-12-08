package NI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TCPSender extends Thread {
	private String hostname;
	private ChatNI ni;
	
	
	
	public byte[] convertFileToByte (File fichier) {
		byte[] fileByte = new byte[(int) fichier.length()];
        FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(fichier);
			fileInputStream.read(fileByte);
		} catch (FileNotFoundException e1) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("IOException : convertFileToByte error");
		}
        return fileByte;
	}
	
	static public byte[] fileToByte(File file) throws IOException {
		InputStream in = new BufferedInputStream(new FileInputStream(file));
		ByteArrayOutputStream result = new ByteArrayOutputStream();
		BufferedOutputStream tmp = new BufferedOutputStream(result);
		for (int b=in.read(); b != -1; b=in.read()) {
		tmp.write(b);
		}
		in.close();
		tmp.close();
		return result.toByteArray();
		} 

}
