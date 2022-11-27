package misClases.teoria;

import misClases.utilidades.DatosPersonales;

public class CMatrizCadenas {
	private char[][] matriz;
	private int nElementos;
	
	public void crea() {
		do {
			System.out.print("Numero de personas: ");
			nElementos = Leer.datoInt();
		} while(nElementos < 0);
		matriz = new char[nElementos][];
	}
	
	public void llena() {
		for(int i = 0; i < nElementos; i++)
			matriz[i] = dameDato();
	}
	
	public void amosa() {
		System.out.println("\nMatriz de Personas");
		for(int i = 0; i < nElementos; i++) {
			int letras = matriz.length;
			System.out.print(i+"-> ");
			System.out.print(matriz[i]);
			System.out.println(" (" + letras + ")");
		}
	}
	
	public int dameIndice() {
		int indice;
		do {
			System.out.print("Dame indice: ");
			indice = Leer.datoInt();
		} while(indice < 0 || indice > nElementos - 1);
		return indice;
	}
	
	public void anulaElemneto(int indice) {
		for(int i = indice; i < nElementos - 1; i++)
			matriz[i] = matriz[i + 1];
		nElementos--;
	}
	
	public char[] dameDato() {
		String dato = DatosPersonales.dameNombre();
		dato = dato + " " + DatosPersonales.dameApellido();
		dato = dato + " " + DatosPersonales.dameApellido();
		return dato.toCharArray();
	}
}
