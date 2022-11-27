package teoria.capitulo04;

import misClases.teoria.CComputador;

public class CApComputador {

	public static void main(String[] args) {
		CComputador Computador1 = new CComputador();
		CComputador Computador2 = new CComputador();
		
		CComputador.EstablecerGarantia((byte) 3);
		Computador1.EstablecerMarca("Ast");
		Computador1.EstablecerProcesador("Intel Pentium");
		Computador1.EstablecerPantalla("TFT");
		Computador1.EstablecerComputador("");
		Computador1.Estado();
		Computador1.ApagarComputador();
		Computador1.Estado();
		
		Computador2.EstablecerMarca("Ast");
		Computador2.EstablecerProcesador("Intel Pentium");
		Computador2.EstablecerPantalla("TFT");
		Computador2.EstablecerComputador("");
		Computador2.Estado();
		Computador2.ApagarComputador();
		Computador2.Estado();
		
	}

}
