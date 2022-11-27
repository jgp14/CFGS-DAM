package preparatorios08_16;

import java.util.Scanner;

public class prepara14 {

	public static void main(String[] args) {
		int edad;
		Scanner teclado = new Scanner(System.in);
		System.out.print("Dame idade: ");
		edad = teclado.nextInt();
		while (edad < 1 || edad > 9 && edad < 65 || edad > 110) {
			System.out.println("INCORRECTO, pulsaches esta idade: " + edad);
			System.out.print("Dame idade: ");
			edad = teclado.nextInt();
		}
		if(edad >= 1 && edad <= 9)
			System.out.println("+++++> ESTE CATIVO TEN " + edad + " ANOS");
		else
			System.out.println("+++++> ESTE ANCIAN TEN " + edad + " ANOS");
		teclado.close();
	}
}
