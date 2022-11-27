package preparatorios08_16;

import java.util.Scanner;

public class prepara13 {

	public static void main(String[] args) {
		int edad, entre10_30, entre15_21, 
		entre30_50, entre25_45;
		Scanner teclado = new Scanner(System.in);
		System.out.print("Dame edad: ");
		edad = teclado.nextInt();
		entre10_30 = 0; entre15_21 = 0; 
		entre30_50 = 0; entre25_45 = 0;
		while(edad >= 10 && edad <= 50) {
			System.out.print("CORRECTO, edad pulsada: " + edad + 
					" -> modificado");
			if(edad >= 10 && edad < 15) {
				System.out.print(" este intervalo: (10,30)");
				entre10_30++;
			} else if(edad >= 15 && edad <= 21) {
				System.out.print("s estos intervalos: (10,30) (15,21)");
				entre10_30++;
				entre15_21++;
			} else if(edad > 21 && edad < 25) {
				System.out.print(" este intervalo: (10,30)");
				entre10_30++;
			} else if(edad >= 25 && edad < 30) {
				System.out.print("s estos intervalos: (10,30) (25,45)");
				entre10_30++;
				entre25_45++;
			} else if(edad == 30) {
				System.out.print("s estos intervalos: (10,30) (25,45) (30,50)");
				entre10_30++;
				entre25_45++;
				entre30_50++;
			} else if(edad > 30 && edad <= 45) {
				System.out.print("s estos intervalos: (25,45) (30,50)");
				entre30_50++;
				entre25_45++;
			} else { //(edad > 45 && edad <= 50)
				System.out.print(" este intervalo: (30,50)");
				entre30_50++;
			}
			System.out.print("\n");
			System.out.print("Dame edad: ");
			edad = teclado.nextInt();
			teclado.nextLine();
		}
		System.out.println("+++++> Entre 10 e 30 pulsaronse "+ entre10_30 + " edades");
		System.out.println("+++++> Entre 30 e 50 pulsaronse "+ entre30_50 + " edades");
		System.out.println("+++++> Entre 15 e 21 pulsaronse "+ entre15_21 + " edades");
		System.out.println("+++++> Entre 25 e 45 pulsaronse "+ entre25_45 + " edades");
		teclado.close();
	}

}
