package compilador09_16;

import java.util.Scanner;

public class compi12 {

	public static void main(String[] args) {
		
		int valor1, valor2;		
		Scanner teclado = new java.util.Scanner(System.in);
		
		System.out.print("Ingrese primer valor: ");		
		valor1 = teclado.nextInt();
		
		System.out.print("Ingrese segundo valor: ");		
		valor2 = teclado.nextInt();
		
		if(valor1 > valor2) {
			System.out.println("La suma ---------------> " + (valor1 + valor2));
			System.out.println("La diferencia ---------> " + (valor1 - valor2));
		}else {
			System.out.println("El producto -----------> " + valor2 * valor1);
			System.out.println("La division (entera) --> " + valor2 / valor1);
		}
		teclado.close();
	}
}
