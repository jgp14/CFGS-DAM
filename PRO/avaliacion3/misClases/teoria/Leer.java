package misClases.teoria;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PushbackReader;

public class Leer {
	private static InputStreamReader isr = 
			new InputStreamReader(System.in);
	private static PushbackReader flujoE = 
			new PushbackReader(isr);
	
	public static void limpiar() {
		try {
			while (flujoE.ready()) 
				flujoE.read();
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	public static char mirar() {
		int car = 0;
		try {
			car = flujoE.read();
			flujoE.unread(car);
		}catch(IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
		return(char)car; 
	}
	
	public static char datoChar() {
		int car = 0;
		try {
			car = flujoE.read();
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
		return (char)car;
	}
	
	public static String dato() {
		StringBuffer sdato = new StringBuffer();
		int car = 0;
		try {
			while((car = flujoE.read()) != '\n' && car != -1)
				sdato.append((char)car);
			limpiar();
		} catch(IOException e) {
			System.err.println("Error: "+e.getMessage());
		}
		if(car == -1) 
			return null;
		return sdato.toString();
	}
	
	public static String datoString() {
		return dato();
	}
	
	public static short datoShort() {
	    try {
	    	return Short.parseShort(dato());
	    } catch (NumberFormatException e) {
	    	System.out.print
	    	("Dato short INVALIDO. Teclee otro: ");
	    	return datoShort();
	    } 
	}

	public static int datoInt() { 
		try {
			return Integer.parseInt(dato());
		} catch (NumberFormatException e) {
			System.out.print
			("Dato int INVALIDO. Teclee otro: ");  
			return datoInt(); 
		}
	}
	
	public static long datoLong() {
		try {
			return Long.parseLong(dato());
		} catch (NumberFormatException e) {
			System.out.print
			("Dato long INVALIDO. Teclee otro: ");  
			return datoLong();
		}
	}
	
	public static float datoFloat() {
	    try {
	    	return Float.parseFloat(dato());
	    } catch (NumberFormatException e) {
	    	System.out.print
	    	("Dato float INVALIDO. Teclee otro: ");
	    	return datoFloat();
	    } 
	}
	
	public static double datoDouble() {
		try {
			return Double.parseDouble(dato());
		} catch (NumberFormatException e) {
			System.out.print
			("Dato double INVALIDO. Teclee otro: ");
		    return datoDouble();
		}
	}
}
