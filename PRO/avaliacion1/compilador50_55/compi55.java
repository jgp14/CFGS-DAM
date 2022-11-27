package compilador50_55;

import java.util.Scanner;

public class compi55 {
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		int num, enteiro;
		double real;
		String cadea;
				
		num = 1;
		
		do {
			System.out.println("    M E N U");
			System.out.println("1.- Dame un ENTEIRO");
			System.out.println("2.- Dame un REAL");
			System.out.println("3.- Dame una CADEA");
			System.out.println("4.- FINAL");
			System.out.println("");
			num = teclado.nextInt();
			teclado.nextLine();
			
			switch(num) {
				case 1:
					System.out.println("ENTEIRO: ");
					enteiro = teclado.nextInt();
					System.out.println("ENTEIRO pulsado: " + enteiro);
					break;
				case 2:
					System.out.println("REAL: ");
					real = teclado.nextDouble();
					System.out.println("REAL pulsado: " + real);
					break;
				case 3:
					System.out.println("CADEA: ");
					cadea = teclado.next();
					System.out.println("CADEA pulsado: " + cadea);
					break;
				case 4:
					System.out.println("FINAL");
					System.exit(0);
					break;
				default:
					System.out.println("OPCION Erronea");
					break;
			}
			
		} while(num != 4);
		
		teclado.close();
	}
}
