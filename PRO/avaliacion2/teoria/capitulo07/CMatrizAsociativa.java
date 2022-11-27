package teoria.capitulo07;

import java.io.IOException;

public class CMatrizAsociativa {

	public static void main(String[] args) {
		
		//Crear la matriz c con 'z' - 'a' +1 elementos
		//Java inicia los elementos de la matriz 
		int[] c = new int['z' - 'a' +1];
		char car; // subindice

		//Entrada de datos y calculo de la tabla de frecuencias
		System.out.println("Introducir un texto:");
		try {
			while((car = (char) System.in.read()) != '\r') {
				//Si el caracter leido esta entre la 'a' y la 'z'
				//Incrementar el contador correspondiente
				if (car >= 'a' && car <= 'z')
					c[car -'a']++;
			}
		}catch (IOException ignorada) {
			
		}
		
		
	}
}
