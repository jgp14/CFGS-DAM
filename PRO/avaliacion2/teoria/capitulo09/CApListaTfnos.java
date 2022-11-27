package teoria.capitulo09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import misClases.teoria.CListaTfnos;
import misClases.teoria.CPersona;
import misClases.teoria.Leer;

public class CApListaTfnos {
	
	public static int menu() {
		System.out.println("\n\n");
		System.out.println("1. Buscar");
		System.out.println("2. Buscar siguiente");
		System.out.println("3. Anhadir");
		System.out.println("4. Eliminar");
		System.out.println("5. Mostrar");
		System.out.println("6. Salir");
		System.out.println();
		System.out.println("   Opcion: ");
		int op;
		do {
			op = Leer.datoInt();
		} while(op < 1 || op > 6);
		return op;
	}

	public static void main(String[] args) throws IOException {
		// Definir un flujo de caracteres de entrada: flujoE
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader flujoE = new BufferedReader(isr);
		// Definir una referencia al flujo estandar de salida: flujosS
		PrintStream flujoS = System.out;
		
		// Crear un objeto lista de telefonos vacio (con cero elementos)
		CListaTfnos listatfnos = new CListaTfnos();
		int opcion = 0, pos = -1;
		String cadenabuscar = null;
		String nombre, direccion;
		long telefono;
		boolean eliminado = false;
		do {
			try {
				opcion = menu();
				switch (opcion) {
				case 1: // buscar
					flujoS.print("conjunto de caracteres a buscar ");
					cadenabuscar = flujoE.readLine();
					pos = listatfnos.buscar(cadenabuscar, 0);
					if(pos == 1)
						if(listatfnos.longitud() != 0)
							flujoS.println("busqueda fallida");
						else
							flujoS.println("lista vacia");
					else {
						flujoS.println(listatfnos.valorEn(pos).obtenerNombre());
						flujoS.println(listatfnos.valorEn(pos).obtenerDireccion());
						flujoS.println(listatfnos.valorEn(pos).obtenerTelefono());
					}
					break;
				case 2: // buscar siguiente
					pos = listatfnos.buscar(cadenabuscar, pos + 1);
					if(pos == 1)
						if(listatfnos.longitud() != 0)
							flujoS.println("busqueda fallida");
						else
							flujoS.println("lista vacia");
					else {
						flujoS.println(listatfnos.valorEn(pos).obtenerNombre());
						flujoS.println(listatfnos.valorEn(pos).obtenerDireccion());
						flujoS.println(listatfnos.valorEn(pos).obtenerTelefono());
					}
					break;
				case 3: // anhadir
					flujoS.print("nombre:    "); nombre = flujoE.readLine();
					flujoS.print("direccion: "); direccion = flujoE.readLine();
					flujoS.print("telefono:  "); telefono = Leer.datoLong();
					listatfnos.anhadir(new CPersona(nombre, direccion, telefono));
					break;
				case 4: // eliminar
					flujoS.print("telefono: "); telefono = Leer.datoLong();
					eliminado = listatfnos.eliminar(telefono);
					if(eliminado)
						flujoS.println("registro eliminado");
					else
						if(listatfnos.longitud() != 0)
							flujoS.println("telefono no encontrado");
						else
							flujoS.println("lista vacia");
					break;
				case 5: // mostrar
					listatfnos.mostrarListaTfnos();
					break;
				case 6: // salir
					listatfnos = null;
				}
			} catch (IOException ignorada) {
				
			}
		} while(opcion != 6);
	}
}
