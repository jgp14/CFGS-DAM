package examePractico; //Jaime Garcia Parada

import java.io.IOException;

public class CRecursivo {

	private char[] cadena = new char[40];
	
	public void recolleCadena() throws IOException {
		char letra = (char) System.in.read(); 
		for(int i = 0; letra != '\r'; i++) {
			cadena[i] = letra;
			letra = (char) System.in.read(); 
		}			
	}
	
	public void amosa467DuplicadosReves(int n) {
		if(cadena[n] != '\0') {
			amosa467DuplicadosReves(n + 1);
			System.out.print(cadena[n]);
			if(cadena[n] == '4' || cadena[n] == '6' 
			|| cadena[n] == '7')
				System.out.print(cadena[n]);
		}
	}
}
