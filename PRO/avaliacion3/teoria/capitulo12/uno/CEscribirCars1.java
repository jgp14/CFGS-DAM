package teoria.capitulo12.uno;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import misClases.teoria.Leer;

public class CEscribirCars1 {

	public static void main(String[] args) {
		FileWriter fs = null;
		String nombreFichero = null;
		File fichero = null;
		String str = null;
		
		try {
			System.out.print("Nombre del fichero: ");
			nombreFichero = Leer.datoString(); 
			// menos CR+LF
			fichero = new File(nombreFichero);
			
			char resp = 's';
			if(fichero.exists()) {
				System.out.print("El fichero existe "
						+ "¿desea sobreescribirlo (s/n)?");
				resp = (char)System.in.read();
				// Saltar los bytes no leidos del flujo in
				System.in.skip(System.in.available());
			}
			if(resp == 's') {
				System.out.println("Escriba el texto que "
						+ "desea almacenar en el fichero");
				str = Leer.datoString();
				fs = new FileWriter(fichero);
				fs.write(str, 0, str.length());
			}
		}catch(IOException e) {
			System.out.println("Error: "+e.toString());
		}finally {
			try {
				// Cerrar el fichero
				if(fs != null) fs.close();
			}catch (IOException e) {
				System.out.println("Error: "+e.toString());
			}
		}
	}

}
