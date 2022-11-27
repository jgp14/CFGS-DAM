package teoria.capitulo07;

import misClases.teoria.CMatrizStringBuffer;

public class CApMatrizStringBuffer {

	public static void main(String[] args) {
		CMatrizStringBuffer matriz = new CMatrizStringBuffer();
		matriz.crea();
		matriz.llena();
		matriz.amosa();
		System.out.println("\nModificamos Elemento");
		int indice = matriz.dameIndice();
		matriz.modificaElemento(indice);
		matriz.amosa();
	}
}
