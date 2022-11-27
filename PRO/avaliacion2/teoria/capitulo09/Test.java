package teoria.capitulo09;
// Aplicacion que utiliza la clase CFecha

import misClases.teoria.Leer;

public class Test {
	// Visualizar una fecha
	public static void visualizarFecha(CFecha fecha) {
		int[] f = new int[3];
		fecha.obtenerFecha(f);
		System.out.println(f[0] + "/" + f[1] + "/" + f[2]);
	}
	
	// Establecer una fecha.verificarla y visulizarla
	public static void main(String[] args) {
		CFecha fecha = new CFecha(); // objeto de tipo CFecha
		int dia, mes, anho;
		do {
			System.out.print("dia. ##  : "); dia = Leer.datoInt();
			System.out.print("dia. ##  : "); mes = Leer.datoInt();
			System.out.print("dia. ##  : "); anho = Leer.datoInt();
		} while(!fecha.fechaCorrecta());
		visualizarFecha(fecha);
	}
	
	/*public static void main(String[] args) {
		CFecha fecha = new CFecha(); 
		int dd = fecha.dia; // error: dia es un miembro privato
		fecha.mes = 1;
		boolean esBisiesto = fecha.bisiesto(); // correcto
	}*/
	
	/*public static void main(String[] args) {
		// La siguiente linea invoca al constructor de la clase CFecha
		CFecha fecha = new CFecha(1, 3, 2002); // objeto de tipo CFecha
		visualizarFecha(fecha);
	}*/
}
