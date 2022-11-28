package teoria.capitulo12.dos;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintStream;

import misClases.teoria.CPersona;

class MostrarListaTfnosExer6 {

	public static void mostrarFichero(String nombreFichero)
		throws IOException {
		PrintStream flujoS = System.out;
		ObjectInputStream ois = null; 
		File fichero = null;
		
		try {
			fichero = new File(nombreFichero);
			if(fichero.exists()) {
				ois = new ObjectInputStream(
						new FileInputStream(fichero));
				flujoS.println("\nListado");
				while(true){
					CPersona persona = (CPersona)ois.readObject();
					persona.mostrar();
				}
			}
			flujoS.println("El fichero no existe");
		} catch(EOFException e) {
			flujoS.println("Fin del listado");
		} catch(ClassNotFoundException e) {
			System.out.println("Error: "+e.getMessage());
		} finally {
			if(ois != null) ois.close();
		}
	}

	public static void main(String[] args) {
		if(args.length != 1)
			System.err.println("Sintaxis: java "
					+ "MostrarListaTfnos <fichero fuente>");
		else {
			try {
				mostrarFichero(args[0]);
			} catch(IOException e) {
				System.out.println("Error: "+e.getMessage());
			}
		}
	}

}
