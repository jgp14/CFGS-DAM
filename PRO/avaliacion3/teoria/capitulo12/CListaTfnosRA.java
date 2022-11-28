package teoria.capitulo12;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class CListaTfnosRA {

	private RandomAccessFile fes;
	private int nregs;
	private int tamanoReg; 
	
	public CListaTfnosRA(File fichero) throws IOException{
		if(fichero.exists() && !fichero.isFile())
			throw new IOException(fichero.getName() + " es un DIRECTORIO");
		fes = new RandomAccessFile(fichero, "rw");
		nregs = (int) Math.ceil((double)fes.length());
	}
	
	public void cerrar() throws IOException{fes.close();}
	public int longitud() {return nregs;}
	
	public boolean ponerValorEn(int i, CPersona objeto) 
			throws IOException {
		boolean bool = false;
		return bool;
	}
	
	/*public CPersona valorEn(int i) throws IOException{

	}*/
	
	public void anadir(CPersona obj) throws IOException{
		
	}
	
	/*public boolean eliminar (long tel) throws IOException{
		
	}*/
	
	/*public int buscar(String str, int pos) throws IOException{
		
	}*/
	
	/*public int buscar(String str, int pos) throws IOException{
	 
	}*/
}
