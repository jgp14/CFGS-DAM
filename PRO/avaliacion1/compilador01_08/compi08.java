package compilador01_08;

import java.util.Scanner;

public class compi08 {

	public static void main(String[] args) {
		
		int uxia, maruxa, anxo;		
		Scanner teclado = new java.util.Scanner(System.in);		
		System.out.print("Idade de Uxia (EN MESES): ");
		uxia = teclado.nextInt();
		
		System.out.print("Idade de Maruxa (EN MESES): ");
		maruxa = teclado.nextInt();
		
		System.out.print("Idade de Anxo (EN MESES): ");
		anxo = teclado.nextInt();
			
		System.out.println("Os anos de Uxia son " + uxia/12 + " anos e " + uxia % 12 +" meses");
		System.out.println("Os anos de Maruxa son " + maruxa/12 + " anos e " + maruxa % 12 +" meses");		
		System.out.println("Os anos de Anxo son " + anxo/12 + " anos e " + anxo % 12 +" meses");		
		teclado.close();
		
	}
	
}
