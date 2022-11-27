package pizarra15_22;

import java.util.Scanner;

public class piza15 {

	public static void main(String[] args) {
		
		int a, b;
		
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduce o numero A: ");
		a = teclado.nextInt();
		System.out.print("Introduce o numero B: ");
		b = teclado.nextInt();
		teclado.close();
		
		if (a != b) {
			
			if(a > b) {
				System.out.println("A e MAIOR que B");
			}
			else {
				System.out.println("A e MENOR que B");
			}
		}
		else {
			System.out.println("A e IGUAL que B");
		}
	}
}
