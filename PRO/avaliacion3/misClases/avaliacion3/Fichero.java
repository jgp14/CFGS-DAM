package misClases.avaliacion3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.StringTokenizer;

import misClases.utilidades.Leer;

public class Fichero {
	
	private File archivo;
	private String nombre;
	private String mensaje;
	
	public Fichero() {
		super();
		archivo = null;
		nombre = null;
		mensaje = "Nombre del fichero: ";
	}

	public void asignaFichero() {
		do {
			System.out.print(mensaje);
			nombre = Leer.datoString();
			archivo = new File(nombre);
		} while (!archivo.exists());	
	}
	  
	public void amosa() {
		FileReader fe = null;
		try {
			fe = new FileReader(archivo);
			int caracter;
			while ((caracter = fe.read()) != -1)
				System.out.print((char)caracter); 
		} catch (IOException e) {
			System.out.println("Error: " + e.toString());
		} finally {
			try {
				if (fe != null)
				fe.close(); 
			} catch (IOException e) {
				System.out.println("Error: " + e.toString());
			} 
		} 
	}
	
	public String dameNombre() {
		return nombre;
	}
	
	public void asignaFicheroLectura(String men) {
		mensaje = men;
		do {
			System.out.print(mensaje);
			nombre = Leer.datoString();
		    archivo = new File(nombre);
		} while (!archivo.exists());
	}
		  
	public void asignaFicheroEscritura(String men) {
		mensaje = men;
		System.out.print(mensaje);
		nombre = Leer.datoString();
		archivo = new File(nombre);
	}
		  
	public void copia(Fichero fDestino) {
		FileReader fe = null;
		FileWriter fs = null;
		int caracter;
		try {
			fe = new FileReader(archivo);
			fs = new FileWriter(fDestino.archivo);
			while ((caracter = fe.read()) != -1)
				fs.write(caracter); 
		} catch (IOException e) {
			System.out.println("Error: " + e.toString());
		} finally {
			try {
				if (fe != null)
					fe.close(); 
				if (fs != null)
					fs.close(); 
			} catch (IOException e) {
				System.out.println("Error: " + e.toString());
			} 
		} 
	}
	
	private static void menu() {
		System.out.println("\n  M E N U");
		System.out.println("  =======");
		System.out.println(" 1.- AMOSA ficheiro");
		System.out.println(" 2.- COPIA ficheiro");
		System.out.println
		(" 3.- AMOSA ficheiro (lonxitude - FINAL)");
		System.out.println
		(" 4.- AMOSA ficheiro (lonxitude - INICIO)");
		System.out.println
		(" 5.- AMOSA ficheiro (a sua linea MAIOR)");
		System.out.println
		(" 6.- AMOSA ficheiro (a sua linea MAIOR e a MENOR)");
		System.out.println
		(" 7.- AMOSA ficheiro (por palabras)");
		System.out.println(" 8.- FINAL");
	}
	
	public static int dameOpcion() {
		menu();
		int opcion = Leer.datoInt();
		return opcion;
	}
	
	public void amosaFinal() {
		FileReader fe = null;
		int caracter;
		try {
			fe = new FileReader(this.archivo);
			int i = 0;
			while ((caracter = fe.read()) != -1) {
				if ((char)caracter != '\r' && 
						(char)caracter != '\n') {
					i++;
				} else if ((char)caracter == '\r') {
					System.out.print(" --->" + i);
					i = 0;
				} 
				System.out.print((char)caracter);
			} 
	    } catch (IOException e) {
	    	System.out.println("Error: " + e.toString());
	    } finally {
	    	try {
	    		if (fe != null)
	    			fe.close(); 
	    	} catch (IOException e) {
	    		System.out.println("Error: " + e.toString());
	    	} 
	    } 
	}
	
	public void amosaInicio() {
		FileReader fe = null;
		BufferedReader fbr = null;
		String linea;
		try {
			fe = new FileReader(archivo);
			fbr = new BufferedReader(fe);
			while ((linea = fbr.readLine()) != null)
				System.out.println
				(linea.length() + " --> " + linea); 
		} catch (IOException e) {
			System.out.println("Error: " + e.toString());
		} finally {
			try {
				if (fe != null)
					fe.close(); 
				if (fbr != null)
					fbr.close(); 
			} catch (IOException e) {
				System.out.println("Error: " + e.toString());
			} 
		} 
	}
	
	public void amosaLineaMaior() {
		FileReader fe = null;
		BufferedReader fbr = null;
		String lineaMaior = null;
		int maior, lonxitude;
		try {
			fe = new FileReader(archivo);
			fbr = new BufferedReader(fe);
			maior = 0;
			if ((lineaMaior = fbr.readLine()) != null)
				maior = lineaMaior.length(); 
			String linea;
			while ((linea = fbr.readLine()) != null) {
				lonxitude = linea.length();
				if (lonxitude > maior) {
					maior = lonxitude;
					lineaMaior = linea;
				} 
			} 
			System.out.println();
			System.out.println(String.valueOf(lineaMaior.length()) + " --> " + lineaMaior);
		} catch (IOException e) {
			System.out.println("Error: " + e.toString());
		} finally {
			try {
				if (fe != null)
					fe.close(); 
			} catch (IOException e) {
				System.out.println("Error: " + e.toString());
			} 
		} 
	}
	
	public void amosaLineaMaiorMenor() {
		FileReader fe = null;
		BufferedReader fbr = null;
		String linea = null, lineaMaior = null, lineaMenor = null;
		try {
			fe = new FileReader(archivo);
			fbr = new BufferedReader(fe);
			int maior = 0;
			int menor = 0;
			if ((linea = fbr.readLine()) != null) {
				maior = linea.length();
				lineaMaior = linea;
				menor = linea.length();
				lineaMenor = linea;
			} 
			while ((linea = fbr.readLine()) != null) {
				int lonxitude = linea.length();
				if (lonxitude > maior) {
					maior = lonxitude;
					lineaMaior = linea;
				continue;
				} 
				if (lonxitude < menor) {
					menor = lonxitude;
					lineaMenor = linea;
				} 
			} 
			System.out.println();
			System.out.println(String.valueOf(lineaMaior.length()) + " --> " + lineaMaior);
			System.out.println(String.valueOf(lineaMenor.length()) + " --> " + lineaMenor);
		} catch (IOException e) {
			System.out.println("Error: " + e.toString());
		} finally {
			try {
				if (fe != null)
					fe.close(); 
			} catch (IOException e) {
				System.out.println("Error: " + e.toString());
			} 
		} 
	}
	
	public void amosaPalabras() {
		FileReader fe = null;
		BufferedReader fbr = null;
		String linea;
		StringTokenizer st;
		try {
			fe = new FileReader(archivo);
			fbr = new BufferedReader(fe);
			
			while ((linea = fbr.readLine()) != null) {
				st = new StringTokenizer(linea, ".;: ");
				while (st.hasMoreTokens())
					System.out.println(st.nextToken()); 
			} 
		} catch (IOException e) {
			System.out.println("Error: " + e.toString());
		} finally {
			try {
				if (fe != null)
					fe.close(); 
				if (fbr != null)
					fbr.close(); 
			} catch (IOException e) {
				System.out.println("Error: " + e.toString());
			} 
		} 
	}
	
	//Metodos copiados en clase
	
	public void amosaLineaMaior1() {
		FileReader fe = null;
		BufferedReader fbr = null;
		String lineaMaior = null;
		int maior, lonxitude;
		try {
			fe = new FileReader(this.archivo);
			fbr = new BufferedReader(fe);
			maior = 0;
			String linea;
			while ((linea = fbr.readLine()) != null) {
				lonxitude = linea.length();
				if (lonxitude > maior) {
					maior = lonxitude;
					lineaMaior = linea;
				} 
			} 
			System.out.println();
			System.out.println(String.valueOf(lineaMaior.length()) + " --> " + lineaMaior);
		} catch (IOException e) {
			System.out.println("Error: " + e.toString());
		} finally {
			try {
				if (fe != null)
					fe.close(); 
			} catch (IOException e) {
				System.out.println("Error: " + e.toString());
			} 
		} 
	}
	
	public void amosaLineaMaiorMenor1() {
		FileReader fe = null;
		BufferedReader fbr = null;
		String linea = null, lineaMaior = null, lineaMenor = null;
		try {
			fe = new FileReader(this.archivo);
			fbr = new BufferedReader(fe);
			int maior = 0;
			int menor = 100;
			while ((linea = fbr.readLine()) != null) {
				int lonxitude = linea.length();
				if (lonxitude > maior) {
					maior = lonxitude;
					lineaMaior = linea;
					continue;
				} 
				if (lonxitude < menor) {
					menor = lonxitude;
					lineaMenor = linea;
				} 
			} 
			System.out.println();
			System.out.println(String.valueOf(lineaMaior.length()) + " --> " + lineaMaior);
			System.out.println(String.valueOf(lineaMenor.length()) + " --> " + lineaMenor);
		} catch (IOException e) {
			System.out.println("Error: " + e.toString());
		} finally {
			try {
				if (fe != null)
					fe.close(); 
			} catch (IOException e) {
				System.out.println("Error: " + e.toString());
			} 
		} 
	}
	
	public void amosaPalabrasStream() {
		FileReader fe = null;
		StreamTokenizer fst = null;
		try {
			fe = new FileReader(this.archivo);
			fst = new StreamTokenizer(fe);
			fst.whitespaceChars(46, 46);
			while (fst.nextToken() != -1) {
				if (fst.sval != null)
					System.out.println(fst.sval); 
				} 
		} catch (IOException e) {
			System.out.println("Error: " + e.toString());
		} finally {
			try {
				if (fe != null)
					fe.close(); 
			} catch (IOException e) {
				System.out.println("Error: " + e.toString());
			} 
		} 
	}
}
