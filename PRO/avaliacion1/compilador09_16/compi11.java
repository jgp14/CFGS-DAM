package compilador09_16;

import java.util.Scanner;

public class compi11 {

	public static void main(String[] args) {
		
		float precio, siniva, rebaja;		
		Scanner teclado = new java.util.Scanner(System.in);
		
		System.out.print("Dame PVP: ");		
		precio = teclado.nextInt();
		
		siniva = precio / (float)1.18;
		
		rebaja = (siniva)*(float)0.75;

		System.out.println("Precio ----------> " + siniva);
		System.out.println("Precio Rebajado--> " + rebaja);
		System.out.println("Nuevo PVP -------> " + rebaja * (float)1.18);		
		teclado.close();
	}
}
