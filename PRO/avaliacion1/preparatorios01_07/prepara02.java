package preparatorios01_07;

import java.util.Scanner;

public class prepara02 {

	public static void main(String[] args) {
		int edad;
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Dame idade: ");
		edad = teclado.nextInt();
		
		while (edad >= 1 && edad <= 9 || edad >= 65 && edad <= 110) {
			if (edad >= 1 && edad <= 9)
				System.out.println("-> ESTE CATIVO TEN "+edad+" ANOS");
			else
				System.out.println("-> ESTE ANCIAN TEN "+edad+" ANOS");
			System.out.print("Dame idade: ");
			edad = teclado.nextInt();
		}
		System.out.println("+++++> Idade NON permitida");
		teclado.close();
	}
}

/*package preparatorios01_07;
 * 
 *import java.util.Scanner;
 * 
 *class prepara02 {
 * 
 * 	public static void main(String[] args) {
 * 	int edad; 
 * 	Scanner teclado = new Scanner (System.in);
 * 
 * 	System.out.print("Dame idade: ");
 * 	edad = teclado.nextInt();
 * 	
 * 	while (edad >= 1 && edad <= 9 || edad >= 65 && edad <= 110) {
 *		if(edad >= 1 && edad <= 9)
 *			System.out.println(" -> ESTE CATIVO TEN " + edad + " ANOS");
 *		else
 *			System.out.println(" -> Este ANCIAN TEN " + edad + "ANOS");
 *		System.out.print("Dame idade: ");
 *		edad = teclado.nextInt();
 *	}
 *	System.out.println(" +++++> Idade NON permitida");
 *	teclado.close(); 
 *}
 *}
 */