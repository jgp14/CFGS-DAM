package pizarra15_22;

import java.util.Scanner;

public class piza22 {

	public static void main(String[] args) {
		
		int a, b;
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Introduce un numero: ");
		a = teclado.nextInt();
		
		System.out.print("Introduce otro numero: ");
		b = teclado.nextInt();
		
		if (a < 0 && b < 0) {
			System.out.println("Os dous son NEGATIVOS");
		}
		if (a * b < 0) {
			System.out.println("Un dos dous e NEGATIVO");
		}
		if (a >= 0 && b >= 0) {
			System.out.println("Os dous son POSITIVOS");
		}
		
		teclado.close();
	}
}
