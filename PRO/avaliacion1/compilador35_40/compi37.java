package compilador35_40;

import java.util.Scanner;

import misClases.avaliacion1.CSerie;

public class compi37 {

	public static void main(String[] args) {
		
		CSerie cserie = new CSerie();
		int num;
		System.out.print("Dame un numero entre 1 e 20: ");
		Scanner teclado = new Scanner(System.in);
		num = teclado.nextInt();
		
		cserie.amosaAta20(num);
		teclado.close();
	}
}
