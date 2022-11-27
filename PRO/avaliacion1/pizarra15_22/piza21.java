package pizarra15_22;

import java.io.IOException;

//import java.util.Scanner;

public class piza21 {

	public static void main(String[] args) throws IOException {
		/*Scanner teclado = new Scanner(System.in);
		
		System.out.print("Introduce unha letra: ");
		
		char letra = teclado.next().charAt(0);
				
		boolean b, b1, b2, b3;
		
		b = Character.isAlphabetic(letra);
		b1 = Character.isUpperCase(letra);
		b2 = Character.isLowerCase(letra);
		b3 = Character.isDigit(letra);
		
		if(b || b3) {
			if(b1) {
				System.out.println("MAIUSCULA");
			}
			if(b2) {
				System.out.println("MINUSCULA");
			}
			if(b3) {
				System.out.println("DIGITO");
			}
		}
		else {
			System.out.println("Tecla NON PERMITIDA");
		}
		
		teclado.close();*/

		char letra;
		
		System.out.print("Pulse unha tecla: ");
		letra = (char) System.in.read();
		
		if(letra >= 'A' && letra <= 'Z' || letra == 'Ñ') {
			System.out.println("MAIUSCULA");
		} 
		else if(letra >= 'a' && letra <= 'z' || letra == 'ñ'){
			System.out.println("MINUSCULA" );
		}
		else if(letra >= '0' && letra <= '9') {
			System.out.println("DIGITO");
		}
		else {
			System.out.println("Tecla NON PERMITIDA");
		}
	}
}
