package pizarra01_07;

import java.util.Scanner;

public class piza07 {

	public static void main(String[] args) {
		
		Scanner teclado = new java.util.Scanner(System.in);
		System.out.print("Dame un numero: ");
		int i = 1, num = teclado.nextInt();
		teclado.close();
		
		System.out.println("Taboa do " + num);
		System.out.println("==========");

		
		while(i <= 10) {
			System.out.println(num + " X " + i + " = " + num * i);
			i = i + 1;
		}		
	}
}
