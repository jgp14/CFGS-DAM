package preparatorios08_16;

import java.io.IOException;
import java.util.Scanner;

public class prepara11 {

	public static void main(String[] args) throws IOException{
		char letra; 
		Scanner teclado = new Scanner(System.in);
		System.out.print("Dame DIXITO ou VOCAL minuscula: ");
		letra = (char)System.in.read();
		teclado.nextLine();
		while(letra >= '0' && letra <= '9' || letra == 'a' || letra == 'e'
				|| letra == 'i' || letra == 'o' || letra == 'u') {
			if(letra >= '0' && letra <= '9')
				System.out.print("-> CORRECTO, pulsaches este DIXITO: " + letra);
			else
				System.out.print("-> CORRECTO, pulsaches esta VOCAL minuscula: " + letra);
			System.out.print("\n");
			System.out.print("Dame DIXITO ou VOCAL minuscula: ");
			letra = (char)System.in.read();
			teclado.nextLine();
		}
		System.out.print("+++++> INCORRECTO, pulsaches esta tecla: " + letra);
		teclado.close();
	}
}

/*package preparatorios08_16;
 * 
 * import java.io.IOException;
 * import java.io.Scanner;
 * 
 * public class prepara11 {
 * 		public static void main(String[] arg) throws IOException{
 * 			char letra;
 * 			Scanner teclado = new Scanner(System.in);
 * 			System.out.print("Dame DIXITO ou VOCAL minuscula: ");
 * 			letra = (char)System.in.read();
 * 			teclado.nextLine();
 * 			while(letra >= '0' && letra <= '9' || letra == 'a' || letra == 'e' 
 * 				|| letra == 'i' || letra == 'o' || letra == 'u'){
 * 				if(letra >= '0' && letra <= '9')
 * 					System.out.print("-> CORRECTO, pulsaches este DIXITO: "+letra);
 * 				else
 * 					System.out.print("-> COTTECTO, pulsaches esta VOCAL minuscula: " + letra);
 * 				System.out.print("\n");
 * 				System.out.print("Dame DIXITO ou VOCAL minuscula: ");
 * 				letra = (char)System.in.read();
 * 				teclado.nextLine(); 			
 * 			}
 * 			System.out.print("+++++> INCORRECTO, pulsaches esta tecla: "+letra);
 * 			teclado.close();
 * 		}
 * }
 */