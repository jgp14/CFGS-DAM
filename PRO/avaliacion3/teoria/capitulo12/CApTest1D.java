package teoria.capitulo12;

import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CApTest1D {

	public static void main(String[] args) throws IOException {
		char[] m1 = new char[120];
		File fichero = new File("datos.txt");
		int car;
		
		FileReader flujoE = new FileReader(fichero);
		CharArrayWriter flujoS = new CharArrayWriter();
		
		try {
			while((car = flujoE.read()) != -1) {
				flujoS.write(car);
			}
			flujoS.close();
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
