package compilador01_08;

import java.util.Scanner;

public class compi06 {

	public static void main(String[] args) {
		
		float edad1, edad2, edad3, media;		
		Scanner teclado = new java.util.Scanner(System.in);		
		System.out.print("Idade do alumno 1: ");
		edad1 = teclado.nextInt();
		
		System.out.print("Idade do alumno 3: ");
		edad2 = teclado.nextInt();
		
		System.out.print("Idade do alumno 3: ");
		edad3 = teclado.nextInt();
		
		media = (edad1 + edad2 + edad3) / (float)3;		
		System.out.print("A idade media e " + media);		
		teclado.close();
		
	}
	
}
