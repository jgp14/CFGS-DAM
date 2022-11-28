package preparatorios.ejem07;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CLibreria {
	private CLibro[] libreria;
	private int total;
	private DataOutputStream flujoSalida;
	private DataInputStream flujoEntrada;
	private File fichero;

	public CLibreria(File fich) {
		libreria = new CLibro[10];
		total = 0;
		fichero = fich;
	}

	public void llenar() {
		libreria[0] = new CLibro(100, "La Celestina", 35.95F);
		libreria[1] = new CLibro(200, "El Quijote", 45.75F);
		libreria[2] = new CLibro(300, "La Biblia", 38.25F);
		libreria[3] = new CLibro(400, "El Barroco", 29.85F);
		libreria[4] = new CLibro(500, "La Colmena", 26.15F);
		total = 5;
	}

	public void vaciar() {
		total = 0;
	}

	public void salvar() {
		if (total == 0) {
			System.out.println("libreria VACIA");
		} else {
			flujoSalida = null;
			try {
				flujoSalida = new DataOutputStream
						(new FileOutputStream(fichero));
				for (int i = 0; i < total; i++) {
					flujoSalida.writeInt(libreria[i].getCodigo());
					flujoSalida.writeUTF(libreria[i].getTitulo());
					flujoSalida.writeFloat(libreria[i].getPrecio());
				}
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
		int codigo;
		String titulo;
		float precio;
		flujoEntrada = null;
		int i = 0;
		try {
			flujoEntrada = new DataInputStream
					(new FileInputStream(fichero));
			while (true) {
				codigo = flujoEntrada.readInt();
				titulo = flujoEntrada.readUTF();
		        precio = flujoEntrada.readFloat();
		        libreria[i] = (new CLibro(codigo, titulo, precio));
		        i++;
			} 
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

	private CLibro dameLibro(int cod) {
		int i;

		i = 0;
		while (i < total)
			if (libreria[i].getCodigo() == cod)
				return libreria[i];
			else
				i++;
		return null;

	}

	private int dameIndice(int cod) {
		int i;

		i = 0;
		while (i < total)
			if (libreria[i].getCodigo() == cod)
				return i;
			else
				i++;
		return -1;

	}

	private void elimina(int i) {
		while (i < total - 1) {
			libreria[i] = libreria[i + 1];
			i++;
		} 
		total--;
	}

	public void eliminarLibro(int codigo) {
		int indice;
		
		indice = dameIndice(codigo);
	    if (indice == -1) {
	    	System.out.println("libro no ENCONTRADO");
	    } else {
	    	elimina(indice);
	    	System.out.println("libro ELIMINADO");
	    } 
	}

	public void insertarLibro() {
		int codigo;
		String titulo;
		float precio;
		
		System.out.print("Dame codigo: ");
	    codigo = Leer.datoInt();
	    System.out.print("Dame titulo: ");
	    titulo = Leer.datoString();
	    System.out.print("Dame precio: ");
	    precio = Leer.datoFloat();
	    libreria[total] = new CLibro(codigo, titulo, precio);
	    total++;
	  }

	public void modificarLibro(int codigo) {
		CLibro libro;
		
		libro = dameLibro(codigo);
		if (libro == null) {
			System.out.println("libro no ENCONTRADO");
	    } else {
	    	System.out.println("Precio ACTUAL: " + libro.getPrecio());
	    	System.out.print("Dame precio NUEVO: ");
	    	float precio = Leer.datoFloat();
	    	libro.setPrecio(precio);
	    	System.out.println("libro MODIFICADO");
	    } 
	}

	public void mostrarLibro(int cod) {
		CLibro libro;

		libro = dameLibro(cod);
		if (libro == null)
			System.out.println("libro no ENCONTRADO");
		else {
			mostrarCabecera();
			libro.mostrar();
		}
	}

	public void mostrar() {
		int i;

		if (total == 0)
			System.out.println("libreria VACIA");
		else {
			mostrarCabecera();
			i = 0;
			while (i < total) {
				libreria[i].mostrar();
				i++;
			}
		}
	}

	private void mostrarCabecera() {
		System.out.println("CODIGO" + "\tTITULO  " + "\tPRECIO");
		System.out.println("======" + "\t======  " + "\t======");
	}

	private void menu() {
		System.out.println("\n  M E N U - 4");
		System.out.println("  ===========");
		System.out.println("1.- LLENAR libreria");
		System.out.println("2.- VACIAR libreria");
		System.out.println("3.- MOSTRAR libreria");
		System.out.println("4.- MOSTRAR libro");
		System.out.println("5.- INSERTAR libro");
		System.out.println("6.- MODIFICAR libro");
		System.out.println("7.- ELIMINAR libro");
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