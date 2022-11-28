package teoria.capitulo12;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintStream;

import teoria.capitulo10.CPersona;

public class MostrarListaTfnos2 {

	public static void mostrarFichero(String nombreFichero)
		throws IOException {
			
		PrintStream flujoS = System.out; // salida estandar
		ObjectInputStream ois = null; 
		// entrada de datos desde el fichero
		File fichero = null; // objeto que identifica el fichero
			
		try {
			// Crear un objeto que identifique al fichero
			fichero = new File(nombreFichero);
				
			// Verificar si el fichero existe
			if(fichero.exists()) {
				// Si existe, abrir un flujo desde el mismo
				ois = new ObjectInputStream(new BufferedInputStream
						(new FileInputStream(fichero)));
				// Declarar los datos a leer desde el fichero
				CPersona persona;
				String nombre, direccion;
				long telefono;
				do {
					// Leer un nombre, una direccion y un telefono 
					// desde el fichero. Cuando se alcance el 
					// final del fichero Java lanzara una 
					// excepcion del tipo EOFException.
					persona = (CPersona)ois.readObject();
					nombre = ois.readUTF();
					direccion = ois.readUTF();
					telefono = ois.readLong();
						
					// Mostrar los datos nombre, 
					// direccion y telefono
					flujoS.print(nombre);
					flujoS.println(direccion);
					flujoS.println(telefono);
					flujoS.println();
				} while(true);
			}
			else 
				flujoS.println("El fichero no existe");
		} catch(EOFException e) {
			flujoS.println("Fin del listado");
		}
		catch(ClassNotFoundException e) {
			flujoS.println("Error: "+e.getMessage());
		}
			
		finally {
			// Cerrar el flujo
			if(ois != null) ois.close();
		}
	}

	public static void main(String[] args) {
		if(args.length != 1)
			System.err.println("Sintaxis: java MostrarListaTfnos" +
					"<fichero fuente>");
		else {
			try {
				mostrarFichero(args[0]);
			} catch(IOException e) {
				System.out.println("Error: "+e.getMessage());
			}
		}
	}
}
