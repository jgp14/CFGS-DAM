package misClases.avaliacion2;

import java.util.Scanner;

public class CDameDato {
	private Scanner teclado = new Scanner(System.in);
	private int opcion, datoInt;
	private float datoFloat;
	private String datoString;
	
	private void menu() {
		System.out.println("\n M E N U");
		System.out.println(" ======");
		System.out.println(" 1.- Dame un ENTEIRO");
		System.out.println(" 2.- Dame un REAL");
		System.out.println(" 3.- Dame una CADEA");
		System.out.println(" 4.- FINAL");
	}

	public int dameOpcion() {
		menu();
		opcion = teclado.nextInt();
		return opcion;
	}

	public void amosarDatoInt() {
		System.out.println(" dato int PULSADO: " 
		+ datoInt);
	}

	public void recollerDatoInt() {
		System.out.print(" DAME dato int: ");
		datoInt = teclado.nextInt();
	}

	public void amosarDatoFloat() {
		System.out.println(" dato float PULSADO: " 
				+ datoFloat);
	}

	public void recollerDatoFloat() {
		System.out.print(" DAME dato float: ");
		datoFloat = teclado.nextFloat();
	}

	public void amosarDatoString() {
		System.out.println(" dato String PULSADO: " 
				+ datoString);
	}

	public void recollerDatoString() {
		System.out.print(" DAME dato String: ");
		teclado.nextLine();
		datoString = teclado.nextLine();
	}
	
}