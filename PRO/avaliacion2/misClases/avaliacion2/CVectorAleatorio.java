package misClases.avaliacion2;

import java.util.Scanner;

public class CVectorAleatorio {
	private int[] a = new int[10];
	private int opcion;
	private Scanner teclado = new Scanner(System.in);
	
	private void menu() {
		System.out.println("\n M E N U");
		System.out.println(" =======");
		System.out.println("1.- INICIALIZA Aleatoriamente Vector");
		System.out.println("2.- AMOSA Vector");
		System.out.println("3.- ORDENA Ascendentemente");
		System.out.println("4.- ORDENA Descendentemente");
		System.out.println("5.- FINAL");	
	}

	public int dameOpcion()  {
		menu();
		opcion = teclado.nextInt();
		return opcion;
	}
	
	public void inicializa() {
		int min = 30;
		int max = 90;
		for(int i = 0; i < a.length; i++)
			a[i] = (int) (Math.random()*(max-min+1)+min);
	}
	
	public void amosa() {
	    System.out.println("   VECTOR de Enteiros");
	    System.out.println("   ==================");
	    int i;
		for(i = 0; i < a.length; i++)
			System.out.print("      "+i);
		System.out.println("");
		for(i = 0; i < a.length; i++) {
			if(i < 10)
				System.out.print("     "+a[i]);
			else if (i >= 10 && i < 100)
				System.out.print("      "+a[i]);
			else if (i >= 100  && i < 1000)
				System.out.print("       "+a[i]);
			else
				System.out.print("        "+a[i]);
		}
	}
	
	public void ordearAscendente() {
		
		int i, j, n, dato;
		n = a.length;
		for(i = 1; i <= n-1; i++)
			for(j = n-1; j >= i; j--)
				if(a[j-1] > a[j]) {
					 dato = a[j-1];
					a[j-1] = a[j];
					a[j]= dato;
				}	
	}
	
	public void ordearDescendente() {
		
		int i, j, n, dato;
		n = a.length;
		for(i = 1; i <= n-1; i++)
			for(j = n-1; j >= i; j--)
				if(a[j-1] < a[j]) {
					 dato = a[j-1];
					a[j-1] = a[j];
					a[j]= dato;
				}
	}
}
