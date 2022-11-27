package piza201_208;

import java.io.IOException;
import java.util.Scanner;

import misClases.avaliacion2.CCadena;

public class piza206 {

	public static void main(String[] args) throws IOException {
	    Scanner teclado = new Scanner(System.in);
	    CCadena cadena = new CCadena();
	    
	    System.out.print("Dame cadena: ");
	    cadena.recolleCadena();
	    System.out.print("Dame LETRA a eliminar en cadea: ");
	    teclado.nextLine();
	    char letra = (char)System.in.read();
	    
	    cadena.eliminaEnCadena(letra);
	    System.out.print("CADEA sen a LETRA (" + letra + ") : ");
	    cadena.amosaCadena();
	    teclado.close();

	}

}
