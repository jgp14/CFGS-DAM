package compilador26_34;

import java.util.Scanner;

public class compi30 {

	public static void main(String[] args) {
		
		int i = 0, numeros, total1 = 0, total2 = 0;
		
		Scanner teclado = new java.util.Scanner(System.in);
		
		System.out.println("PRIMERA Lista");	
		while(i < 4) { 
			i++;
			System.out.print("Dame valor " + i +": ");
			numeros = teclado.nextInt();
			total1 += numeros;
		}
		System.out.println();
		i = 0;		
		System.out.println("SEGUNDA Lista");
		while(i < 4) { 
			i++;
			System.out.print("Dame valor " + i +": ");
			numeros = teclado.nextInt();
			total2 += numeros;
		}
		System.out.println();
		System.out.println("TOTAL Lista 1: " + total1);
		System.out.println("TOTAL Lista 2: " + total2);
		
		if (total1 == total2) {
			System.out.println("Listas IGUALES");
		}
		else {
			if(total1 < total2) {
				System.out.println("Lista 2 MAYOR");
			}
			else {
				System.out.println("Lista 1 MAYOR");
			}
		}
		teclado.close();
	}
}
