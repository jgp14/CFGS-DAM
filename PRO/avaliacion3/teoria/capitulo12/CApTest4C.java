package teoria.capitulo12;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class CApTest4C {

	public static void main(String[] args) {
		FileOutputStream fs = null;
		byte[] buffer = new byte[81];
		int nbytes;
		String nombreFichero = null;
		File fichero = null;
		
		try {
			System.out.print("Nombre del fichero: ");
			nbytes = System.in.read(buffer);
			nombreFichero = new String(buffer, 0, nbytes -2); 
			fichero = new File(nombreFichero);
			
			char resp = 's';
			if(fichero.exists()) {
				System.out.print("El");
				resp = (char)System.in.read();
				System.in.skip(System.in.available());
			}
			
		} catch(IOException e){
			System.out.println("Error " + e.getMessage());
			
		}

	}

}
