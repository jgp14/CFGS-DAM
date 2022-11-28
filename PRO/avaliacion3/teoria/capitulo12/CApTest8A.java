package teoria.capitulo12;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class CApTest8A {

	public static void main(String[] args) {
		PrintStream flujoS = System.out;
		FileOutputStream fos;
		long telefono;
		
		try {
			fos = new FileOutputStream("datos8.txt");
			
		} catch (IOException e){
			System.out.println("Error: " + e.getMessage());
		}
	}

}
