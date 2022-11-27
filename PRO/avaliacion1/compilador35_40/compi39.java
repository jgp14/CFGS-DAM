package compilador35_40;

import java.util.Scanner;

import misClases.avaliacion1.CSerie;

public class compi39 {

	public static void main(String[] args) {
		
		CSerie cserie = new CSerie();
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("O numero A sera menor que o numero B");
		System.out.print("Dame o numero A: ");
		int a = teclado.nextInt();
		System.out.print("Dame o numero B: ");
		int b = teclado.nextInt();
		
		cserie.amosaA_B(a, b);;
		teclado.close();
	}
}
