package teoria.capitulo12.dos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import misClases.teoria.CListaTfnos7;
import misClases.teoria.CPersona;
import misClases.teoria.Leer;

class CApListaTfnosExer7 {

	public static int menu() {
	    int op;
	    System.out.print("\n\n");
	    System.out.println("1. Buscar");
	    System.out.println("2. Buscar siguiente");
	    System.out.println("3. Anhadir");
	    System.out.println("4. Eliminar");
	    System.out.println("5. Mostrar");
	    System.out.println("6. Salir");
	    System.out.println();
	    System.out.print("   Opcion: ");
	    do {
	    	op = Leer.datoInt();
	    } while (op < 1 || op > 6);
	    return op;
	}
	  
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
	    BufferedReader flujoE = new BufferedReader(isr);
	    PrintStream flujoS = System.out;
	    CPersona persona = new CPersona();
	    int opcion = 0, pos = -1;
	    String cadenabuscar = null;
	    boolean eliminado = false;
	    boolean listaModificada = false;
	    try {
	    	CListaTfnos7 listatfnos;
	    	File fichero = new File("listatfnos7.dat");
	    	if (!fichero.exists()) {
	    		listatfnos = new CListaTfnos7();
	    		flujoS.println
	    		("Se ha creado una lista de telefonos nueva");
	    	} else {
	    		ObjectInputStream ois = new ObjectInputStream
	    				(new FileInputStream("listatfnos7.dat"));
		        listatfnos = (CListaTfnos7)ois.readObject();
		        ois.close();
		        flujoS.println
		        ("Se cargo la lista de telefonos con exito");
	    	} 
	    	do {
		        String nombre, direccion;
		        long telefono;
		        opcion = menu();
		        switch (opcion) {
		        	case 1:
			            flujoS.print
			            ("conjunto de caracteres a buscar ");
			            cadenabuscar = flujoE.readLine();
			            pos = listatfnos.buscar(cadenabuscar, 0);
			            if (pos == -1) {
			            	if (listatfnos.longitud() != 0) {
				                flujoS.println
				                ("busqueda fallida");
				                break;
			            	} 
			            	flujoS.println("lista vacia");
			            	break;
			            } 
			            flujoS.println(listatfnos.
			            		valorEn(pos).obtenerNombre());
			            flujoS.println(listatfnos.
			            		valorEn(pos).obtenerDireccion());
			            flujoS.println(listatfnos.
			            		valorEn(pos).obtenerTelefono());
			            break;
		        	case 2:
			            pos = listatfnos.buscar
			            (cadenabuscar, pos + 1);
			            if (pos == -1) {
			            	if (listatfnos.longitud() != 0) {
			            		flujoS.println("bfallida");
			            		break;
			            	} 
			            	flujoS.println("lista vacia");
			            	break;
			            } 
			            flujoS.println(listatfnos.
			            		valorEn(pos).obtenerNombre());
			            flujoS.println(listatfnos.
			            		valorEn(pos).obtenerDireccion());
			            flujoS.println(listatfnos.
			            		valorEn(pos).obtenerTelefono());
			            break;
		        	case 3:
			            persona.asignarDatos();
			            persona.mostrar();
			            nombre = persona.obtenerNombre();
			            direccion = persona.obtenerDireccion();
			            telefono = persona.obtenerTelefono();
			            listatfnos.anhadir(new CPersona
			            		(nombre, direccion, telefono));
			            flujoS.print
			            ("Nuevo registro INCORPORADO "
			            		+ "en la lista telefonica ");
			            listaModificada = true;
			            break;
		        	case 4:
			            flujoS.print("telefono: ");
			            telefono = Leer.datoLong();
			            eliminado = listatfnos.eliminar(telefono);
			            if (eliminado) {
			            	flujoS.println("registro eliminado");
			            	listaModificada = true;
			            	break;
			            } 
			            if (listatfnos.longitud() != 0) {
							flujoS.println
							("telefono no encontrado");
							break;
			            } 
			            flujoS.println("lista vacia");
			            break;
		        	case 5:
			            listatfnos.mostrarListaTfnos();
			            break;
		        	case 6:
			            if (listaModificada) {
			            	ObjectOutputStream ous = 
			            			new ObjectOutputStream
			            			(new FileOutputStream
			            				("listatfnos7.dat"));
			            	ous.writeObject(listatfnos);
			            	ous.close();
			            } 
			            listatfnos = null;
			            break;
		        } 
	    	} while (opcion != 6);
	    } catch (IOException e) {
	    	System.out.println("Error: " + e.getMessage());
	    } catch (ClassNotFoundException e) {
	    	System.out.println("Error: " + e.getMessage());
	    } 
	}
	
}
