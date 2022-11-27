package practicas;

import misClases.avaliacion2.*;
import misClases.teoria.Leer;

public class practica5 {

	public static void menu() {
		System.out.println();
		System.out.println(" 1.- Matrices");
		System.out.println(" 2.- Array de caracteres");
		System.out.println(" 3.- String");
		System.out.println(" 4.- Sair");
	}
	
	public static void main(String[] args) {
		int n;		
		CMatrices matrices = new CMatrices();
		CArrayCaracteres array = new CArrayCaracteres();
		CString string = new CString();
		do {
			menu();
			System.out.print("\nIntroduce opcion: ");
			n = Leer.datoInt();
			switch(n) {
				case 1:
					matrices.recoge();
					matrices.amosa('A', 'B');
					matrices.trasposta('A', 'C');
					matrices.trasposta('B', 'D');
					matrices.amosa('C', 'D');
					matrices.suma('A', 'B', 'C');
					matrices.resta('A', 'B', 'D');
					matrices.amosa('C', 'D');
					matrices.resta('B', 'A', 'C');
					matrices.multiplica('A', 'B', 'D');
					matrices.amosa('C', 'D');
					break;
				case 2:
					System.out.print(" Cadena: ");
					array.recoge();
					array.amosa();
					array.maiusculas();
					array.minusculas();
					array.arroba();
					array.espacioBlanco();
					array.sinNumeros();
					array.amosa();
					break;
				case 3:
					System.out.print(" String: ");
					string.recoge();
					string.amosa();
					string.maiusculas();
					string.minusculas();
					string.arroba();
					string.espacioBlanco();
					string.sinNumeros();
					string.amosa();
					break;
				case 4:
					System.out.println("FINAL");
					break;
				default:
					System.out.println("OPCION Erronea:");
			}			
		} while(n != 4);	
	}
}
