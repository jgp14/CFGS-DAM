package pizarra15_22;

import java.io.IOException;

//import java.util.Scanner;

public class piza20 {
	
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
			if(b1 || b2) {
				System.out.println("LETRA");
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
		
		if(letra >= 'A' && letra <= 'Z' 
				|| letra >= 'a' && letra <= 'z') {
			System.out.println("LETRA");
		} 
		else if(letra >= '0' && letra <= '9'){
			System.out.println("DIGITO");
		}
		else {
			System.out.println("Tecla NON PERMITIDA");
		}
	}
}
