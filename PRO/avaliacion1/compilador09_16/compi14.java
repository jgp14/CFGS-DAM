package compilador09_16;

import java.util.Scanner;

public class compi14 {

	public static void main(String[] args) {
		
		int numero;		
		Scanner teclado = new java.util.Scanner(System.in);
		
		System.out.print("Dame un entero entre 1 y 99: ");		
		numero = teclado.nextInt();
		
		if(numero < 10 && numero > (-10)) {
			System.out.println("Tiene UN digito");
		}else {
			System.out.println("Tiene DOS digitos");
		}
		teclado.close();
	}
}
