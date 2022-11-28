package teoria.capitulo12;

import java.io.FileOutputStream;
import java.io.IOException;

public class CApTest3B {

	public static void main(String[] args) {
		FileOutputStream fs = null;
		byte[] buffer = new byte[81];
		int nbytes;
		
		System.out.println(fs);
		System.out.println(System.in);
		System.out.println(System.out);
		fs = null;
		
		try {
			System.out.println("Escriba el texto que desea almacenar en el fichero:");
			nbytes= System.in.read(buffer);
			//fs = new FileOutputStream("textoA.txt");
			fs = new FileOutputStream("textoA.txt",true);
			fs.write(buffer,0,nbytes);
		} catch(IOException e){
			System.out.println("Error: " + e.toString());
		} finally {
			if(fs!= null)
				// Corregir codigo 
				try {
					fs.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}

}
