package examePractico; //Jaime Garcia Parada

import java.io.IOException;

public class CCadena {

	private char[] cadena = new char[40];
	
	public void recolleCadena() throws IOException {
		char letra = (char) System.in.read(); 
		for(int i = 0; letra != '\r'; i++) {
			cadena[i] = letra;
			letra = (char) System.in.read(); 
		}			
	}
	
	public void amosaCadena() {
		for(int i = 0; cadena[i] != '\0'; i++)
			System.out.print(cadena[i]);
	}
	
	public void eliminaVocalesEnCadena() {
		int i, j; i = j = 0;
		for(; cadena[i] != '\0'; i++)
			if(cadena[i] != 'A' && cadena[i] != 'a'
			&& cadena[i] != 'E' && cadena[i] != 'e'
			&& cadena[i] != 'I' && cadena[i] != 'i'
			&& cadena[i] != 'O' && cadena[i] != 'o'
			&& cadena[i] != 'U' && cadena[i] != 'u') {
				cadena[j] = cadena[i];
				j++;
			}
		for(; cadena[j] != '\0'; j++)
			cadena[j] = '\0';
	}
} 
