package compilador09_16;

import java.util.Scanner;

public class compi13 {

	public static void main(String[] args) {
		
		float nota1, nota2, nota3, media;		
		Scanner teclado = new java.util.Scanner(System.in);
		
		System.out.print("Ingrese primera nota:");		
		nota1 = teclado.nextInt();
		
		System.out.print("Ingrese segunda nota:");		
		nota2 = teclado.nextInt();
		
		System.out.print("Ingrese tercera nota:");		
		nota3 = teclado.nextInt();
		
		media = (nota1 + nota2 + nota3)/3;
		System.out.println("Su media ---> " + media);		
		
		if(media >= 7) {
			System.out.println("PROMOCIONADO");
		}else {
		}
		teclado.close();
	}
}
