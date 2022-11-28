package teoria.capitulo12.uno;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import misClases.teoria.Leer;

public class CLeerCars1 {

	public static void main(String[] args) {
		StringBuffer buffer = new StringBuffer();
		String nombreFichero = null;
		File fichero = null;
		FileReader fe = null;
		
		try {
			do {
				System.out.print("Nombre del fichero: ");
				nombreFichero = Leer.datoString();
				fichero = new File(nombreFichero);
				fe = new FileReader(fichero);
			} while(!fichero.exists());
			
			int letra = 0;
			while((letra = fe.read()) != -1)
				buffer.append((char) letra);
			String str = new String(buffer);
			System.out.println(str);
		} catch(IOException e) {
			System.out.println("Error: "+e.toString());
		}finally {
			try {
				// Cerrar el fichero
				if(fe != null) fe.close();
			} catch(IOException e) {
				System.out.println("Error: "+e.toString());
			}
		}
	}

}
