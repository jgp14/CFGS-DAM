package compilador41_49;

import java.io.IOException;

public class compi49 {
	
	public static void main(String[] args) throws IOException {
		char letra;
		
		System.out.print(">");
		letra = (char) System.in.read();
		System.out.print("((");
		while(letra != '\r') {
			if(letra == ' ')
				letra = '_';
			System.out.print(letra);
			letra = (char) System.in.read();
		}
		System.out.print("))");
	}
}
