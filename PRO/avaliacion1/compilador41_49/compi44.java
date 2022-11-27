package compilador41_49;

import java.io.IOException;

public class compi44 {

	public static void main(String[] args) throws IOException{
		char letra;
		int cont = 0;
		
		System.out.print(">");
		letra = (char) System.in.read();
		while(letra != '\n') {
			System.out.print(letra);
			cont = cont + 1;
			letra = (char) System.in.read();
		}
		System.out.println("\nTeclas pulsadas: " + cont);
	}
}
