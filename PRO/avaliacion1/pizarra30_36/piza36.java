package pizarra30_36;

import java.io.IOException;
import java.util.Scanner;

public class piza36 {

	public static void main(String[] args) throws IOException{
		/*Scanner teclado = new Scanner(System.in);
		char letra = 'a';
		while(letra == 'a' || letra == 'e' || letra == 'i' 
				|| letra == 'o' || letra == 'u') {
			System.out.print("Dame VOCAL minuscula: ");
			letra = teclado.next().charAt(0);
			if(letra == 'a' || letra == 'e' || letra == 'i' 
					|| letra == 'o' || letra == 'u')
				System.out.println("CORRECTO e VOCAL minuscula: " + letra);
			else
				System.out.println("INCORRECTO non e VOCAL minuscula: " + letra);
		}
		teclado.close();*/
		char letra;
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Dame VOCAL minuscula: ");
		letra = (char) System.in.read();
		teclado.nextLine();
		while (letra == 'a' || letra == 'e' || letra == 'i' 
				|| letra == 'o' || letra == 'u') {
			System.out.print("Dame VOCAL minuscula: ");
			 letra = (char) System.in.read();
			 teclado.nextLine();
		}
		System.out.print("INCORRECTO non e VOCAL minuscula: " + letra);
		teclado.close();
	}
}
