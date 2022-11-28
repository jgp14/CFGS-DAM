package teoria.capitulo12.dos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import misClases.teoria.CListaTfnos8;
import misClases.teoria.CPersona;
import misClases.teoria.Leer;

class CApListaTfnosExer8 {
	static PrintStream flujoS = System.out;	  
	static CListaTfnos8 listatfnos;
	  
	public static void imprimirListaTfnos() throws IOException {
	    FileWriter flujoS = new FileWriter("LPT1");
	    String crlf = "\r\n";
	    String ff = "\f";
	    int nregs = listatfnos.longitud();
	    for (int n = 0; n < nregs; n++) {
	    	if (n % 60 == 0)
	    		flujoS.write(ff); 
	    	Integer i = new Integer(n);
	    	flujoS.write("Registro: " + i.toString() + crlf);
	    	flujoS.write
	    	(listatfnos.valorEn(n).obtenerNombre() + crlf);
	    	flujoS.write
	    	(listatfnos.valorEn(n).obtenerDireccion() + crlf);
	    	Long l = 
	    	new Long(listatfnos.valorEn(n).obtenerTelefono());
	    	flujoS.write(l.toString() + crlf);
	    	flujoS.write(crlf);
	    } 
	    flujoS.write(ff);
	    flujoS.close();
	}
	  
	public static boolean modificar(int nreg) 
			throws IOException {
		int op;
		CPersona obj = listatfnos.valorEn(nreg);
		if (obj == null)
			return false; 
		do {
			String nombre, direccion;
			long telefono;
			flujoS.print("\n\n");
			flujoS.println("Modificar el dato:");
			flujoS.println("1. Nombre");
			flujoS.println("2. Direccion");
			flujoS.println("3. Telefono");
			flujoS.println("4. Salir y salvar los cambios");
			flujoS.println("5. Salir sin salvar los cambios");
			flujoS.println();
			flujoS.print("   Opcion: ");
			op = Leer.datoInt();
			switch (op) {
			case 1:
	        	flujoS.print("nombre:    ");
	        	nombre = Leer.datoString();
	        	obj.asignarNombre(nombre);
	        	break;
	        case 2:
	        	flujoS.print("direccion: ");
	        	direccion = Leer.datoString();
	        	obj.asignarDireccion(direccion);
	        	break;
	        case 3:
	        	flujoS.print("telefono:  ");
	        	telefono = Leer.datoLong();
	        	obj.asignarTelefono(telefono);
	        	break;
			} 
		} while (op != 4 && op != 5);
	    if (op == 4) {
	    	listatfnos.ponerValorEn(nreg, obj);
	    	return true;
	    } 
	    return false;
	}
	  
	public static void actualizar(File fActual) throws IOException {
		File fTemp = new File("listatfnos8.tmp");
		CListaTfnos8 listaTemp = new CListaTfnos8(fTemp);
		int nregs = listatfnos.longitud();
		for (int reg_i = 0; reg_i < nregs; reg_i++) {
			CPersona obj = listatfnos.valorEn(reg_i);
			if (obj.obtenerTelefono() != 0L)
				listaTemp.anhadir(obj); 
		} 
		listatfnos.cerrar();
		listaTemp.cerrar();
		fActual.delete();
		if (!fTemp.renameTo(fActual))
			throw new IOException("no se renombro el fichero"); 
	}
	  
	public static int menu() {
		int op;
	    flujoS.print("\n\n");
	    flujoS.println("1. Buscar");
	    flujoS.println("2. Buscar siguiente");
	    flujoS.println("3. Modificar");
	    flujoS.println("4. Anhadir");
	    flujoS.println("5. Eliminar");
	    flujoS.println("6. Imprimir");
	    flujoS.println("7. Mostrar");
	    flujoS.println("8. Salir");
	    flujoS.println();
	    flujoS.print("   Opcion: ");
	    do {
	    	op = Leer.datoInt();
	    } while (op < 1 || op > 8);
	    return op;
	}
	  
	public static void main(String[] args) {
		int opcion = 0, pos = -1;
	    String cadenabuscar = null;
	    CPersona persona = new CPersona();
	    boolean eliminado = false;
	    boolean modificado = false;
	    try {
	    	File fichero = new File("listatfnos8.dat");
	    	listatfnos = new CListaTfnos8(fichero);
	    	do {
		        String nombre, direccion;
		        long telefono;
		        opcion = menu();
		        switch (opcion) {
		          	case 1:
			            flujoS.print
			            ("conjunto de caracteres a buscar ");
			            cadenabuscar = Leer.datoString();
			            pos = listatfnos.buscar(cadenabuscar, 0);
			            if (pos == -1) {
			            	if (listatfnos.longitud() != 0) {
			            		flujoS.println("bfallida");
			            		break;
			            	} 
			            	flujoS.println("lista vacia");
			            	break;
			            } 
			            flujoS.println
			            ("Numero de registro: " + pos);
			            flujoS.println
			            (listatfnos.valorEn(pos).obtenerNombre());
			            flujoS.println(listatfnos.valorEn(pos).
			            		obtenerDireccion());
			            flujoS.println(listatfnos.valorEn(pos).
			            		obtenerTelefono());
			            break;
		          	case 2:
			            pos = listatfnos.buscar
			            (cadenabuscar, pos + 1);
			            if (pos == -1) {
			            	if (listatfnos.longitud() != 0) {
				                flujoS.println
				                ("busqueda fallida");
				                break;
			            	} 
				            flujoS.println("lista vacia");
				            break;
			            } 
			            flujoS.println
			            ("Numero de registro: " + pos);
			            flujoS.println(listatfnos.valorEn(pos).
			            		obtenerNombre());
			            flujoS.println(listatfnos.valorEn(pos).
			            		obtenerDireccion());
			            flujoS.println(listatfnos.valorEn(pos).
			            		obtenerTelefono());
			            break;
		          	case 3:
			            flujoS.print
			            ("numero de registro entre 0 y " + 
			            (listatfnos.longitud() - 1) + ": ");
			            pos = Leer.datoInt();
			            modificado = modificar(pos);
			            if (modificado) {
			            	flujoS.println
			            	("modificacion realizada con exito");
			            	break;
			            } 
			            flujoS.println
			            ("error: no se modifico el registro");
			            break;
		          	case 4:
			            persona.asignarDatos();
			            persona.mostrar();
			            nombre = persona.obtenerNombre();
			            direccion = persona.obtenerDireccion();
			            telefono = persona.obtenerTelefono();
			            listatfnos.anhadir(new CPersona
			            		(nombre, direccion, telefono));
			            flujoS.print
			            ("Nuevo registro INCORPORADO en la "
			            		+ "lista telefonica ");
			            break;
		          	case 5:
			            flujoS.print("telefono: ");
			            telefono = Leer.datoLong();
			            eliminado = listatfnos.eliminar(telefono);
			            if (eliminado) {
			            	flujoS.println("registro eliminado");
			            	break;
			            } 
			            if (listatfnos.longitud() != 0) {
			            	flujoS.println
			            	("telefono no encontrado");
			            	break;
			            } 
			            flujoS.println("lista vacia");
			            break;
		          	case 6:
			            imprimirListaTfnos();
			            break;
		          	case 7:
			            listatfnos.mostrarListaTfnos();
			            break;
		          	case 8:
			            if (eliminado)
			            	actualizar(fichero); 
			            listatfnos = null;
			            break;
		        } 
	    	} while (opcion != 8);
	    } catch (IOException e) {
	    	flujoS.println("Error: " + e.getMessage());
	    } 
	}

}
