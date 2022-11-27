package preparatorios08_16;

import java.util.Scanner;

public class prepara15 {

	public static void main(String[] args) {
		int edad;
		Scanner teclado = new Scanner(System.in);
		System.out.print("Dame idade: ");
		edad = teclado.nextInt();
		while (edad >= 1 && edad <= 9 || edad >= 15 && edad <= 29 || 
				edad >= 65 && edad <= 110) {
			if(edad >= 1 && edad <= 9)
				System.out.println("-> ESTE CATIVO TEN " + edad + " ANOS");
			else if(edad >= 15 && edad <= 29)
				System.out.println("-> ESTE XOVEN TEN " + edad + " ANOS");
			else //(edad >= 65 && edad <= 110)
				System.out.println("-> ESTE ANCIAN TEN " + edad + " ANOS");
			System.out.print("Dame idade: ");
			edad = teclado.nextInt();
		}
		System.out.println("+++++> Idade NON permitida");
		teclado.close();
	}

}
