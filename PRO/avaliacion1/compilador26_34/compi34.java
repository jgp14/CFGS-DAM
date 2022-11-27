package compilador26_34;

import java.util.Scanner;

public class compi34 {

	public static void main(String[] args) {
		
		int i, numeros, negativos = 0, positivos = 0, multiplos = 0, suma = 0;
		
		@SuppressWarnings("resource")
		Scanner teclado = new java.util.Scanner(System.in);
		
		for(i = 1; i <= 8; i++){
			System.out.print("Ingrese valor " + i +": ");
			numeros = teclado.nextInt();
			if(numeros < 0)	{
			negativos += 1;
			}
			else {
			positivos += 1;
			}
			if(numeros % 5 == 0) {
				multiplos += 1;
			}		
			if (numeros % 2 == 0) {
				suma += numeros;
			}
		}
		System.out.println("Cantidad de valores negativos: " + negativos);
		System.out.println("Cantidad de valores negativos: " + positivos);
		System.out.println("Cantidad de valores multiplos de 5:" + multiplos);
		System.out.println("Suma de los valores pares:" + suma);
		teclado.close();
	}
}
