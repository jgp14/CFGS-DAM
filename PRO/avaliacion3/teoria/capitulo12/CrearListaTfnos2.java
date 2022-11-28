package teoria.capitulo12;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintStream;

import teoria.capitulo10.CPersona;

public class CrearListaTfnos2 {
	public static void crearFichero(File fichero) 
			throws IOException{
		PrintStream flujoS = System.out; // salida estandar
		ObjectOutputStream oos = null; 
		// salida de datos hacia el fichero
		char resp;
		
		try {
			// Crear un flujo hacia el fichero que permita escribir
			// datos de tipos primitivos y que utilice un buffer.
			oos = new ObjectOutputStream(new BufferedOutputStream
					(new FileOutputStream(fichero)));
			// Declarar los datos a escribir en el fichero
			String nombre, direccion;
			long telefono;
			
			// Leer datos de la entrada estandar y escribirlos
			// en el fichero
			do {
				flujoS.print("nombre:     "); 
				nombre = Leer.dato();
				flujoS.print("direccion:  "); 
				direccion = Leer.dato();
				flujoS.print("telefono:  "); 
				telefono = Leer.datoLong();
				
				// Crear un objeto CPersona y almacenarlo en 
				// el fichero oos: writeObject
				// (new CPersona(nombre, direccion, telefono));
				oos.writeObject
				(new CPersona(nombre, direccion, telefono));
				
				flujoS.print
				("¿desea escribir otro registro? (s/n)");
				resp = Leer.caracter();
				Leer.limpiar();
			}while (resp == 's');
		}
		finally {
			// Cerrar el flujo
			if(oos != null) oos.close();
		}
	}
	
	public static void main(String[] args) {
		PrintStream flujoS = System.out; // salida estandar
		String nombreFichero = null;	 // nombre del fichero
		File fichero = null; // objeto que identifica el fichero
		
		try {
			// Crear un objeto File que identifique al fichero
			flujoS.print("Nombre del fichero: ");
			nombreFichero = Leer.dato();
			fichero = new File(nombreFichero);
			
			// Verificar si el fichero exista
			char resp = 's';
			if(fichero.exists()) {
				flujoS.print
				("El fichero existe ¿deseo sobreescribirlo (s/n?) ");
				resp = Leer.caracter();
				Leer.limpiar();
			}
			if(resp == 's') {
				crearFichero(fichero);
			}
		} catch(IOException e) {
			flujoS.println("Error: "+e.getMessage());
		}
	}
}
