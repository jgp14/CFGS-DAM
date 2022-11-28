package teoria.capitulo12;

import java.io.*;

public class CListaTfnos2 {

	private RandomAccessFile fes; // flujo
	private int nregs;			  // numero de registros
	private int tamanoReg = 140;  
	// tamaño del registro en bytes
	
	public CListaTfnos2(File fichero) throws IOException {
		if(fichero.exists() && !fichero.isFile())
			throw new IOException(fichero.getName() 
					+ " no es un fichero");
		fes = new RandomAccessFile(fichero, "rw");
		// Como es casi seguro que el ultimo registro no 
		// ocupe el tamaño fijado, utilizamos ceir para 
		// redondear por encima. 
		nregs = (int) Math.ceil
				((double)fes.length() / (double)tamanoReg);
	}
	public void cerrar() throws IOException {fes.close();}
	public int longitud() {return nregs;} // numero registros
	
	public boolean ponerValorEn(int i, CPersona objeto)
		throws IOException{
		if(i >= 0 && i <= nregs) {
			if(objeto.tamano() + 4 > tamanoReg)
				System.err.println
				("tamaño del registro excedido");
			else {
				fes.seek(i * tamanoReg); 
				// situar el puntero de L/E
				fes.writeUTF(objeto.obtenerNombre());
				fes.writeUTF(objeto.obtenerDireccion());
				fes.writeLong(objeto.obtenerTelefono());
				return true;
			}
		}
		else
			System.err.println
			("numero de registro fuera de limites");
		return false;
	}
	
	public CPersona valorEn(int i) throws IOException{
		if(i >= 0 && i < nregs) {
			fes.seek(i * tamanoReg); 
			// situar el puntero de L/E
			
			String nombre, direccion;
			long telefono;
			nombre = fes.readUTF();
			direccion = fes.readUTF();
			telefono = fes.readLong();
			
			return new CPersona(nombre, direccion, telefono);
		}
		else {
			System.out.println
			("numero de registro fuera de limites");
			return null;
		}
	}
	
	public void anadir(CPersona obj) throws IOException{
		if(ponerValorEn(nregs, obj)) nregs++;
	}
	
	public boolean eliminar (long tel) throws IOException{
		CPersona obj;
		// Buscar el telefono y marcar el registro para
		// posteriormente eliminarlo
		for(int reg_i = 0; reg_i < nregs; reg_i++) {
			obj = valorEn(reg_i);
			if(obj.obtenerTelefono() == tel) {
				obj.asignarTelefono(0);
				ponerValorEn(reg_i, obj);
				return true;
			}
		}
		return false;
	}
	
	public int buscar(String str, int pos) throws IOException{
		// Buscar un registro por una subcadena del nombre
		// a partir de un registro determinado
		CPersona obj; 
		String nom;
		if(str == null) return -1;
		if(pos < 0) pos = 0;
		for(int reg_i = pos; reg_i < nregs; reg_i++) {
			obj = valorEn(reg_i);
			nom = obj.obtenerNombre();
			// ¿str esta contenida en nom?
			if(nom.indexOf(str) > -1) 
				return reg_i;
		}
		return -1;
	}
}