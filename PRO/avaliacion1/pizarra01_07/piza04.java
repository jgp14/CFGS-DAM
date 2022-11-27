package pizarra01_07;

import java.util.Scanner;

public class piza04 {
	
	public static void main(String[] args) {

		int i, num;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Introduce un número mayor que 20: ");
		
		i = 20; 
		num = teclado.nextInt();
		
		while (i >= num) {
			System.out.print(i);
			i = i - 1;
		}
		
		teclado.close();
	}
}
