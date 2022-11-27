package pizarra08_14;

import java.util.Scanner;

public class piza10 {

	public static void main(String[] args) {
		
		Scanner teclado = new java.util.Scanner(System.in);
		
		System.out.print("Dame un numero menor que 20: ");
		
		int i = teclado.nextInt();
		teclado.close();
		
		for(; i <= 20; i = i + 1) {
			System.out.println(i);
		}
	}
}
