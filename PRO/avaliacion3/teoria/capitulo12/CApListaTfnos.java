package teoria.capitulo12;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

public class CApListaTfnos {

	// Definir una referencia al 
	// flujo estandar de salida:flujoS
	static PrintStream flujoS = System.out;
	
	static CListaTfnos2 listatfnos;
	
	public static boolean modificar(int nreg) 
	throws IOException{
		String nombre, direccion;
		long telefono;
		int op;
		// Leer el registro
		CPersona obj = listatfnos.valorEn(nreg);
		if(obj == null) return false;
		
		// Modificar el registro
		do {
			flujoS.print("\n\n");
			flujoS.println("Modificar el dato:");
			flujoS.println("1. Nombre");
			flujoS.println("2. Direccion");
			flujoS.println("3. Telefono");
			flujoS.println("4. Salir y salvar los cambios");
			flujoS.println("5. Salir sin salvar los cambios");
			flujoS.println();
			op = Leer.datoInt();
			
			switch(op) {
			case 1: // modificar nombre
				flujoS.print("nombre:      ");
				nombre = Leer.dato();
				obj.asignarNombre(nombre);
				break;
			case 2:	// modificar direccion 
				flujoS.print("direccion::   ");
				direccion = Leer.dato();
				obj.asignarDireccion(direccion);
				break; // modificar telefono
			case 3:
				flujoS.print("telefono:     ");
				telefono = Leer.datoLong();
				obj.asignarTelefono(telefono);
				break;
			case 4:	// guardar los cambios
				break;
			case 5: // salir sin guardar los cambios
				break;
			}
		}while(op != 4 && op != 5);
		if(op == 4) {
			listatfnos.ponerValorEn(nreg, obj);
			return true;
		}
		else
			return false;
	}
	
	public static void imprimirListaTfnos() 
	throws IOException {
		// Crear un flujo hacia la impresora
		FileWriter flujoS = new FileWriter("LPT1");
		
		String crlf = "\r\n"; // cambiar a la siguiente linea
		String ff = "\f"; 	  // saltar a la siguiente pagina
		Integer i;  		  // referencia a un objeto integer
		Long l; 			  // referencia a un objeto long
		int nregs = listatfnos.longitud(); 
		// numero de  registros
		
		for(int n = 0; n < nregs; n++) {
			// Saltar pagina inicialmente y 
			// despues cada 60 lineas
			if(n % 60 == 0) flujoS.write(ff);
			// Imprimir el registro n de la lista de telefonos
			i = new Integer(n); // numero de registro
			flujoS.write(listatfnos.valorEn(n).obtenerNombre()+crlf);
			flujoS.write(listatfnos.valorEn(n).obtenerDireccion()+crlf);
			l = new Long(listatfnos.valorEn(n).obtenerTelefono());
			flujoS.write(l.toString() + crlf);
			flujoS.write(crlf); // saltar una linea
		}
		flujoS.write(ff); // saltar a la siguiente pagina
		flujoS.close();   // cerrar el flujo hacia la impresora
		
	}
	
	public static void actualizar(File fActual)
	throws IOException{
		// Crear un fichero temporal
		File ficheroTemp = new File("listatfnos.tmp");
		CListaTfnos2 ftemp = new CListaTfnos2(ficheroTemp);
		
		int nregs = listatfnos.longitud();
		// Copiar en el fichero temporal 
		// todos los registros del fichero actual que en 
		// su campo telefono no tengan un 0
		CPersona obj;
		for(int reg_i = 0; reg_i < nregs; reg_i++) {
			obj = listatfnos.valorEn(reg_i);
			if(obj.obtenerTelefono() != 0)
				ftemp.anadir(obj);
		}
		listatfnos.cerrar();
		ftemp.cerrar();
		fActual.delete();
		if(!ficheroTemp.renameTo(fActual))
			throw new IOException("no se renombro el fichero");
	}
	
	public static int menu() {
		System.out.print("\n\n");
		System.out.println("1. Buscar");
		System.out.println("2. Buscar siguiente");
		System.out.println("3. Añadir");
		System.out.println("4. Eliminar");
		System.out.println("5. Salir");
		System.out.println();
		System.out.println("   Opcion: ");
		int op;
		do
			op = Leer.datoInt();
		while(op < 1 || op > 5);
		return op;
	}
	
	public static void main(String[] args) {

		int opcion = 0, pos = -1;
		String cadenabuscar = null;
		String nombre, direccion;
		long telefono;
		
		boolean eliminado = false;
		boolean modificado = false;
		boolean listaModificada = false;
		
		try {
			// Crear un objeto lista de telefonos vacio
			// con 0 elementos o con el contenido del 
			// fichero listatfnos.dat si existe
			File fichero = new File("listatfnos.dat");
			listatfnos = new CListaTfnos2(fichero);
			
			do {
				opcion = menu();
				
				switch(opcion) {
				case 1: // buscar
				case 2: // buscar siguiente
				case 3: // modificar
				case 4: // añadir
				case 5: // eliminar
				case 6: // imprimir
					imprimirListaTfnos();
					break;
				case 7: // salir
					// guardar lista
					if(eliminado) actualizar(fichero);
						listatfnos = null;
				}
			}while(opcion != 6);
		}catch (IOException e) {
			flujoS.println("Error: "+e.getMessage());
		}/*catch(ClassNotFoundException e) {
			flujoS.println("Error ClassNotFound: "+e.getMessage());
		}*/
	}

}
