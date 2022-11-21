package ud1_boletin7;

import java.io.*;

public class LanzaComando {
					
	public static void main(String[] args) {		
		Runtime r = Runtime.getRuntime();		
		Process p = null;
		String ruta = "/media/user/KIOXIA/DAM/PSP/avaliacion1/src/ud1_boletin7/";
		//String ruta = "H:\\DAM\\PSP\\avaliacion1\\src\\ud2_boletin7\\";
		String comando = "java "+ruta+"MostraNome.java Jaime";
		
		try {
			p = r.exec(comando);
			InputStream is = p.getInputStream();
			BufferedReader br = new BufferedReader
					(new InputStreamReader(is));
			String linea;
			System.out.println("Linea: "+ br.readLine());
			while((linea = br.readLine()) != null)
					System.out.println(linea);
			br.close();
		} catch(Exception e){
			e.printStackTrace();
		}
		
		//Comprobacoin de error - o bien -1 mal
		int exitVal;
		try {
			exitVal = p.waitFor();
			System.out.println("Valor de salida: "+exitVal);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}	

}
