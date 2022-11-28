package teoria.capitulo12;

import java.io.*;

public class Leer {

	// Definir un flujo de caracteres de entrada: flujoE
	private static InputStreamReader isr = 
			new InputStreamReader(System.in);
	private static PushbackReader flujoE = 
			new PushbackReader(isr);
	
	public static void limpiar() {
		// limpiar flujoE
		//int car = 0;
		try {
			while (flujoE.ready()) flujoE.read(); 
			// limpiar flujoE
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	public static char mirar() {
		// retornar el primer caracter disponible sin extraerlo
		int car = 0;
		try {
			car = flujoE.read();
			flujoE.unread(car);
		}catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return(char)car; // retornar el primer caracter disponible
	}
	
	public static char caracter() {
		// devolver el siguiente caracter de la entrada
		int car = 0;
		try {
			car = flujoE.read();
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return (char)car; // devolver el dato tecleado
	}
	
	public static char datoChar() {
		// devolver el siguiente caracter de la entrada
		int car = 0;
		try {
			car = flujoE.read();
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return (char)car; // devolver el dato tecleado
	}
	
	public static String dato() {
		// devolver un String que almacene el dato tecleado
		StringBuffer sdato = new StringBuffer();
		int car = 0;
		
		try {
			// Leer. 
			//La entrada finaliza al pulsar la tecla Entrar
			while((car = flujoE.read()) != '\r' && car != -1)
				sdato.append((char)car);
			limpiar();
		} catch(IOException e) {
			System.err.println("Error: "+e.getMessage());
		}
		
		if(car == -1) return null;
		return sdato.toString(); // devolver el dato tecleado
	}
	
	public static String datoString() {
		return dato();
	}

	public static int datoInt() { 
		try {
			return Integer.parseInt(dato());
		} catch (NumberFormatException e) {
			System.out.println("Error int: " + e.getMessage()+"\n");
			System.out.println("Error int: " + e.toString()+"\n");
			return Integer.MIN_VALUE; // valor mas pequeño
		}
	}
	
	public static long datoLong() {
		try {
			return Long.parseLong(dato());
		} catch (NumberFormatException e) {
			System.out.println("Error long: " + e.getMessage()+"\n");
			return Long.MIN_VALUE; // valor mas pequeño
		}
	}
	
	public static double datoDouble() {
		try {
			return Double.parseDouble(dato());
		} catch (NumberFormatException e) {
			System.out.println
			("Error double: " + e.getMessage()+"\n");
			return Double.NaN; // No es un N�mero. Valor double
		}
	}
}
