package exameTerceira.datos;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import exameTerceira.utilidades.Leer;

public class CDepartamento {
	
	private RandomAccessFile fes;
	private int nregs;
	private int tamanhoReg;
	private File fichero;

	public CDepartamento(File fich) throws IOException {
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

	public void insertar(int i, CProfesor profesor) throws IOException {
		fes.seek(i * tamanhoReg);
		fes.writeUTF(profesor.getCodigo());
		fes.writeUTF(profesor.getNombre());
		fes.writeUTF(profesor.getAula());
		fes.writeFloat(profesor.getBaremo());
	}

	public void llenar() throws IOException {
        vaciar();
		insertar(0, new CProfesor("P01", "Marta Argueto", "RUA", 8.7F));
		insertar(1, new CProfesor("P02", "Lucas Garcia", "SAGRES", 6.2F));
		insertar(2, new CProfesor("P03", "Ignacio Arias", "VIONTA", 5.7F));
		insertar(3, new CProfesor("P04", "Ana Menendez", "TIXOSA", 7.4F));
		insertar(4, new CProfesor("P05", "Mercedes Novoa", "IROITE", 8.9F));
		nregs = 5;
	}

	public void vaciar() throws IOException {
		fes.close();
		if (!fichero.delete())
			throw new IOException("No se borró el fichero: " + fichero.getName());
		/*fes = new RandomAccessFile(fichero, "rw");
		nregs = 0;*/
		else {
			fes = new RandomAccessFile(fichero, "rw");
			nregs = 0;
		}
	}

	private CProfesor dameDatosProfesor() {
		String codigo;
		String nombre;
		String aula;
		float baremo;

		System.out.print("\nDame codigo: ");
		codigo = Leer.datoString();
		System.out.print("Dame nombre: ");
		nombre = Leer.datoString();
		System.out.print("Dame aula: ");
		aula = Leer.datoString();
		System.out.print("Dame baremo: ");
		baremo = Leer.datoFloat();
		return new CProfesor(codigo, nombre, aula, baremo);
	}
	
	private CProfesor dameProfesor(int pos) throws IOException {
		String codigo;
		String nombre;
		String aula;
		float baremo;


		if (pos >= 0 && pos < nregs) {
			fes.seek(pos * tamanhoReg);
			codigo = fes.readUTF();
			nombre = fes.readUTF();
			aula = fes.readUTF();
			baremo = fes.readFloat();
			return new CProfesor(codigo, nombre, aula, baremo);
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
			if (cod.equals(codigo))
				return i;
			i++;
		}
		return -1;

	}

	public void mostrar() throws IOException {
		if (nregs == 0) {
			System.out.println("Departamento sin profesores");
			return;
		}
		CProfesor profesor;
		int pos;

		mostrarCabecera();
		for (pos = 0; pos < nregs; pos++) {
			profesor = dameProfesor(pos);
			profesor.mostrar();
		}
	}

	private void mostrarCabecera() {
		System.out.println("CODIGO\tNOMBRE  \t\tAULA\t\tBAREMO");
		System.out.println("======\t======  \t\t====\t\t======");
	}

	public void mostrarProfesor(String cod) throws IOException {
        CProfesor profesor;
		int pos;

		pos = damePosicion(cod);
		profesor = dameProfesor(pos);
		if (profesor == null)
			System.out.println("profesor no ENCONTRADO");
		else {
			mostrarCabecera();
			profesor.mostrar();
		}
	}


	public void insertarProfesor() throws IOException {
		CProfesor profesor;

		profesor = dameDatosProfesor();
		insertar(nregs, profesor);
		nregs++;
	}

	public void modificarProfesor(String cod) throws IOException {
		CProfesor profesor;
        int posicion;

        posicion = damePosicion(cod);
        profesor = dameProfesor(posicion);
		if (profesor == null)
			System.out.println("profesor no ENCONTRADO");
		else {
			mostrarCabecera();
			profesor.mostrar();

			profesor = dameDatosProfesor();
			insertar(posicion, profesor);
			System.out.println("profesor MODIFICADO");
		}
	}

	public void eliminarProfesor(String cod) throws IOException {
        CProfesor profesor;
		int posicion;

		posicion = damePosicion(cod);
		profesor = dameProfesor(posicion);
		if (profesor == null)
			System.out.println("profesor no ENCONTRADO");
		else {
			profesor.setBaremo(-1);
			insertar(posicion, profesor);
			System.out.println("profesor ELIMINADO");
		}
	}

	public void actualizar() throws IOException { 
		if(nregs == 0) {
			System.out.println("Departamento VACIO");
			return;
		}
		int i, pos;
		CProfesor profesor;
		File ficheroTemp = new File("exame.tmp");
		CDepartamento departamentoTemporal = new CDepartamento(ficheroTemp);
		
		for(pos = 0, i = 0; pos < nregs; pos++) {
			profesor = dameProfesor(pos);
			if(profesor.getBaremo() != -1) {
				departamentoTemporal.insertar(i, profesor);
				i++;
			}
		}
		
		departamentoTemporal.cerrar();
		cerrar();
		
		fichero.delete();
		if(!ficheroTemp.renameTo(fichero))
			throw new IOException("NO se renombro el fichero: " + ficheroTemp);
		fes = new RandomAccessFile(fichero, "rw");
		nregs = i;
	}

	private void menu() {
		System.out.println("\n  M E N U - Exame Terceira");
		System.out.println("  ==========================");
		System.out.println("1.- LLENAR Departamento");
		System.out.println("2.- VACIAR Departamento");
		System.out.println("3.- MOSTRAR Departamento");
		System.out.println("4.- MOSTRAR Profesor");
		System.out.println("5.- INSERTAR Profesor");
		System.out.println("6.- MODIFICAR Profesor");
		System.out.println("7.- ELIMINAR Profesor");
		System.out.println("8.- ACTUALIZAR Departamento");
		System.out.println("9.- FINAL");
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