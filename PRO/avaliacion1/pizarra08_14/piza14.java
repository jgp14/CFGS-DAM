package pizarra08_14;

import java.util.Scanner;

public class piza14 {

	public static void main(String[] args) {
		
		Scanner teclado = new java.util.Scanner(System.in);
		System.out.print("Dame un numero: ");
		int i = 1, num = teclado.nextInt();
		teclado.close();
		
		System.out.println("Taboa do " + num);
		System.out.println("==========");

		
		for(; i <= 10 ; i = i + 1) {
			System.out.println(num + " X " + i + " = " + num * i);
		}		
		
	}
}
