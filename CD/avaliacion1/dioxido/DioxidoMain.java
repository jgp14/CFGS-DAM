package dioxido;

import java.util.Scanner;

public class DioxidoMain {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Introduzca un nivel de contaminacion 1: ");
		int cont1 = teclado.nextInt();
		Contaminacion contaminacion1 = new Contaminacion(cont1);
		
		System.out.print("Introduzca un nivel de contaminacion 2: ");
		int cont2 = teclado.nextInt();
		Contaminacion contaminacion2 = new Contaminacion(cont2);
		
		System.out.println(contaminacion1.toString());
		System.out.println(contaminacion2.toString());

		teclado.close();
//		System.out.println(contaminacion1.verificarPenalizacion());
//		System.out.println(contaminacion2.verificarPenalizacion());

	}

}
