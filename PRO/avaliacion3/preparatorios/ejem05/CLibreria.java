package preparatorios.ejem05;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class CLibreria {
	private RandomAccessFile fes;
	private int nregs;
	private int tamanhoReg;
	private File fichero;

	public CLibreria(File fich) throws IOException {
		fichero = fich;
		if (fichero.exists() && !fichero.isFile())
			throw new IOException(fichero.getName() + " es un DIRECTORIO");
		fes = new RandomAccessFile(fichero, "rw");
		tamanhoReg = 100;
		nregs = (int) Math.ceil((double) fes.length() / (double) tamanhoReg);

	}

	public void cerrar() throws IOException {
		fes.close();
	}

	public void insertar(int i, CLibro libro) throws IOException {
		fes.seek(i * tamanhoReg);
		fes.writeInt(libro.getCodigo());
		fes.writeUTF(libro.getTitulo());
		fes.writeFloat(libro.getPrecio());
	}

	public void llenar() throws IOException {
        vaciar();
		insertar(0, new CLibro(100, "La Celestina", 35.95F));
		insertar(1, new CLibro(200, "El Quijote", 45.75F));
		insertar(2, new CLibro(300, "La Biblia", 38.25F));
		insertar(3, new CLibro(400, "El Barroco", 29.85F));
		insertar(4, new CLibro(500, "La Colmena", 26.15F));
		nregs = 5;
	}

	public void vaciar() throws IOException {
		fes.close();
		if (!fichero.delete())
			throw new IOException("No se borró el fichero: " + fichero.getName());
		else {
			fes = new RandomAccessFile(fichero, "rw");
			nregs = 0;
		}
	}

	private CLibro dameDatosLibro() {
		int codigo;
		String titulo;
		float precio;

		System.out.print("Dame codigo: ");
		codigo = Leer.datoInt();
		System.out.print("Dame título: ");
		titulo = Leer.datoString();
		System.out.print("Dame precio: ");
		precio = Leer.datoFloat();
		return new CLibro(codigo, titulo, precio);
	}
	
	private CLibro dameLibro(int pos) throws IOException {
		int codigo;
		String titulo;
		float precio;

		if (pos >= 0 && pos < nregs) {
			fes.seek(pos * tamanhoReg);
			codigo = fes.readInt();
			titulo = fes.readUTF();
			precio = fes.readFloat();
			return new CLibro(codigo, titulo, precio);
		} else
			return null;
	}

	private int damePosicion(int cod) throws IOException {
		int i;
		int codigo;

		i = 0;
		while (i < nregs) {
			fes.seek(i * tamanhoReg);
			codigo = fes.readInt();
			if (codigo == cod) 
				return i;
			else
				i++;
		}
		return -1;

	}

	public void mostrar() throws IOException {
		if (nregs == 0) {
			System.out.println("Libreria VACIA");
			return;
		}
		CLibro libro;
		int pos;

		mostrarCabecera();
		for (pos = 0; pos < nregs; pos++) {
			libro = dameLibro(pos);
			libro.mostrar();
		}
	}

	private void mostrarCabecera() {
		System.out.println("CODIGO" + "\tTITULO  " + "\tPRECIO");
		System.out.println("======" + "\t======  " + "\t======");
	}

	public void mostrarLibro(int cod) throws IOException {
        CLibro libro;
		int pos;

		pos = damePosicion(cod);
		libro = dameLibro(pos);
		if (libro == null)
			System.out.println("libro no ENCONTRADO");
		else {
			mostrarCabecera();
			libro.mostrar();
		}
	}


	public void insertarLibro() throws IOException {
	/*	if (nregs == 0) {
			System.out.println("Libreria VACIA");
			return;
		}*/
		CLibro libro;

		libro = dameDatosLibro();
		insertar(nregs, libro);
		nregs++;
	}

	public void modificarLibro(int cod) throws IOException {
		CLibro libro;
        int posicion;

        posicion = damePosicion(cod);
		libro = dameLibro(posicion);
		if (libro == null)
			System.out.println("libro no ENCONTRADO");
		else {
			mostrarCabecera();
			libro.mostrar();

			libro = dameDatosLibro();
			insertar(posicion, libro);
			System.out.println("libro MODIFICADO");
		}
	}

	public void eliminarLibro(int cod) throws IOException {
        CLibro libro;
		int posicion;

		posicion = damePosicion(cod);
		libro = dameLibro(posicion);
		if (libro == null)
			System.out.println("libro no ENCONTRADO");
		else {
			libro.setPrecio(0L);
			insertar(posicion, libro);
			System.out.println("libro ELIMINADO");
		}
	}

	public void actualizar() throws IOException { 
//   Pendiente de implementar
		if(nregs == 0) {
			System.out.println("Libreria VACIA");
			return;
		}
		int i, pos;
		CLibro libro;
		File ficheroTemp = new File("ejem05.tmp");
		CLibreria libreriaTemporal = new CLibreria(ficheroTemp);
		
		for(pos = 0, i = 0; pos < nregs; pos++) {
			libro = dameLibro(pos);
			if(libro.getPrecio() != 0L) {
				libreriaTemporal.insertar(i, libro);
				i++;
			}
		}
		
		libreriaTemporal.cerrar();
		cerrar();
		
		fichero.delete();
		if(!ficheroTemp.renameTo(fichero))
			throw new IOException("NO se renombro el fichero: " + ficheroTemp);
		fes = new RandomAccessFile(fichero, "rw");
		nregs = i;
	}

	private void menu() {
		System.out.println("\n  M E N U - 5");
		System.out.println("  ===========");
		System.out.println("1.- LLENAR libreria");
		System.out.println("2.- VACIAR libreria");
		System.out.println("3.- MOSTRAR libreria");
		System.out.println("4.- MOSTRAR libro");
		System.out.println("5.- INSERTAR libro");
		System.out.println("6.- MODIFICAR libro");
		System.out.println("7.- ELIMINAR libro");
		System.out.println("8.- ACTUALIZAR libreria");
		System.out.println("9.- FINAL");
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