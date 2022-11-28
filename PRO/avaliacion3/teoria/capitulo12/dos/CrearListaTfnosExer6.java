package teoria.capitulo12.dos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException; 
import java.io.ObjectOutputStream;
import java.io.PrintStream;

import misClases.teoria.CPersona;
import misClases.teoria.Leer;

class CrearListaTfnosExer6 {
	// Emplear ObjectInputStream y Emplear ObjectOutputStream
	// Datos de persona y telefono seran generados automatico
	
	public static void crearFichero(File fichero) 
			throws IOException {
		PrintStream flujoS = System.out;
		ObjectOutputStream oos = null; 
		String nombre, direccion;
		Long telefono;
		char resp;
		
		try {
			oos = new ObjectOutputStream
					(new FileOutputStream(fichero));
			CPersona persona = new CPersona();
			do {
				persona.asignarDatos();
				persona.mostrar();
				nombre = persona.obtenerNombre();
				direccion = persona.obtenerDireccion();
				telefono = persona.obtenerTelefono();
				
				oos.writeObject(new CPersona
						(nombre, direccion, telefono));
				flujoS.print
				("desea escribir otro registro? (s/n) ");
				resp = Leer.datoChar();
				Leer.limpiar();
			} while(resp == 's');
		} finally {
			if(oos != null)
				oos.close();
		}
	}
	
	public static void main(String[] args) {
		PrintStream flujoS = System.out;
		File fichero = null;
		if(args.length != 1) {
			System.err.println("Sintaxis: java "
				+ "CrearListaTfnosExer6 <fichero fuente>");
		}else {
			try {
				fichero = new File(args[0]);
				char resp = 's';
				if(fichero.exists()) {
					flujoS.print("El fichero existe "
							+ "desea sobreescribirlo? (s/n) ");
					resp = Leer.datoChar();
					Leer.limpiar();
				}
				if(resp == 's')
					crearFichero(fichero);
			}catch(IOException e) {
				flujoS.println("Error--: "+e.getMessage());
			}
		}
	}

}
