package compilador50_55;

import java.util.Scanner;

public class compi52 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		int num = 1;
		
		while(num >= 1 && num <= 3) {
			System.out.println("    M E N U");
			System.out.println("    =======");
			System.out.println("1.- Amoso UNHA");
			System.out.println("2.- Amoso DUAS DUAS");
			System.out.println("3.- Amoso TRES TRES TRES");
			num = teclado.nextInt();
			teclado.nextLine();
			switch(num){
				case 1: 
					System.out.println("UNHA");
					break;
				case 2: 
					System.out.println("DUAS DUAS");
					break;
				case 3: 
					System.out.println("TRES TRES TRES");
					break;
			}
		}
		
		System.out.print("FINAL");
		teclado.close();
	}
}
