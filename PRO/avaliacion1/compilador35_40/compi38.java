package compilador35_40;

import java.util.Scanner;

import misClases.avaliacion1.CSerie;

public class compi38 {

	public static void main(String[] args) {
		
		CSerie cserie = new CSerie();
		
		System.out.print("Dame un numero entre 1 e 20: ");
		
		Scanner teclado = new Scanner(System.in);
		
		int j = teclado.nextInt();
		
		cserie.amosaDende20(j);
		teclado.close();
	}
}
