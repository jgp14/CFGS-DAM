package practicas.practi02;

public class CJuzgado {
	
	private CProceso[] juzgado = new CProceso[5];
	private int nElementos = 0;
	
	public void llenar() {
		juzgado[0] = new CProceso("P101", "Empresa ARA", 1230.5F);
		juzgado[1] = new CProceso("P102", "Punto limpio", 2245.75F);
		juzgado[2] = new CProceso("P103", "Divorcio Pedro", 538.25F);
		juzgado[3] = new CProceso("P104", "Concesionario", 3429.5F);
		juzgado[4] = new CProceso("P105", "Alquiler piso", 826.25F);
		nElementos = 5;
	}
	
	public void vaciar() {
		nElementos = 0;
	}
	
	public void insertarProceso() {
		System.out.print("Identificador: ");
		String identificador = Leer.datoString();
		System.out.print("Titulo: ");
		String titulo = Leer.datoString();
		System.out.print("Arancel: ");
		float arancel = Leer.datoFloat();
		juzgado[nElementos] = 
				new CProceso(identificador, titulo, arancel);
		nElementos++;
		System.out.println("Proceso INSERTADO");
	}
	
	private int damePosicion(String ide) {
		for(int i = 0; i < nElementos; i++)
			if (ide.equals(juzgado[i].getIdentificador()))
				return i; 
		return -1;
	}
	
	private void modifica(int i) {
		mostrarCabecera();
		juzgado[i].mostrar();
		System.out.print("NUEVO identificador: ");
		juzgado[i].setIdentificador(Leer.datoString());
		System.out.print("NUEVO titulo: ");
		juzgado[i].setTitulo(Leer.datoString());
		System.out.print("NUEVO arancel: ");
		juzgado[i].setArancel(Leer.datoFloat());
	}
	
	public void modificarProceso(String ide) {
		int posicion = damePosicion(ide);
		if(posicion == -1)
			System.out.println("Proceso no ENCONTRADO");
		else {
			modifica(posicion);
			System.out.println("Proceso MODIFICADO");
		}
	}
	
	private void elimina(int i) {
		for(;i < nElementos-1; i++)
			juzgado[i] = juzgado[i+1];
		nElementos--;
	}
	
	public void eliminarProceso(String ide) {
		int posicion = damePosicion(ide);
		if (posicion == -1)
			System.out.println("Proceso no ENCONTRADO");
		else {
			elimina(posicion);
			System.out.println("Proceso ELIMINADO");
		}
	}
	
	public void mostrar() {
		if(nElementos == 0)
			System.out.println("Juzgado VACIO");
		else {
			mostrarCabecera();
			for(int i = 0; i < nElementos; i++)
				juzgado[i].mostrar();
		}
	}
	
    private void mostrarCabecera() {
        System.out.println("IDENTIFICADOR"+"\tTITULO"+"  \tARANCEL");
        System.out.println("============="+"\t======"+"  \t=======");
    }

    private void menu() {
        System.out.println("\n  M E N U - Practica 1");
        System.out.println("  ======================");
        System.out.println("1.- LLENAR Juzgado");
        System.out.println("2.- VACIAR Juzgado");
        System.out.println("3.- MOSTRAR Juzgado");
        System.out.println("4.- INSERTAR Proceso");
        System.out.println("5.- MODIFICAR Proceso");
        System.out.println("6.- ELIMINAR Proceso");
        System.out.println("7.- FINAL");
        System.out.print("Pulsa opcion: ");
    }

    public int dameOpcion() {
        menu();
        int opcion = Leer.datoInt();
        System.out.println();
        return opcion;
    }
	
}
