package compilador26_34;

import java.util.Scanner;

public class compi31 {

	public static void main(String[] args) {
		
		int i = 0, cuantos, numeros, pares = 0, impares = 0;
		
		Scanner teclado = new java.util.Scanner(System.in);
		
		System.out.print("Cuantos numeros:");
		cuantos = teclado.nextInt();
		
		System.out.println("PRIMERA Lista");	
		while(i < cuantos) { 
			i++;
			System.out.print("Dame valor " + i +": ");
			numeros = teclado.nextInt();
			
			if(numeros % 2 == 0){
				pares += 1;
			}
			else {
				impares += 1;
			}
		}
		System.out.println("Cantidad de pares: " + pares );
		System.out.println("Cantidad de impares: " + impares);	
		teclado.close();
	}
}
