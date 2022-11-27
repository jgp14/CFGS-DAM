package pizarra08_14;

import java.util.Scanner;

public class piza11 {

	public static void main(String[] args) {
		
		Scanner teclado = new java.util.Scanner(System.in);
		
		System.out.print("Dame un numero menor que 20: ");
		
		int i, num = teclado.nextInt();
		teclado.close();
		
		for(i = 20 ; i >= num; i = i - 1) {
			System.out.println(i);
		}
	}
}
