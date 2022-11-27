package compilador50_55;

import java.util.Scanner;

public class compi50 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		int num;
		
		System.out.print("Introduzca un numero entre 1 y 5: ");
		num = teclado.nextInt();
		while(num >= 1 && num <= 5) {
			switch(num){
				case 1: System.out.println("E o 1");
					break;
				case 2: System.out.println("E o 2");
					break;
				case 3: System.out.println("E o 3");
					break;
				case 4: System.out.println("E o 4");
					break;
				case 5: System.out.println("E o 5");
					break;
			}
			System.out.print("Introduzca un numero entre 1 y 5: ");
			num = teclado.nextInt();
		}	
		System.out.print("FINAL");
		teclado.close();
	}
}
