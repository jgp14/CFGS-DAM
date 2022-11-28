package preparatorios.prepara05;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class CFruteria {

	private RandomAccessFile fes;
	private int nregs;
	private int tamanhoReg;
	private File fichero;

	public CFruteria(File fich) throws IOException {
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

	public void insertar(int i, CFruta fruta) throws IOException {
		fes.seek(i * tamanhoReg);
		fes.writeUTF(fruta.getCodigo());
		fes.writeUTF(fruta.getNombre());
		fes.writeInt(fruta.getCantidad());
		fes.writeFloat(fruta.getPrecio());
	}

	public void llenar() throws IOException {
        vaciar();
		insertar(0, new CFruta("F01", "Aguacates", 52, 3.25F));
		insertar(1, new CFruta("F02", "Zanahorias", 34, 5.45F));
		insertar(2, new CFruta("F03", "Platanos", 57, 4.75F));
		insertar(3, new CFruta("F04", "Manzanas", 41, 2.85F));
		insertar(4, new CFruta("F05", "Mandarinas", 61, 3.55F));
		nregs = 5;
	}

	public void vaciar() throws IOException {
		fes.close();
		if (!fichero.delete())
			throw new IOException("No se borró el fichero: " + fichero.getName());
		fes = new RandomAccessFile(fichero, "rw");
		nregs = 0;
	}

	private CFruta dameDatosFruta() {
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
		return new CFruta(codigo, nombre, cantidad, precio);
	}
	
	private CFruta dameFruta(int pos) throws IOException {
		String codigo;
		String nombre;
		int cantidad;
		float precio;

		if (pos >= 0 && pos < nregs) {
			fes.seek(pos * tamanhoReg);
			codigo = fes.readUTF();
			nombre = fes.readUTF();
			cantidad = fes.readInt();
			precio = fes.readFloat();
			return new CFruta(codigo, nombre, cantidad, precio);
		} 
		return null;
	}

	private int damePosicion(String cod) throws IOException {
		int i;
		String codigo;

		i = 0;
		while (i < nregs) {
			fes.seek(i * tamanhoReg);
			codigo = fes.readUTF();
			if (cod.equals(codigo)) // Cambiar condicion
				return i;
			i++;
		}
		return -1;

	}

	public void mostrar() throws IOException {
		if (nregs == 0) {
			System.out.println("Fruteria VACIA");
			return;
		}
		CFruta fruta;
		int pos;

		mostrarCabecera();
		for (pos = 0; pos < nregs; pos++) {
			fruta = dameFruta(pos);
			fruta.mostrar();
		}
	}

	private void mostrarCabecera() {
		System.out.println("CODIGO\t\tNOMBRE  \tCANTIDAD\tPRECIO");
		System.out.println("======\t\t======  \t========\t======");
	}

	public void mostrarFruta(String cod) throws IOException {
        CFruta fruta;
		int pos;

		pos = damePosicion(cod);
		fruta = dameFruta(pos);
		if (fruta == null)
			System.out.println("fruta no ENCONTRADA");
		else {
			mostrarCabecera();
			fruta.mostrar();
		}
	}


	public void insertarFruta() throws IOException {
		CFruta fruta;

		fruta = dameDatosFruta();
		insertar(nregs, fruta);
		nregs++;
	}

	public void modificarFruta(String cod) throws IOException {
		CFruta fruta;
        int posicion;

        posicion = damePosicion(cod);
        fruta = dameFruta(posicion);
		if (fruta == null)
			System.out.println("fruta no ENCONTRADA");
		else {
			mostrarCabecera();
			fruta.mostrar();

			fruta = dameDatosFruta();
			insertar(posicion, fruta);
			System.out.println("fruta MODIFICADA");
		}
	}

	public void eliminarFruta(String cod) throws IOException {
        CFruta fruta;
		int posicion;

		posicion = damePosicion(cod);
		fruta = dameFruta(posicion);
		if (fruta == null)
			System.out.println("fruta no ENCONTRADA");
		else {
			fruta.setCantidad(-1);
			insertar(posicion, fruta);
			System.out.println("fruta ELIMINADA");
		}
	}

	public void actualizar() throws IOException { 
//   Pendiente de implementar
		if(nregs == 0) {
			System.out.println("Fruteria VACIA");
			return;
		}
		int i, pos;
		CFruta fruta;
		File ficheroTemp = new File("prepa05.tmp");
		CFruteria fruteriaTemporal = new CFruteria(ficheroTemp);
		
		for(pos = 0, i = 0; pos < nregs; pos++) {
			fruta = dameFruta(pos);
			if(fruta.getCantidad() != -1) {
				fruteriaTemporal.insertar(i, fruta);
				i++;
			}
		}
		
		fruteriaTemporal.cerrar();
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
		System.out.println("1.- LLENAR fruteria");
		System.out.println("2.- VACIAR fruteria");
		System.out.println("3.- MOSTRAR fruteria");
		System.out.println("4.- MOSTRAR fruta");
		System.out.println("5.- INSERTAR fruta");
		System.out.println("6.- MODIFICAR fruta");
		System.out.println("7.- ELIMINAR fruta");
		System.out.println("8.- ACTUALIZAR fruteria");
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
