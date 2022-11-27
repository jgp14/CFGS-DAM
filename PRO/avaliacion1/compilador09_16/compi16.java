package compilador09_16;

import java.util.Scanner;

public class compi16 {

	public static void main(String[] args) {
		
		int numero;		
		Scanner teclado = new java.util.Scanner(System.in);
		
		System.out.print("Ingrese un valor:");		
		numero = teclado.nextInt();
		
		if(numero > 0) {
			System.out.println("POSITIVO");
		}else {
		}
		if(numero == 0) {
			System.out.println("NULO");
		}else {
		}
		if(numero < 0) {
			System.out.println("NEGATIVO");
		}else {
		}
		teclado.close();
	}
}
