package compilador09_16;

import java.util.Scanner;

public class compi09 {

	public static void main(String[] args) {
		
		int numero1, numero2;		
		Scanner teclado = new java.util.Scanner(System.in);
		
		System.out.print("Dame numero 1: ");		
		numero1 = teclado.nextInt();
		
		System.out.print("Dame numero 2: ");		
		numero2 = teclado.nextInt();

		System.out.println("A suma e ------------>" + (numero1 + numero2));		
		System.out.println("A resta e ----------->" + (numero1 - numero2) + " (numero1 - numero2)");		
		System.out.println("A multiplicacion e -->" + (numero1 * numero2));
		System.out.println("A division entera e ->" + (numero1 / numero2) + " (numero1 / numero2)");		
		System.out.println("O modulo e ---------->" + (numero1 % numero2) + " (numero1 % numero2)");		
		System.out.println("A division real e --->" + (float)((float)numero1 / (float)numero2) + 
				" (numero1 / numero2)");
		System.out.println("A media real e ------>" + (float)((float)numero1 + (float)numero2)/2);		
		teclado.close();
	}
}
