package preparatorios;

import java.io.IOException;

import misClases.avaliacion2.CRecursivo;

public class prepara03 {

	public static void main(String[] args) throws IOException {
		CRecursivo recursivo = new CRecursivo();
		System.out.print("Dame cadena: ");
		recursivo.recolleCadena();
		recursivo.amosaRevesCadena(0);
	}
}
