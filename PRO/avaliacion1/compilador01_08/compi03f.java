package compilador01_08;

import java.util.Scanner;

public class compi03f {

	public static void main(String[] args) {
		
		float base, altura, area;
		
		Scanner teclado = new java.util.Scanner(System.in);
		
		System.out.print("Dame a base: ");
		
		base = teclado.nextFloat();
		
		System.out.print("Dame a altura: ");
		
		altura = teclado.nextFloat();
		
		area = (base * altura) / (float)2;
		
		System.out.print("Area do rectangulo: " + area);
		
		teclado.close();

	}
	
}
