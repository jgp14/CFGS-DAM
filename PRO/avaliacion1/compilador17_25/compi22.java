package compilador17_25;

import java.util.Scanner;

public class compi22 {

	public static void main(String[] args) {
		
		int i = 0, alumnos;
		float altura, suma = 0;

		Scanner teclado = new java.util.Scanner(System.in);
		
		System.out.print("Cuantos alumnos hay: ");			
		alumnos = teclado.nextInt();
		
		while(i < alumnos) {
			i += 1;			
			System.out.print("Dame altura " + i +": ");			
			altura = teclado.nextFloat();
			suma += altura;
	
		}
		System.out.println("Altura promedio:" + suma / alumnos);
		teclado.close();		
	}
}
