package compilador01_08;

import java.util.Scanner;

public class compi03 {

	public static void main(String[] args) {
		
		int base, altura; 
		float area;
		
		Scanner teclado = new java.util.Scanner(System.in);
		
		System.out.print("Dame a base: ");
		
		base = teclado.nextInt();
		
		System.out.print("Dame a altura: ");
		
		altura = teclado.nextInt();
		
		area = (float)(base * altura) / 2;
		
		System.out.print("Area do rectangulo: " + area);
		
		teclado.close();

	}
	
}
