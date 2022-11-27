package pizarra23_29;

import java.util.Scanner;

public class piza27 {
	
	public static void main(String[] args) {
		/*int i, j;
		for(i = 1; i <= 10; i++){
			System.out.println();
			System.out.println("Taboa do " + i);
			System.out.println("==========");
			
			for(j = 1; j <= 10; j++) {
				System.out.println(i + " X " + j + " = " + i * j);
			}		
		}*/
		
		int i, j; //solucion27
		Scanner teclado = new Scanner(System.in);
		
		for(i = 1; i <= 10; i++){
			System.out.println("Tabla de multiplicar del " + i);			
			for(j = 1; j <= 10; j++) {
				System.out.println(i + " X " + j + " = " + i * j);
			}
			teclado.nextLine();
		}
		teclado.close();
	}
}
