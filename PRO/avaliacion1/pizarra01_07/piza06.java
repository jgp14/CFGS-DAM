package pizarra01_07;

import java.util.Scanner;

public class piza06 {

	public static void main(String[] args) {
		
		int a, b;
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Introduce un n�mero a: ");		
		a = teclado.nextInt();
		
		System.out.print("Introduce un n�mero b: ");		
		b = teclado.nextInt();
		
		while(a <= b + 1) {
			System.out.print(b+", ");
			b = b - 1;
		}
		System.out.println("\nEl n�mero b ya es menor que el a");
		teclado.close();
	}
}
