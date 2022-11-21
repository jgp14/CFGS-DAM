package ud1_boletin7;

import java.io.File;
import java.io.IOException;

public class LanzaComandoFiles {

	public static void main(String[] args) {
		ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "DIR /ad");		
		File fOut = new File("salida.txt");
		File fErr = new File("error.txt");
		pb.redirectOutput(fOut);
		pb.redirectError(fErr);
		try {
			pb.start();
		}catch(IOException ex) {
			System.err.println("Exception de E/S!!");
			System.exit(-1);
		}
	}
}