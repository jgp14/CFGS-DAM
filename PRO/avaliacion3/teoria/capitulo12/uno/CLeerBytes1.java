package teoria.capitulo12.uno;

import java.io.FileInputStream;
import java.io.IOException;

import misClases.teoria.Leer;

public class CLeerBytes1 {

	public static void main(String[] args) {
		
		FileInputStream fe = null;
		StringBuffer buffer = new StringBuffer();
		String nombreFichero = null;
		
		try {
			System.out.print("Nombre del fichero: ");
			nombreFichero = Leer.datoString();			
			int letra = 0;
			/*do {	
			}while();*/
			fe = new FileInputStream(nombreFichero);
			while((letra = fe.read()) != -1)
				buffer.append((char) letra);
			String str = new String(buffer);
			System.out.println(str);
		} catch(IOException e){
			System.out.println("Error: " + e.toString());
		} finally {
			try {
				// Cerrar el fichero
				if(fe != null) fe.close();
			} catch(IOException e) {
				System.out.println("Error: "+e.toString());
			}
		}
	}

}
