package teoria.capitulo12.uno;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;

public class CApCharArray {

	public static void main(String[] args) {
		char[] m1 = new char[80];
		char[] m2 = new char[80];
		int car, i = 0;
		
		// Almacenar datos en la matriz m1
		for(car = 'a'; car <= 'z'; car++)
			m1[i++] = (char)car;
		
		// Abrir un flujo, fujoE, desde la matriz m1
		CharArrayReader flujoE = new CharArrayReader(m1);
		// Abrir un flujo. flujoS. hacia una matriz temporal
		CharArrayWriter flujoS = new CharArrayWriter();
		try {
			// Leer de flujoE y escribir en flujoS
			while((car = flujoE.read()) != -1)
				flujoS.write(car);
			
			// Copiar en m1 los datos enviados al flujoS
			m1 = flujoS.toCharArray();
			System.out.println("Matriz (m1): ");
			System.out.println(m1);
			
			// Copiar en m2 los datos enviados al flujoS
			m2 = flujoS.toCharArray();
			System.out.println("\nMatriz (m2): ");
			System.out.println(m2);
		} catch(IOException e) {
			System.out.println(e.getMessage());
		} finally {
			// Cerrar los flujos 
			flujoE.close();
			flujoS.close();
		}
	}
}
