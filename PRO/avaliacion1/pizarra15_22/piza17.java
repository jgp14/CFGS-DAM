package pizarra15_22;

import java.util.Scanner;

public class piza17 {

	public static void main(String[] args) {
		
		int num; 
		
		Scanner teclado = new java.util.Scanner(System.in);
		
		System.out.print("Introduce un numero: ");

		num = teclado.nextInt();
		
		if (num > 0 && num <= 30) {
			
			if(num <= 10) {
				System.out.println("Entre o 1 e o 10");
				System.out.println("Numero secreto: " + num * 4);
			}
			else {
			
				if(num <= 20) {
					System.out.println("Entre o 11 e o 20");
					System.out.println("Numero segredo: " + num * 3);
				}
				else {
					System.out.println("Entre o 21 e o 30");
					System.out.println("Numero segredo: " + num * 2);
				}				
			}			
		}
		else {
			System.out.println("NUMERO non permitido: " + num);
		}
		
		teclado.close();
		
	}
}
