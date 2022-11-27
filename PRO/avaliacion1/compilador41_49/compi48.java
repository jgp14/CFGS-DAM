package compilador41_49;

import java.io.IOException;

public class compi48 {

	public static void main(String[] args) throws IOException {
		char letra;
		
		System.out.print(">");
		letra = (char) System.in.read();
		while(letra != '\r') {
			if(letra == ' ')
				System.out.print("_");
			else 
				System.out.print(letra);
			letra = (char) System.in.read();
		}
	}
}
