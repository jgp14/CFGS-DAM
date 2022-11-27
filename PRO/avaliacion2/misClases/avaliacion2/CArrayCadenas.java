package misClases.avaliacion2;

import java.util.Scanner;

public class CArrayCadenas {
	private String [] cadenas = new String[7];
	private int opcion;
	private Scanner teclado = new Scanner(System.in);
	
	private void menu() {
		System.out.println("\n M E N U");
		System.out.println("  =======");
		System.out.println(" 1.- INICIALIZA Array de Cadenas");
		System.out.println(" 2.- AMOSA Array");
		System.out.println(" 3.- ORDENA Ascendentemente");
		System.out.println(" 4.- ORDENA Descendentemente");
		System.out.println(" 5.- FINAL");	
	}
	
	public int dameOpcion()  {
		menu();
		System.out.print("Pulsa opcion: ");
		opcion = teclado.nextInt();
		return opcion;
	}
	
	public void inicializa() {
		cadenas[0] = "Lunes";
		cadenas[1] = "Martes";
		cadenas[2] = "Miercoles";
		cadenas[3] = "Jueves";
		cadenas[4] = "Viernes";
		cadenas[5] = "Sabado";
		cadenas[6] = "Domingo";
	}
	
	public void amosa() {
	    System.out.println("  ARRAY de Cadenas");
	    System.out.println("  ================");
		for(int i = 0; i < cadenas.length; i++)
			System.out.print("  "+cadenas[i]);	
	}
	
	public void ordearAscendente() {
		int i, j;
		String dato;
		
		if(cadenas[0] == null)
			return;
		for(i = 1; i <= cadenas.length - 1; i++)
			for(j = cadenas.length - 1; j >= i; j--)
				if(cadenas[j-1].compareTo(cadenas[j]) > 0) {
					dato = cadenas [j - 1];
					cadenas[j-1] = cadenas [j];
					cadenas[j] = dato;
				}
	}
	
	public void ordearDescendente() {
		
		int i, j, n; 
		String dato;
		n = cadenas.length;
		for(i = 1; i <= n-1; i++)
			for(j = n-1; j >= i; j--)
				if(cadenas[j-1] != cadenas[j]) {
					 dato = cadenas[j-1];
					 cadenas[j-1] = cadenas[j];
					 cadenas[j]= dato;
				}	
	}
}
