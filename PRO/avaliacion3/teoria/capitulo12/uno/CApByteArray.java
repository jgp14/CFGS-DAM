package teoria.capitulo12.uno;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class CApByteArray {

	public static void main(String[] args) throws IOException {
		byte[] m1 = new byte[80];
		byte[] m2 = null;
		ByteArrayInputStream flujoE = null;
		ByteArrayOutputStream flujoS = null;
		//String Matriz1;
		//String Matriz2;
		int car, i = 0;
		
		for(car = 'a'; car <= 'z'; car++) {
			m1[i++] = (byte)car;
		}
		
		flujoE = new ByteArrayInputStream(m1);
		flujoS = new ByteArrayOutputStream();
		
		try {
			// Leer de flujoE y escribir en flujoS
			while((car = flujoE.read()) != -1)
				flujoS.write(car);
			
			// Copiar en m1 los datos enviados al flujoS
			m1 = flujoS.toByteArray();
			System.out.println("Matriz (m1): ");
			for(i = 0; i < m1.length;i++)
				System.out.print((char)m1[i]);
			
			// Copiar en m2 los datos enviados al flujoS
			m2 = flujoS.toByteArray();
			System.out.println("\n\nMatriz (m2): ");
			for(i = 0; i < m2.length;i++)
				System.out.print((char)m2[i]);
		} finally {
			// Cerrar los flujos 
			flujoE.close();
			flujoS.close();
		}
	}

}
