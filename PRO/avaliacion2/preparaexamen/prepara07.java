package preparaexamen;

import java.io.IOException;

import misClases.avaliacion2.CCadena;

public class prepara07 {

	public static void main(String[] args) throws IOException {
		CCadena cadena = new CCadena();
		System.out.print("Dame cadena: ");
		cadena.recolleCadena();
		cadena.elimina0246EnCadena();
		cadena.amosaCadena();
	}
}
