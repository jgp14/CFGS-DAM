package preparatorios.prepara04;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CFruteria {
	private CFruta[] fruteria;
	private int total;
	private ObjectOutputStream flujoSalida;
	private ObjectInputStream flujoEntrada;
	private File fichero;

	public CFruteria(File fich) {
		fruteria = new CFruta[10];
		total = 0;
		fichero = fich;
	}

	public void llenar() {
		fruteria[0] = new CFruta("F01", "Aguacates", 52, 3.25F);
		fruteria[1] = new CFruta("F02", "Zanahorias", 34, 5.45F);
		fruteria[2] = new CFruta("F03", "Platanos", 57, 4.75F);
		fruteria[3] = new CFruta("F04", "Manzanas", 47, 2.85F);
		fruteria[4] = new CFruta("F05", "Mandarinas", 61, 3.55F);
		total = 5;
	}

	public void vaciar() {
		total = 0;
	}

	public void salvar() {
		if (total == 0) {
			System.out.println("Fruteria VACIA");
		} else {
			flujoSalida = null;
			try {
				flujoSalida = new ObjectOutputStream
						(new FileOutputStream(fichero));
				for (int i = 0; i < total; i++)
					flujoSalida.writeObject(fruteria[i]); 
			} catch (IOException e) {
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
	}

	public void restaurar() {
		flujoEntrada = null;
		int i = 0;
		try {
			flujoEntrada = new ObjectInputStream
					(new FileInputStream(fichero));
			while (true) {
				fruteria[i] = (CFruta)flujoEntrada.readObject();
		        i++;
			} 
	    } catch (ClassNotFoundException e) {
	    	System.out.println("problemas con la clase CFruta");
	    } catch (EOFException eOFException) {
	    
	    } catch (IOException e) {
	    	System.out.println("problemas al RESTAURAR el fichero");
	    } finally {
	    	if (flujoEntrada != null)
	    		try {
		          	flujoEntrada.close();
		        } catch (IOException e) {
		        	System.out.println
		        	("problemas al CERRAR el flujo de entrada");
		        }  
	    } 
	    total = i;
	}

	private CFruta dameFruta(String cod) {
		int i;

		i = 0;
		while (i < total)
			if (cod.equals(fruteria[i].getCodigo()))
				return fruteria[i];
			else
				i++;
		return null;

	}

	private int dameIndice(String cod) {
		int i;

		i = 0;
		while (i < total)
			if (cod.equals(fruteria[i].getCodigo()))
				return i;
			else
				i++;
		return -1;

	}

	private void elimina(int i) {
		while (i < total - 1) {
			fruteria[i] = fruteria[i + 1];
			i++;
		} 
		total--;
	}

	public void eliminarFruta(String codigo) {
		int indice;
		
		indice = dameIndice(codigo);
	    if (indice == -1) {
	    	System.out.println("fruta no ENCONTRADA");
	    } else {
	    	elimina(indice);
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
	    fruteria[total] = new CFruta(codigo, nombre, cantidad, precio);
	    total++;
	  }

	public void modificarFruta(String codigo) {
		CFruta fruta;
		
		fruta = dameFruta(codigo);
		if (fruta == null) {
			System.out.println("fruta no ENCONTRADA");
	    } else {
	    	System.out.println("Precio ACTUAL: " + fruta.getPrecio());
	    	System.out.print("Dame precio NUEVO: ");
	    	float precio = Leer.datoFloat();
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
		int i;

		if (total == 0)
			System.out.println("fruteria VACIA");
		else {
			mostrarCabecera();
			i = 0;
			while (i < total) {
				fruteria[i].mostrar();
				i++;
			}
		}
	}

	private void mostrarCabecera() {
		System.out.println
		("CODIGO\t" + "\tNOMBRE  " + "\tCANTIDAD" + "\tPRECIO");
		System.out.println
		("======\t" + "\t======  " + "\t========" + "\t======");
	}

	private void menu() {
		System.out.println("\n  M E N U - 4");
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
		System.out.print("Pulsa opción: ");
	}

	public int dameOpcion() {
		int opcion;

		menu();
		opcion = Leer.datoInt();
		System.out.println();
		return opcion;
	}
}