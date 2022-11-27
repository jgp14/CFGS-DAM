package examePractico;

import java.util.Scanner;

public class pregunta1 {

	public static void main(String[] args) {
		int edad, entre40_60, entre50_75, 
		entre60_90, entre80_85;
		Scanner teclado = new Scanner(System.in);
		System.out.print("Dame edad: ");
		edad = teclado.nextInt();
		entre40_60 = 0; entre50_75 = 0; 
		entre60_90 = 0; entre80_85 = 0;
		while(edad >= 40 && edad <= 90) {
			System.out.print("CORRECTO, edad pulsada: " + edad + 
					" -> modificado");
			if(edad >= 40 && edad < 50) {
				System.out.print(" este intervalo: (40,60)");
				entre40_60++;
			} else if(edad >= 50 && edad < 60) {
				System.out.print("s estos intervalos: (40,60) (50,75)");
				entre40_60++;
				entre50_75++;
			} else if(edad == 60) {
				System.out.print("s estos intervalos: (40,60) (50,75) (60,90)");
				entre40_60++;
				entre50_75++;
				entre60_90++;
			} else if(edad > 60 && edad <= 75) {
				System.out.print("s estos intervalos: (50,75) (60,90)");
				entre50_75++;
				entre60_90++;
			} else if(edad > 75 && edad < 80) {
				System.out.print(" este intervalo: (60,90)");
				entre60_90++;
			} else if(edad >= 75 && edad <= 85) {
				System.out.print("s estos intervalos: (80,85) (60,90)");
				entre60_90++;
				entre80_85++;
			} else { //(edad > 85 && edad <= 90)
				System.out.print(" este intervalo: (60,90)");
				entre60_90++;
			}
			System.out.print("\n");
			System.out.print("Dame edad: ");
			edad = teclado.nextInt();
			teclado.nextLine();
		}
		System.out.println("+++++> Entre 40 e 60 pulsaronse "+ entre40_60 + " idades");
		System.out.println("+++++> Entre 50 e 75 pulsaronse "+ entre50_75 + " idades");
		System.out.println("+++++> Entre 60 e 90 pulsaronse "+ entre60_90 + " idades");
		System.out.println("+++++> Entre 80 e 85 pulsaronse "+ entre80_85 + " idades");
		teclado.close();
		
	}

}
