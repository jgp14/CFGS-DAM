package teoria.capitulo12;

import java.io.*;

public class CApCrearListaTfnos {

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
		// Definir un flujo de caracteres de entrada: flujoE
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader flujoE = new BufferedReader(isr);
		// Definir una referencia al flujo estandar de salida: flujoS
		PrintStream flujoS = System.out;
		
		CListaTfnos listatfnos;
		int opcion = 0, pos = -1;
		String cadenabuscar = null;
		String nombre, direccion;
		long telefono;
		boolean eliminado = false;
		boolean listaModificada = false;
		
		try {
			// Crear un objeto lista de telefonos vacio 
			// (con 0 elementos) o con el contenido del fichero
			// listatfnos.dat si existe.
			File fichero = new File("listatfnos.dat");
			if(!fichero.exists()) {
				listatfnos = new CListaTfnos();
				flujoS.println
				("Se ha creado una lista de telefonos nueva");
			}
			else {
				ObjectInputStream ois = new ObjectInputStream
						(new FileInputStream("listatfnos.dat"));
				listatfnos = (CListaTfnos)ois.readObject();
				ois.close();
				flujoS.println
				("Se cargo la lista de telefonos con exito");
			}
			do {
				opcion = menu();
				switch(opcion) {
				case 1: // buscar
					flujoS.print("conjunto de caracteres a buscar");
					cadenabuscar = flujoE.readLine();
					pos = listatfnos.buscar(cadenabuscar, 0);
					if(pos == -1)
						if(listatfnos.longitud() != 0)
							flujoS.println("busqueda fallida");
						else
							flujoS.println("lista vacia");
					else {
						flujoS.println
						(listatfnos.valorEn(pos).obtenerNombre());
						flujoS.println
						(listatfnos.valorEn(pos).obtenerDireccion());
						flujoS.println
						(listatfnos.valorEn(pos).obtenerTelefono());
						break;
					}
				case 2: // buscar siguiente
					pos = listatfnos.buscar(cadenabuscar, pos + 1);
					if(pos == -1) {
						if(listatfnos.longitud() != 0)
							flujoS.println("busqueda fallida");
						else
							flujoS.println("lista vacia");
					}
					else {
						flujoS.println(listatfnos.valorEn(pos).obtenerNombre());
						flujoS.println(listatfnos.valorEn(pos).obtenerDireccion());
						flujoS.println(listatfnos.valorEn(pos).obtenerTelefono());
					}
					break;
				case 3: // añadir
					flujoS.print("nombre:    "); nombre = flujoE.readLine();
					flujoS.print("direccion: "); direccion = flujoE.readLine();
					flujoS.print("telefono:  "); telefono = Leer.datoLong();
					listaModificada = true;
					break;
				case 4: // eliminar
					flujoS.print("telefono:  "); telefono = Leer.datoLong();
					eliminado = listatfnos.eliminar(telefono);
					if(eliminado) {
						flujoS.println("registro eliminado");
						listaModificada = true;
					}
					else {
						if(listatfnos.longitud() != 0)
							flujoS.println("telefono no encontrado");
						else
							flujoS.println("lista vacia");
					}
					break;
				case 5: // salir
					// guardar lista
					if(listaModificada) {
						ObjectOutputStream ous = new ObjectOutputStream
								(new FileOutputStream("listatfnos.dat"));
						ous.writeObject(listatfnos);
						ous.close();
					}
					listatfnos = null;
				}
			} while(opcion != 5);
		}catch(IOException e) {
			System.out.println("Error: "+e.getMessage());
		}
		catch(ClassNotFoundException e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
}

