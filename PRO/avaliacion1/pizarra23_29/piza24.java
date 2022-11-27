package pizarra23_29;

import java.util.Scanner;

public class piza24 {

	public static void main(String[] args) {
		/*int num, i = 0; 
		@SuppressWarnings("resource")
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduce un numero: ");
		num = teclado.nextInt(); 
		if(num >= 10 && num <= 50) {
			if(num % 3 == 0) {
				for(i = 0; num % 3 == 0; i++) {				
					System.out.print("Introduce un numero: ");
					num = teclado.nextInt(); 
				}
			}
			System.out.print("Has introducido " + i + " multiplos de 3 entre 10 e 50");
		}
		else System.out.print("Has introducido " + i + " multiplos de 3 entre 10 e 50");
		teclado.close();*/
		
		int numero, multiplo3; //solucion24
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Dame un numero entre 10 e 50: ");
		numero = teclado.nextInt();
		multiplo3 = 0;
		while (numero >= 10 && numero <= 50) {
			if (numero % 3 == 0)
				multiplo3 = multiplo3 + 1;
			System.out.print("Dame un numero entre 10 e 50: ");
			numero = teclado.nextInt();
		}
		System.out.print("Has introducido " + multiplo3 + 
				" multiplos de 3 ente 10 e 50");
		teclado.close();
	}
}
