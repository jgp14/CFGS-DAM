package pizarra23_29;

import java.util.Scanner;

public class piza26 {

	public static void main(String[] args) {
		/*int i = 1, j = 1;	
		while (i <= 10){
			System.out.println();
			System.out.println("Taboa do " + i);
			System.out.println("==========");
			j = 0;
			while(j <= 10) {
				System.out.println(i + " X " + j + " = " + i * j);
				j = j + 1;
			}	
			i = i + 1;
		}*/
		
		int i, j; //solucion26
		Scanner teclado = new Scanner(System.in);
		
		i = 1;
		while (i <= 10) {
			System.out.println("Tabla de multiplicar del " + i);
			j = 1;
			while (j <= 10) {
				System.out.println(i + " X " + j + " = " + i * j);
				j = j + 1;
			}
			i = i + 1; 
			teclado.nextLine();
		}
		teclado.close();
	}
}
