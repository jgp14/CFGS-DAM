package misClases.teoria;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class CListaTfnos8 {

	private RandomAccessFile fes;
	private int nregs;  
	private int tamanhoReg = 140;
	  
	public CListaTfnos8(File fichero) throws IOException {
	    if (fichero.exists() && !fichero.isFile())
	    	throw new IOException(fichero.getName() 
	    			+ " no es un fichero"); 
	    fes = new RandomAccessFile(fichero, "rw");
	    nregs = (int)Math.ceil(fes.length() / tamanhoReg);
	}
	  
	public void cerrar() throws IOException {
		fes.close();
	}
	  
	public int longitud() {
		return nregs;
	}
	  
	public boolean ponerValorEn(int i, CPersona objeto) 
			throws IOException {
		if (i >= 0 && i <= nregs) {
			if (objeto.tamanho() + 4 > tamanhoReg) {
				System.err.println("tamadel registro excedido");
			} else {
			    fes.seek((i * tamanhoReg));
			    fes.writeUTF(objeto.obtenerNombre());
			    fes.writeUTF(objeto.obtenerDireccion());
			    fes.writeLong(objeto.obtenerTelefono());
			    return true;
			} 
		} else {
			System.err.println
			("numero de registro fuera de limite");
	    } 
	    return false;
	}
	  
	public CPersona valorEn(int i) throws IOException {
		if (i >= 0 && i < nregs) {
			fes.seek((i * tamanhoReg));
			String nombre = fes.readUTF();
			String direccion = fes.readUTF();
			long telefono = fes.readLong();
			return new CPersona(nombre, direccion, telefono);
		} 
		System.out.println
		("numero de registro fuera de limite");
		return null;
	}
	  
	public void anhadir(CPersona obj) throws IOException {
		if (ponerValorEn(nregs, obj))
			nregs++; 
	}
	  
	public boolean eliminar(long tel) throws IOException {
		for (int reg_i = 0; reg_i < nregs; reg_i++) {
			CPersona obj = valorEn(reg_i);
			if (obj.obtenerTelefono() == tel) {
		        obj.asignarTelefono(0L);
		        ponerValorEn(reg_i, obj);
		        return true;
			} 
	    } 
	    return false;
	}
	  
	public int buscar(String str, int pos) throws IOException {
		if (str == null)
			return -1; 
		if (pos < 0)
			pos = 0; 
		for (int reg_i = pos; reg_i < nregs; reg_i++) {
			CPersona obj = valorEn(reg_i);
			String nom = obj.obtenerNombre();
			if (nom.indexOf(str) > -1)
				return reg_i; 
		} 
		return -1;
	}
	  
	public void mostrarListaTfnos() throws IOException {
		if (nregs >= 0) {
			for (int i = 0; i < nregs; i++) {
				CPersona obj = valorEn(i);
				obj.mostrar();
			} 
		} else {
			System.out.println("Indice fuera de limites");
	    } 
	}
	
}
