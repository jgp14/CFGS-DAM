package compilador17_25;

import java.util.Scanner;

public class compi21 {

	public static void main(String[] args) {
		
		int i = 0, nota, aptos = 0, noaptos = 0;

		Scanner teclado = new java.util.Scanner(System.in);
		
		while(i < 7) {
			i += 1;			
			System.out.print("Dame nota " + i +": ");			
			nota = teclado.nextInt();
			
			if(nota >= 6) {
				aptos += 1;
			}
			else {
				noaptos += 1;
			}			
		}
		System.out.println("Alumnos con nota mayor o igual que 6: " + aptos);
		System.out.println("Alumnos con nota menor que 6: " + noaptos);
		teclado.close();		
	}
}
