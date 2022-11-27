package teoria.capitulo05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CTestFloat {

	public static void main(String[] args) {
		
		float dato;
		
		System.out.println("Dame float: ");
		dato = Float.parseFloat(dato());
		System.out.println(dato);
	}
	
	static String dato() {
		String sdato ="";
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader flujoE = new BufferedReader(isr);
			sdato = flujoE.readLine();
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
		return sdato;
	}
}
