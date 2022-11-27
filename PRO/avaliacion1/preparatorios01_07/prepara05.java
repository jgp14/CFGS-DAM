package preparatorios01_07;
import java.util.Scanner;
public class prepara05 {	
	public static void main(String[] args) {
		int edad, entre3_17, entre9_12, entre25_65, entre35_40;
		Scanner teclado = new Scanner(System.in);		
		System.out.print("Dame IDADE: ");
		edad = teclado.nextInt(); 
		entre3_17 = 0; entre9_12 = 0; entre25_65 = 0; entre35_40 = 0;
		while(edad >= 3 && edad <= 17 || edad >= 25 && edad <= 65){
			if(edad >= 3 && edad <= 17) {
				System.out.print("CORRECTO, idade pulsada: " + edad + " -> modificado");
				if(edad >= 9 && edad <= 12) {
					System.out.print("s estos intervalos: (3,17) (9,12)");
					entre9_12 = entre9_12 + 1;
				} else
					System.out.print(" este intervalo: (3,17)");
				entre3_17 = entre3_17 + 1;
			} else {
				System.out.print("CORRECTO, idade pulsada: " + edad + " -> modificado");
				if(edad >= 35 && edad <= 40) {
					System.out.print("s estos intervalos: (25,65) (35,40)");
					entre35_40 = entre35_40 + 1;
				} else
					System.out.print(" este intervalo: (25,65)");
				entre25_65 = entre25_65 + 1;
			}
			System.out.print("\n");
			System.out.print("Dame IDADE: ");
			edad = teclado.nextInt(); 
			teclado.nextLine();
		}
		System.out.println("+++++> Entre 3 e 17 pulsaronse "+ entre3_17 + " idades");
		System.out.println("+++++> Entre 9 e 12 pulsaronse "+ entre9_12 + " idades");
		System.out.println("+++++> Entre 25 e 65 pulsaronse "+ entre25_65 + " idades");
		System.out.println("+++++> Entre 35 e 40 pulsaronse "+ entre35_40 + " idades");
		teclado.close();
	}
}
/*package preparatorios01_07
 * import java.util.Scanner;
 * public class prepara05 {
 * 		public static void main(String[] args) {
 * 			int edad, entre3_17, entre9_12, entre25_65, entre35_40;
 * 			Scanner teclado = new Scanner(System.in);
 * 			System.out.print("Dame IDADE: ");
 * 			edad = teclado.nextInt();
 * 			entre3_17 = 0; entre9_12 = 0; entre25_65 = 0; entre35_40 = 0;
 * 			while(edad >= 3 && edad <=17 || edad >= 25 && edad <= 65){
 * 				if(edad >= 3 && edad <= 17){
 * 					System.out.print("CORRECTO, idade pulsada: "+edad+" -> modificado");
 * 					if(edad >= 9 && edad <= 12){
 * 						System.out.print("s estos intervalos: (3,17) (9,12)");
 * 						entre9_12++;
 * 					} else
 * 						System.out.print(" este intervalo: (3,17)");
 * 					entre3_17++;
 * 				}else{
 * 					System.out.print("CORRECTO, idade pulsada: "+edad+" -> modificado");
 * 					if(edad >= 35 && edad <= 40) {
 * 						System.out.print("s estos intervalos: (25,65) (35,40));
 * 						entre35_40++;
 * 					} else
 * 						System.out.print(" este intervalo: (25, 65)")
 * 					entre25_65++;
 * 				}
 * 				System.out.print("\n");
 * 				System.out.print("Dame IDADE: ");
 * 				edad = teclado.nextInt();
 * 				teclado.nextLine();
 * 			}
 * 			System.out.println("+++++> Entre 3 e 17 pulsaronse "+entre3_17+" idades");
 * 			System.out.println("+++++> Entre 9 e 12 pulsaronse "+entre9_12+"idades");
 * 			System.out.println("+++++> Entre 25 e 65 pulsaronse "+entre25_65+" idades");
 * 			System.out.println("+++++> Entre 35 e 40 pulsaronse "+entre35_40+" idades");
 * 			teclado.close();
 * 		}
 * }
 */