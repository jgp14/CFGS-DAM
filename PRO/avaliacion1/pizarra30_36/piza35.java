package pizarra30_36;

import java.io.IOException;
import java.util.Scanner;

public class piza35 {

	public static void main(String[] args) throws IOException{
		/*Scanner teclado = new Scanner(System.in);
        boolean isStringLowerCase = false;
		boolean vocal = false; 
		while(isStringLowerCase == false && vocal == false) {		
			System.out.print("Introduce unha vocal minuscula: ");
			String letra = teclado.next();
			letra = letra.replaceAll("�","");
			char[] charArray = letra.toCharArray();
	        for(int i=0; i < charArray.length; i++){
	            //if any character is in lower case, return true
	            if(Character.isLowerCase( charArray[i] ))
	                isStringLowerCase = true;	               
	        }
	        	 if ((letra.charAt(0)=='a') || (letra.charAt(0)=='e') || 
	        			 (letra.charAt(0)=='i') || (letra.charAt(0)=='o') || 
	        			 (letra.charAt(0)=='u')){ 
	        	    vocal = true;
	        	  }
	        	 else
	        		 vocal = false;
		}
		System.out.print("FINAL");
		teclado.close();*/
		
		/*Scanner teclado = new Scanner(System.in);
		
		char letra = 'b';
		
		while(letra != 'a' && letra != 'e' && letra != 'i' 
				&& letra != 'o' && letra != 'u') {
			System.out.print("Dame VOCAL minuscula: ");
			letra = teclado.next().charAt(0);
		}
		
		System.out.print("FINAL");

		teclado.close();*/
		
		char letra;
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Dame VOCAL minuscula: ");
		letra = (char) System.in.read();
		teclado.nextLine();
		while(letra != 'a' && letra != 'e' && letra != 'i' 
				&& letra != 'o' && letra != 'u') {
			System.out.print("Dame VOCAL minuscula: ");
			letra = (char) System.in.read();
			teclado.nextLine();
		}
		System.out.print("FINAL");
		teclado.close();
	}
}
