package pizarra23_29;

import java.util.Scanner;

public class piza25 {

	public static void main(String[] args) {
		/*int num, i = 0, j = 0; 
		@SuppressWarnings("resource")
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduce un numero: ");
		num = teclado.nextInt(); 
		if(num >= 1 && num <= 100) {	
			if(num >= 1 && num <= 50) {
				for(i = 0; num >= 1 && num <= 50; i++) {				
					System.out.print("Introduce un numero: ");
					num = teclado.nextInt();
				}
			}	
			if(num >= 51 && num <= 100){
				for(j = 0; num >= 51 && num <= 100; j++) {				
					System.out.print("Introduce un numero: ");
					num = teclado.nextInt(); 
				}
			}
		}
		System.out.println("Entre 1 e 50 houbo " + i + " numeros");
		System.out.println("Entre 51 e 100 houbo " + j + " numeros");
		teclado.close();*/
		
		int numero, entre1_50, entre51_100; //solucion25
		Scanner teclado = new Scanner (System.in);
		
		entre1_50 = 0;
		entre51_100 = 0;
		System.out.print("Dame un numero: ");
		numero = teclado.nextInt();
		while (numero >= 1 && numero <= 100) {
			if (numero >= 1 && numero <= 50)
				entre1_50 = entre1_50 + 1;
			else
				entre51_100 = entre51_100 + 1;
			System.out.print("Dame un numero: ");
			numero = teclado.nextInt();
		}
		System.out.println("Entre 1 e 50 houbo " + entre1_50 + " numeros");
		System.out.println("Entre 51 e 100 houbo " + entre51_100 + " numeros");
		teclado.close();
	}
}
