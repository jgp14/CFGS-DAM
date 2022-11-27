package utilidades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeerBien {
	
	private static String dato() {
		String sdato = "";
		try{
			InputStreamReader isr = new InputStreamReader(System.in); 
			BufferedReader flujoE = new BufferedReader(isr); 
			sdato = flujoE.readLine(); 
		} catch (IOException e) { } return sdato; 
	}
	
	private int datoInt() { 
		try {
			return Integer.parseInt(dato());
		} catch (NumberFormatException e) {
			return Integer.MIN_VALUE; 
		}
	}
	
	public int datoIntC() {
		int i = datoInt();
    	while(i == Integer.MIN_VALUE) {
			System.out.print("Dame entero correcto: ");
    		i = datoInt();
    	} return i;
	 }
	
}
