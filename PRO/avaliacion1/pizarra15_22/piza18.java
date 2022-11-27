package pizarra15_22;

//import java.util.Scanner;
import java.io.IOException;

public class piza18 {

	public static void main(String[] args) throws IOException {
		
		/*Scanner teclado = new Scanner(System.in);
		
		System.out.print("Introduce unha letra: ");
		
		char letra = teclado.next().charAt(0);
				
		boolean b;
		
		b = Character.isLowerCase(letra);
		
		if(b) {
			System.out.println("Pulsouse esta tecla: " + letra);
			System.out.println("E MINUSCULA");
		}
		else {
			System.out.println("Tecla NON PERMITIDA: " + letra);
		}
		
		teclado.close();*/
		
		char letra;
		
		System.out.print("Pulse unha tecla Minuscula: ");
		letra = (char) System.in.read();
		
		if(letra >= 'a' && letra <= 'z') {
			System.out.println("Pulsouse esta tecla: " + letra);
			System.out.println("E MINUSCULA");
		} 
		else {
			System.out.println("Tecla NON PERMITIDA: " + letra);
		}
	}
}
