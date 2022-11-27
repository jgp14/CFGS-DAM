package compilador09_16;

import java.util.Scanner;

public class compi10 {

	public static void main(String[] args) {
		
		float compra, venta;		
		Scanner teclado = new java.util.Scanner(System.in);
		
		System.out.print("Dame precio de compra: ");		
		compra = teclado.nextInt();
		
		venta = compra * (float)1.35;

		System.out.println("Precio de venta------> " + venta);
		System.out.println("PVP -----------------> " + venta * (float)1.18);		
		teclado.close();
	}
}
