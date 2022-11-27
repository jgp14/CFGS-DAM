package misClases.teoria;

import misClases.utilidades.DatosPersonales;

public class CMatrizStringBuffer {
	private StringBuffer[] matriz;
	
	public void crea() {
		int n;
		do {
			System.out.print("Numero de personas: ");
			n = Leer.datoInt();
		} while(n < 0);
		matriz = new StringBuffer[n];
	}
	
	public void llena() {
		for(int i = 0; i < matriz.length; i++)
			matriz[i] = dameDato();
	}
	
	public void amosa() {
		System.out.println("\nMatriz de Personas");
		for(int i = 0; i < matriz.length; i++) {
			int letras = matriz[i].length();
			System.out.println(i + "-> " + 
			matriz[i] + " (" + letras +") ");
		}
	}
	
	public int dameIndice() {
		int indice; 
		do {
			System.out.print("Dame indice: ");
			indice = Leer.datoInt();
		} while(indice < 0 || indice > matriz.length - 1);
		return indice;
	}
	
	public void modificaElemento(int indice) {
		matriz[indice] = dameDato();
	}
	
	private StringBuffer dameDato() {
		StringBuffer dato = 
		new StringBuffer(DatosPersonales.dameNombre());
		dato.append(" ").append(DatosPersonales.dameApellido());
		dato.append(" ").append(DatosPersonales.dameApellido());
		return dato; 
	}
}
