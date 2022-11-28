package teoria.capitulo12.uno;

import java.io.FileInputStream;
import java.io.IOException;

public class CLeerBytes {

	public static void main(String[] args) {
		FileInputStream fe = null;
		byte[] buffer = new byte[81];
		int nbytes;
		String nombreFichero = null;
		
		try {
			nombreFichero = "texto.txt";
			System.out.println("Nombre del fichero: "+nombreFichero);
			fe = new FileInputStream(nombreFichero);
			nbytes = fe.read(buffer, 0, 81);
			String str = new String(buffer, 0, nbytes);
			System.out.println(str);
		} catch(IOException e) {
			System.out.println("Error: " + e.toString());
		}
		finally {
			try {
				// Cerrar el fichero
				if(fe != null) fe.close();
			} catch(IOException e) {
				System.out.println("Error: "+e.toString());
			}
		}
	}

}
