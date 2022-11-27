package pizarra08_14;

import java.util.Scanner;

public class piza13 {

	public static void main(String[] args) {

		Scanner teclado = new java.util.Scanner(System.in);
		
		System.out.print("Introduce un numero A: ");
		int a = teclado.nextInt();
		
		System.out.print("Introduce un numero B: ");
		int b = teclado.nextInt();
		teclado.close();
		
		for(; a >= b - 1; a = a - 1) {
			System.out.println(a);
		}
		
		System.out.println("El numero A ya es menor que el numero B");
	}
}
