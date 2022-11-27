package teoria.capitulo05;

import java.io.*;

public class CTest {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader flujoE = new BufferedReader(isr);
		PrintStream flujoS = System.out;
				
		String sdato;
		float precio = 0.0F;
		try {
			flujoS.print("Precio: ");
			sdato = flujoE.readLine();
		
			if(sdato == null)
				throw new IOException();
		
			precio = (sdato != null)
					? (new Float(sdato)).floatValue()
						: Float.NaN;
				
		}catch (IOException ignorada) {
			System.out.println("\nSalta excepcion IO");
		}catch (NumberFormatException ignorada) {
			System.out.println("Salta excepcion NUMBER");
		}
		flujoS.println(precio);
		flujoS.println("Continua la aplicacion");
	}
}
