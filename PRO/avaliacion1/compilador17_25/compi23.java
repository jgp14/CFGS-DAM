package compilador17_25;

import java.util.Scanner;

public class compi23 {

	public static void main(String[] args) {
		
		int i = 0, empleados, inferior = 0, superior = 0;
		float sueldo, suma = 0;

		Scanner teclado = new java.util.Scanner(System.in);
		
		System.out.print("Cuantos empleados hay: ");			
		empleados = teclado.nextInt();
		
		while(i < empleados) {
			i += 1;			
			System.out.print("Dame sueldo " + i +": ");			
			sueldo = teclado.nextFloat();
			suma += sueldo;
			
			if(100 <= sueldo && sueldo <= 300) {
				inferior += 1;
			}						
			if(sueldo > 300) {
				superior += 1;
			}
		}
		System.out.println("Empleados con sueldos entre 100 y 300: " + inferior);
		System.out.println("Empleados con sueldos superiores a 300: " + superior);
		System.out.println("Gastos total de la empresa en sueldos: " + suma);
		teclado.close();		
	}
}
