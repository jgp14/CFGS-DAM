package compilador41_49;

import java.io.IOException;

public class compi47 {

	public static void main(String[] args) throws IOException {
		char letra;
		int espacios = 0, aes = 0;
		
		System.out.print(">");
		letra = (char) System.in.read();
		while(letra != '\n') {
			System.out.print(letra);
			if(letra == ' ')
				espacios++;
			else if(letra == 'a')
				aes++;
			letra = (char) System.in.read();
		}
		System.out.print("\nTotal espacios en blanco: " + espacios);
		System.out.print("\nTotal letra 'a': " + aes);
	}
}
