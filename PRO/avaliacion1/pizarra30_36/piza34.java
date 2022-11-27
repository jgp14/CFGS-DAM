package pizarra30_36;

import java.util.Scanner;

import java.io.IOException;

public class piza34 {

	public static void main(String[] args) throws IOException {
		/*Scanner teclado = new Scanner(System.in);
        boolean isStringLowerCase = true;
		while(isStringLowerCase == true) {		
			System.out.print("Introduce unha letra minuscula "
					+ "entre a 'a' e a 'z': ");
			String letra = teclado.next();
			letra = letra.replaceAll("Ã±","");
			char[] charArray = letra.toCharArray();
	        for(int i=0; i < charArray.length; i++){
	            //if any character is in lower case, return true
	            if(Character.isLowerCase( charArray[i] )) {
	                isStringLowerCase = true;
	    			System.out.println("CORRECTO e minuscula: " + letra);
	            }
	            else {
	            	isStringLowerCase = false;
	            	System.out.print("INCORRECTO non e minuscula: " + letra);
	            }
	        }
		}		
		teclado.close();*/
		
		/*Scanner teclado = new Scanner(System.in);
		char letra = 'l';
		while(letra >= 'a' && letra <= 'z' && letra != 'ñ') {
			System.out.print("Dame MINUSCULA: ");
			letra = teclado.next().charAt(0);
			if (letra >= 'a' && letra <= 'z' && letra != 'ñ')
				System.out.println("CORRECTO e minuscula: " + letra);
			else
				System.out.print("INCORRECTO non e minuscula: " + letra);
		}
		teclado.close();*/
		
		char letra; //solucion34
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Dame MINUSCULA: ");
		letra=(char)System.in.read();
		teclado.nextLine();
		while (letra>='a' && letra <='z') {
			System.out.println("CORRECTO e minuscula: "+letra);
			System.out.print("Dame MINUSCULA: ");
			letra=(char)System.in.read();
			teclado.nextLine();
		}
		System.out.print("INCORRECTO non e minuscula: "+letra);
		teclado.close();
	}
}
