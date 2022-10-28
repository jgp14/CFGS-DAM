package ud2_boletin8;

import java.io.*;

public class Aleatorios {

	public static void main(String[] args) {
		Runtime runTime = Runtime.getRuntime();
		Process process = null;
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String cadena = "";
		String rutaLin = "/media/user/KIOXIA/DAM/PSP/avaliacion1/src/ud2_boletin8/";
		//String rutaWin = "H:\\DAM\\PSP\\avaliacion1\\src\\ud2_boletin8\\";
		String comando = "java "+rutaLin+"AleatoriosHijo.java";
		
		try {
			System.out.println("Introduzca una linea");
			cadena = br.readLine();
			while(!cadena.equals("fin")) {
				System.out.println("Sigue leyendo");
				process = runTime.exec(comando);
				BufferedReader in = new BufferedReader
						(new InputStreamReader(process.getInputStream()));
				System.out.println(in.readLine());
				System.out.println("Introduzca una linea");
				cadena = br.readLine();
			}
		}catch(IOException e) {
			System.out.println("Error de entrada-salida");
			System.exit(-1);
		}
		
		try {
			process.waitFor();
		} catch(InterruptedException e) {
			System.out.println("No pudimos esperar por termino");
			System.exit(-1);
		}
	}

}
