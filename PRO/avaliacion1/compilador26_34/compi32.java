package compilador26_34;

import java.util.Scanner;

public class compi32 {

	public static void main(String[] args) {
		
		int i = 0, triangulos, superior = 0;
		float base, altura, superficie;
		
		Scanner teclado = new java.util.Scanner(System.in);
		
		System.out.print("TOTAL triangulos: ");
		triangulos = teclado.nextInt();
		
		System.out.println("PRIMERA Lista");	
		while(i < triangulos) { 
			i++;
			System.out.print("**Dame base " + i +": ");
			base = teclado.nextInt();
			System.out.print("Dame altura " + i +": ");
			altura = teclado.nextInt();
			superficie = (base * altura) / 2;
			System.out.println("*Superficie " + i +": " + superficie);
			
			if(superficie > 12){
				superior += 1;
			}
			else {
			}
		}
		System.out.println("Triangulos con superficie superior a 12 son: " + superior);
		teclado.close();
	}
}
