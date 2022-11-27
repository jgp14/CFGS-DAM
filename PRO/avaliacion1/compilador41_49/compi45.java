package compilador41_49;

import java.io.IOException;

public class compi45 {

	public static void main(String[] args) throws IOException{

		char letra;
		
		System.out.print(">");
		letra = (char) System.in.read();
		int cod = (int) letra + 3;
		letra = (char) cod;
		while(letra != '\r') {
			System.out.print(letra);
			letra = (char) System.in.read();
			cod = (int) letra + 3;
			letra = (char) cod;
		}
		
	}
}
