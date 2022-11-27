package examePractico; //Jaime Garcia Parada

import java.io.IOException;

public class pregunta2 {

	public static void main(String[] args) throws IOException {
		CCadena cadena = new CCadena();
		System.out.print("Dame cadena: ");
		cadena.recolleCadena();
		cadena.eliminaVocalesEnCadena();
		cadena.amosaCadena();
	}
}
