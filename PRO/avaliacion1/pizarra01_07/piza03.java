package pizarra01_07;

import java.util.Scanner;

public class piza03 {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		int i;
		
		System.out.println("Dame un número menor que 20: ");
		
		i = teclado.nextInt();
		
		while (i <= 20) {
			System.out.println(i);
			i = i +1;
		}
		
		teclado.close();
	}

}
