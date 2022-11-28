package teoria.capitulo12;

import java.io.File;

public class CApTest4A {

	public static void main(String[] args) {
		File dir = new File("dos");
		File fichero = new File("dos", "proba.txt");
		
		System.out.println
		("Nombre del fichero: " + fichero.getName());
		System.out.println
		("Dicrectorio padre:  " + fichero.getParent());
		System.out.println("Ruta : " + fichero.getPath());
		System.out.println
		("Nombre del fichero: " + fichero.getAbsolutePath());
	}

}
