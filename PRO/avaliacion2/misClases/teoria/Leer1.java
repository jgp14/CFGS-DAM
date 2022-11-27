package misClases.teoria;

import java.io.*;

public class Leer1 {

	public static String dato() {
		String sdato = "";
		try {
			//Definir un flujo de caracteres de entrada: flujoE
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader flujoE = new BufferedReader(isr);
			//Leer. La entrada finaliza al pulsar la tecla Entrar
			sdato = flujoE.readLine();
		}
		catch(IOException e)
		{
			System.err.println("Error: " + e.getMessage());
		}
		return sdato; // devolver el dato tecleado
	}

	public static char datoChar() {
		return dato().charAt(0);
	}
	
	public static String datoString() {
		return dato();
	}
	
	public static short datoShort() {
		try {
			//@SuppressWarnings("deprecation")
			Integer i = new Integer(dato());
			return i.shortValue();
		}
		catch(NumberFormatException e) {
			return Short.MIN_VALUE; // valor mas pequeño
		}
	}
	
	public static int datoInt() {
		try {
			//@SuppressWarnings("deprecation")
			Integer i = new Integer(dato());
			return i.intValue();
		} catch (NumberFormatException e) {
			return Integer.MIN_VALUE; //valor mas peque�o
		}
	}
	
	public static long datoLong() {
		try {
			//@SuppressWarnings("deprecation")
			Integer i = new Integer(dato());
			return i.longValue();
		} catch (NumberFormatException e) {
			return Integer.MIN_VALUE; //valor mas peque�o
		}
	}
	
	public static float datoFloat() {
		try {
			//@SuppressWarnings("deprecation")
			Float f = new Float(dato());
			return f.floatValue();
		}
		catch(NumberFormatException e) {
			return Float.NaN; // No es un Numero; valor float.
		}
	}
	
	public static double datoDouble() {
		try {
			//@SuppressWarnings("deprecation")
			Double d = new Double(dato());
			return d.doubleValue();
		}
		catch(NumberFormatException e) {
			return Double.NaN; // No es un Numero; valor double.
		}
	}
}
