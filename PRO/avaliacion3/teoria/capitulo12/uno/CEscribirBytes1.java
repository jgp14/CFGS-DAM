package teoria.capitulo12.uno;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import misClases.teoria.Leer;

public class CEscribirBytes1 {

	public static void main(String[] args) {
		
		FileWriter fs = null;
		String nombreFichero = null;
		File fichero = null;
		String texto = null;
		
		try {
			System.out.print("Nombre del fichero: ");
			nombreFichero = Leer.datoString();
			fichero = new File(nombreFichero);
			System.out.println("Escriba el texto "
					+ "que desea almacenar en el fichero:");
			texto = Leer.datoString();
			fs = new FileWriter(fichero);
			fs.write(texto, 0, texto.length());
		}catch(IOException e) {
			System.out.println("Error: "+e.toString());
		}finally {
			try {
				// Cerrar el fichero
				if(fs != null) fs.close();
			}catch(IOException e) {
				System.out.println("Error: "+e.toString());
			}
		}
	}

}
