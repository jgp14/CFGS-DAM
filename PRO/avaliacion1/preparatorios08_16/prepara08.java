package preparatorios08_16;
import java.util.Scanner;
public class prepara08 {
	public static void main(String[] args) {
		int edad, entre25_35, entre30_45, entre40_60;
		Scanner teclado = new Scanner(System.in);
		System.out.print("Dame edad: ");
		edad = teclado.nextInt(); 
		entre25_35 = 0; entre30_45 = 0; entre40_60 = 0;
		while(edad >= 25 && edad <= 60) {
			System.out.print("CORRECTO, edad pulsada: " + edad + " -> modificado");
			if(edad >= 25 && edad < 30) {
				System.out.print(" este intervalo: (25,35)"); entre25_35++;
			} else if(edad >= 30 && edad <= 35) {
					System.out.print("s estos intervalos: (25,35) (30,45)"); 
					entre25_35++; entre30_45++;
			} else if(edad > 35 && edad < 40) {
				System.out.print(" este intervalo: (30,45)"); entre30_45++;
			} else if(edad >= 40 && edad <= 45) {
				System.out.print("s estos intervalos: (30,45) (40,60)"); 
				entre30_45++; entre40_60++;
			} else  { //(edad > 45 && edad <= 60)
				System.out.print(" este intervalo: (40,60)"); entre40_60++;
			}
			System.out.print("\n");
			System.out.print("Dame edad: ");
			edad = teclado.nextInt();
			teclado.nextLine();
		}
		System.out.println("+++++> Entre 25 e 35 pulsaronse "+ entre25_35 + " edades");
		System.out.println("+++++> Entre 30 e 45 pulsaronse "+ entre30_45 + " edades");
		System.out.println("+++++> Entre 40 e 60 pulsaronse "+ entre40_60 + " edades");
		teclado.close();
	}
}
/* package preparatorios08_16;
 * import java.util.Scanner;
 * public class prepara08 {
 * 		public static void main(String[] args) {
 * 			int edad, entre25_35, entre30_45, entre40_60;
 * 			Scanner teclado = new Scanner(System.in);
 * 			System.out.print("Dame edad: ");
 * 			edad = teclado.nextInt();
 * 			entre25_35 = 0; entre30_40 = 0; entre40_60 = 0;
 * 			while(edad >= 25 && edad <= 60) {
 * 				System.out.print("CORRECTO, edad pulsada: "+edad+"-> modificado");
 * 				if(edad >= 25 && edad < 30) {
 * 					System.out.print(" este intervalo: (25, 35)"); entre25_35++;
 * 				} else if(edad >= 30 && edad <= 35){
 * 					System.out.print("s estos intervalos: (25, 35) (30,45)");
 * 					entre25_35++; entre30_45++;
 * 				} else if(edad > 35 && edad < 40) {
 * 					SYstem.out.print(" este intervalo: (30,45)"); entre30_45++;
 * 				} else if(edad >40 && edad <= 45) {
 * 					System.out.print(" este intervalo: (40, 60)"); entre40_60++;
 * 				}
 * 				System.out.print("\n");
 * 				System.out.print("Dame edad: ");
 * 				edad = teclado.nextInt();
 * 				teclado.nextLine();
 * 			}
 * 			System.out.println("+++++> Entre 25 e 35 pulsaronse "+ entre25_35+" edades");
 * 			System.out.println("+++++> Entre 30 e 45 pulsaronse "+entre30_45+" edades");
 * 			System.out.println("+++++> Entre 40 e 60 pusaronse "+entre40_60+" edades");
 * 			teclado.close();
 * 		}
 * }
 */