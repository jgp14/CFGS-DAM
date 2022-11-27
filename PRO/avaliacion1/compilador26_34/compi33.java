package compilador26_34;

import java.util.Scanner;

public class compi33 {

	public static void main(String[] args) {
		
		int i, numeros, suma = 0;
		
		@SuppressWarnings("resource")
		Scanner teclado = new java.util.Scanner(System.in);
		
		for(i = 1; i <= 3; i++){
			System.out.print("Ingrese valor " + i +": ");
			numeros = teclado.nextInt();
			
		}
		for(i = 4; i <= 6; i++){
			System.out.print("Ingrese valor " + i +": ");
			numeros = teclado.nextInt();
			suma += numeros;			
		}		
		System.out.println("La suma de los 3 ultimos valores es:" + suma);
		teclado.close();
	}
}
