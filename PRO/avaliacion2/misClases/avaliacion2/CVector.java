package misClases.avaliacion2;

import java.util.Scanner;

public class CVector {
	private int[] vector = new int[20];
	private int total, opcion;
	private Scanner teclado = new Scanner(System.in);
	
	private void menu() {
		System.out.println("\n M E N U");
		System.out.println(" =======");
		System.out.println(" 1.- INICIALIZA Vector de enteiros");
		System.out.println(" 2.- AMOSA Vector");
		System.out.println(" 3.- INSERTA enteiro en Vector");
		System.out.println(" 4.- ELIMINA enteiro en Vector");
		System.out.println(" 5.- FINAL");
	}
	
	public int dameOpcion()  {
		menu();
		opcion = teclado.nextInt();
		return opcion;
	}
	
	public void inicializa() {
		vector[0] = 3;
		vector[1] = 12;
		vector[2] = 15;
		vector[3] = 22;
		vector[4] = 30;
		vector[5] = 43;
		total = 6;
	}
	
	public void amosa() {
		System.out.println("   VECTOR de Enteiros");
		System.out.println("   ==================");
		for(int i = 0; i < total; i++)
			System.out.println("     "+vector[i]);
		System.out.println("    TOTAL: "+total);

	}
	
	public void insertar(int numero) {
		//A. Localizar donde est� el n�mero
		//B. Subir todos los numeros una posicion
		//C. Aumentar total
		int i=0;
		while ((vector[i]<numero) && (i < total)) {
			i++;
		}
		int j=total;
		while(j>i) {
			vector[j] = vector[j-1];
			j--;
		}
		total += 1;
		vector[i] = numero;
	}
	
	public void eliminar(int numero) {
		//A. Localizar donde est� el n�mero
		//B. Bajar todos los numero una posicion
		//C. Decrementar total
		int i=0;
		while((vector[i] != numero) && (i < total)) {
			i++;
		}
		while (i<total) {
			vector[i] = vector[i+1];
			i++;
		}
		total -= 1;
	}
}