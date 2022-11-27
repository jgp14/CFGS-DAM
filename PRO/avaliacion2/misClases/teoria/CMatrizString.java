package misClases.teoria;

import misClases.utilidades.DatosPersonales;

public class CMatrizString {

	private String[] matriz; 
	
	public void crea() {
		int n;
		do {
			System.out.print("Numero de personas: ");
			n = Leer.datoInt();
		} while(n < 0);
		matriz = new String[n];
	}
	
	public void llena() {
		for(int i = 0; i < matriz.length; i++)
			matriz[i] = dameDato();
	}
	
	public void amosa() {
		System.out.println("\nMatriz de Personas");
		for(int i = 0; i < matriz.length; i++) {
			int letras = matriz[i].length();
			System.out.println(i + "-> " + matriz[i] 
					+ " (" + letras + ") ");
		}
	}
	private String dameDato() {
		String dato = DatosPersonales.dameNombre();
		dato = dato + " " + DatosPersonales.dameApellido();
		dato = dato + " " + DatosPersonales.dameApellido();
		return dato;
	}
}
