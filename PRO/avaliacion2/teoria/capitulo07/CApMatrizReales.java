package teoria.capitulo07;

import misClases.teoria.CMatrizReales;

public class CApMatrizReales {

	public static void main(String[] args) {
		CMatrizReales matriz = new CMatrizReales();
		matriz.crea();
		matriz.llena();
		System.out.println("\nMatriz de Reales");
		matriz.amosa();
		System.out.println("\nModificamos Elemento");
		int indice = matriz.dameIndice();
		matriz.modificaElemento(indice);
		System.out.println("\nMatriz de Reales");
		matriz.amosa();
	}
}
