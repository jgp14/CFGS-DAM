package preparatorios.prepara03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class CFruteria {

	private ArrayList<CFruta> fruteria;  
	private DataOutputStream flujoSalida;
	private DataInputStream flujoEntrada;  
	private File fichero;

	public CFruteria(File fich) {
		fruteria = new ArrayList<>();
	    fichero = fich;
	}

	public void llenar() {
		fruteria.removeAll(fruteria);
		fruteria.add(new CFruta("F01", "Aguacates", 52, 3.25F));
	 	fruteria.add(new CFruta("F02", "Zanahorias", 34, 5.45F));
		fruteria.add(new CFruta("F03", "Platanos", 57, 4.75F));
		fruteria.add(new CFruta("F04", "Manzanas", 47, 2.85F));
		fruteria.add(new CFruta("F05", "Mandarinas", 61, 3.55F));
	}

	public void vaciar() {
		fruteria.removeAll(fruteria);
	}

	public void salvar() {
		Iterator<CFruta> iterator = fruteria.iterator();
		CFruta fruta;
		flujoSalida = null;
		
		try {
			flujoSalida = new DataOutputStream
							(new FileOutputStream(fichero));
			while(iterator.hasNext()) {
				fruta = iterator.next();
				flujoSalida.writeUTF(fruta.getCodigo());
				flujoSalida.writeUTF(fruta.getNombre());
				flujoSalida.writeInt(fruta.getCantidad());
				flujoSalida.writeFloat(fruta.getPrecio());
			}
		} catch(IOException e) {
			System.out.println("problemas al SALVAR el fichero");
		} finally {
			if (flujoSalida != null)
		    	try {
		    		flujoSalida.close();
		    	} catch (IOException e) {
		    		System.out.println
		    		("problemas al CERRAR el flujo de salida");
		    	}
		}
	}
	
	public void restaurar() {
		String codigo;
		String nombre;
		int cantidad;
		float precio;
		flujoEntrada = null;
	    
		try {
			flujoEntrada = new DataInputStream
					(new FileInputStream(fichero));
			fruteria.removeAll(fruteria);
			while (true) {
		        codigo = flujoEntrada.readUTF();
		        nombre = flujoEntrada.readUTF();
		        cantidad = flujoEntrada.readInt();
		        precio = flujoEntrada.readFloat();
		        fruteria.add
		        (new CFruta(codigo, nombre, cantidad, precio));
			} 
		} catch (EOFException eOFException) {
	    
	    } catch (IOException e) {
	    	System.out.println
	    	("problemas al RESTAURAR el fichero");
	    } finally {
	    	if (this.flujoEntrada != null)
		        try {
		        	this.flujoEntrada.close();
		        } catch (IOException e) {
		        	System.out.println
		        	("problemas al CERRAR el flujo de entrada");
		        }  
	  	} 
	}
	
	private CFruta dameFruta(String cod) {
		Iterator<CFruta> iterator = fruteria.iterator();
		CFruta fruta;

		while (iterator.hasNext()) {
			fruta = iterator.next();
			if (fruta.getCodigo().equals(cod))
				return fruta;
		}
		return null;
	}

	public void eliminarFruta(String codigo) {
		CFruta fruta;

		fruta = dameFruta(codigo);
		if (fruta == null)
			System.out.println("fruta no ENCONTRADA");
		else {
			fruteria.remove(fruta);
			System.out.println("fruta ELIMINADA");
		}
	}
	
	public void insertarFruta() {
		String codigo;
		String nombre;
		int cantidad;
		float precio;
		
		System.out.print("Dame codigo: ");
		codigo = Leer.datoString();
		System.out.print("Dame nombre: ");
		nombre = Leer.datoString();
		System.out.print("Dame cantidad: ");
		cantidad = Leer.datoInt();
		System.out.print("Dame precio: ");
		precio = Leer.datoFloat();
		fruteria.add
		(new CFruta(codigo, nombre, cantidad, precio));
	}

	public void modificarFruta(String codigo) {
		CFruta fruta;
		float precio;
		
		fruta = dameFruta(codigo);
		if(fruta == null)
			System.out.println("fruta no ENCONTRADA");
		else {
			System.out.println
			("Precio ACTUAL: " + fruta.getPrecio());
			System.out.println("Dame precio NUEVO: ");
			precio = Leer.datoFloat();
			fruta.setPrecio(precio);
			System.out.println("fruta MODIFICADA");
		}
	}
	
	public void mostrarFruta(String cod) {
		CFruta fruta;

		fruta = dameFruta(cod);
		if (fruta == null)
			System.out.println("fruta no ENCONTRADA");
		else {
			mostrarCabecera();
			fruta.mostrar();
		}
	}

	public void mostrar() {
		Iterator<CFruta> iterator = fruteria.iterator();

		if (fruteria.isEmpty())
			System.out.println("fruteria VACIA");
		else {
			mostrarCabecera();
			while (iterator.hasNext())
				iterator.next().mostrar();
		}
	}

	private void mostrarCabecera() {
		System.out.println
		("CODIGO\t" + "\tNOMBRE  " + "\tCANTIDAD" + "\tPRECIO");
		System.out.println
		("======\t" + "\t======  " + "\t========" + "\t======");
	}

	private void menu() {
		System.out.println("\n  M E N U - 3");
	    System.out.println("  ===========");
	    System.out.println("1.- LLENAR fruteria");
	    System.out.println("2.- VACIAR fruteria");
	    System.out.println("3.- MOSTRAR fruteria");
	    System.out.println("4.- MOSTRAR fruta");
	    System.out.println("5.- INSERTAR fruta");
	    System.out.println("6.- MODIFICAR fruta");
	    System.out.println("7.- ELIMINAR fruta");
	    System.out.println("8.- SALVAR en fichero");
	    System.out.println("9.- RESTAURAR de fichero");
	    System.out.println("10.- FINAL");
	    System.out.print("Pulsa opcion: ");
	}

	public int dameOpcion() {
		int opcion;

		menu();
		opcion = Leer.datoInt();
		System.out.println();
		return opcion;
	}
}
