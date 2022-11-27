package examePractico; //Jaime Garcia Parada

import java.io.IOException;

public class pregunta3 {

	public static void main(String[] args) throws IOException {
		CRecursivo recursivo = new CRecursivo();
		System.out.print("Dame cadena: ");
		recursivo.recolleCadena();
		recursivo.amosa467DuplicadosReves(0);
	}
}
