package misClases.avaliacion2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CArrayCaracteres {

	private char[] cad = new char[50]; //cad == cadena
	private int i; 
	
	public void recoge() {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader flujoE = new BufferedReader(isr);
		try {
			int total = flujoE.read(cad, 0, cad.length);
			total -= 1;
			cad[total + 1] = Character.MIN_VALUE;
			cad[total] = Character.MIN_VALUE;
		} catch (IOException iOException) {}
	}
	
	public void amosa() {
		System.out.println();
		for(i = 0; cad[i] != '\0'; i++)
			System.out.print(cad[i]);
	}
	
	public void maiusculas() {
		System.out.println();
		for(i = 0; cad[i] != '\0'; i++) {
			if(cad[i] >= 'a' && cad[i] <= 'z')
				System.out.print((char)(cad[i] - 32));
			else if(cad[i] == 'ñ')
				System.out.print("Ñ");
			else
				System.out.print(cad[i]);
		}
	}
	
	public void minusculas() {
		System.out.println();
		for(i = 0; cad[i] != '\0'; i++) {
			if(cad[i] >= 'A' && cad[i] <= 'Z')
				System.out.print((char)(cad[i] + 32));
			else if(cad[i] == 'Ñ')
				System.out.println("ñ");
			else
				System.out.print(cad[i]);
		}
	}
	
	public void arroba() {
		System.out.println();
		for(i = 0; cad[i] != '\0'; i++) {
			if(cad[i] == 'A' || cad[i] == 'a')
				System.out.print("@");
			else
				System.out.print(cad[i]);
		}
	}
	
	public void espacioBlanco() {
		System.out.println();
		boolean espacioblanco = false;
		for(i = 0; cad[i] != '\0'; i++) {
			if(cad[i] == ' ') {
				if(espacioblanco == true) {
					System.out.print(cad[i]);
					espacioblanco = false;
				} 
			}
			else {
				System.out.print(cad[i]);
				espacioblanco = true;
			}
		}
	}
	
	public void sinNumeros() {
		System.out.println();
		for(i = 0; cad[i] != '\0'; i++)
			if(cad[i] < '0' || cad[i] > '9')
				System.out.print(cad[i]);
	}
}
