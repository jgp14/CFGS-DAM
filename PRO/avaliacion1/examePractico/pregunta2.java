package examePractico;

import java.io.IOException;
import java.util.Scanner;

public class pregunta2 {

	public static void main(String[] args)  throws IOException{
		char letra; 
		Scanner teclado = new Scanner(System.in);
		System.out.print("Dame DÍXITO ou OPERADOR: ");
		letra = (char)System.in.read();
		teclado.nextLine();
		while((letra < '0' || letra > '9') && letra != '+' && letra != '-'
				&& letra != '*' && letra != '/') {
			System.out.print("-> INCORRECTO, pulsaches esta tecla: " + letra);
			System.out.print("\n");
			System.out.print("Dame DÍXITO ou OPERADOR: ");
			letra = (char)System.in.read();
			teclado.nextLine();
		}
		if(letra >= '0' && letra <= '9')
			System.out.print("+++++> CORRECTO, pulsaches este DÍXITO: " + letra);
		else {//(letra == '+' || letra == '-'|| letra == '*' || letra == '/') {
			System.out.print("+++++> CORRECTO, pulsaches este OPERADOR: " + letra);
		}
		teclado.close();
	}

}
