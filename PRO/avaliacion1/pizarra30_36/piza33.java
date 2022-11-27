package pizarra30_36;

import java.io.IOException;
import java.util.Scanner;

public class piza33 {

	public static void main(String[] args) throws IOException {
		/*Scanner teclado = new Scanner(System.in);
        boolean isStringLowerCase = false;		
		while(isStringLowerCase == false) {		
			System.out.print("Introduce unha letra minuscula "
					+ "entre a 'a' e a 'z': ");
			String letra = teclado.next();
			letra = letra.replaceAll("Ã±","");
			char[] charArray = letra.toCharArray();
	        for(int i=0; i < charArray.length; i++){
	            //if any character is in lower case, return true
	            if(Character.isLowerCase( charArray[i] )) {
	                isStringLowerCase = true;
	    			System.out.print("FINAL");
	            }
	        }
		}
		teclado.close();*/
		
		/*System.out.print("Introduce unha letra minuscula: "
				+ "entre a 'a' e a 'z': ");
		char letra = (char) System.in.read();
		
		Scanner teclado = new Scanner(System.in);
		char letra = 'A';
		while(letra >= 'A' && letra <= 'Z' || 
				letra >= '0' && letra <= '9'
				|| letra == 'ñ' || letra == 'Ñ') {
			System.out.print("Dame MINUSCULA: ");
			letra = teclado.next().charAt(0);
		}
		System.out.print("FINAL");
		teclado.close();*/
		
		char letra; //solucion 33
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Dame MINUSCULA: ");
		letra = (char) System.in.read();
		teclado.nextLine();
		while(letra <'a' || letra > 'z') {
			System.out.print("Dame MINUSCULA: ");
			letra = (char) System.in.read();
			teclado.nextLine();
		}
		System.out.print("FINAL");
		teclado.close();
	}
}
