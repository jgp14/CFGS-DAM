package pizarra23_29;

import java.util.Scanner;

public class piza23 {

	public static void main(String[] args) {
		
		/*int num; 
		@SuppressWarnings("resource")
		Scanner teclado = new Scanner(System.in);
		System.out.print("Dame un numero entre 10 y 50: ");
		num = teclado.nextInt(); 
		if(num >= 10 && num <= 50) {
			for(; num >= 10 && num <= 50;) {				
				System.out.print("Dame un numero entre 10 y 50: ");
				num = teclado.nextInt(); 
			}
			System.out.print("O numero 55 non esta entre 10 e 50");
		}
		else System.out.print("O numero 55 non esta entre 10 e 50");
		teclado.close();*/
		
		int numero; //solucion23
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Dame un numero entre 10 e 50: ");
		numero = teclado.nextInt();
		while (numero >= 10 && numero <= 50) {
			System.out.print("Dame un numero entre 10 e 50: ");
			numero = teclado.nextInt();
		}
		System.out.print("O numero " + numero + " non esta entre 10 e 50");
		teclado.close();
	}
}
