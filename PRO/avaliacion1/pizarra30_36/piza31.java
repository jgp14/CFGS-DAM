package pizarra30_36;

import java.util.Scanner;

public class piza31 {

	public static void main(String[] args) {
		int edad;
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Dame unha idade de un "
				+ "niño[1-7] ou de anciano[65-110]: ");
		edad = teclado.nextInt();

		while((edad < 1) || (edad > 7 && edad < 65) ||(edad > 110)) {
			System.out.print("Dame unha idade de un "
					+ "niño[1-7] ou de anciano[65-110]: ");
			edad = teclado.nextInt();
		}
		System.out.println("FINAL");
		teclado.close();
	}
}
