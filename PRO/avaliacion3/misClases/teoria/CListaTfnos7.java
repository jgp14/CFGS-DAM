package misClases.teoria;

import java.io.Serializable;

public class CListaTfnos7 implements Serializable{
	private int nElementos = 0;
	private CPersona[] listaTelefonos = new CPersona[nElementos];
	private static final long serialVersionUID = 1L;
	

	private void unElementoMas(CPersona[] listaActual) {
		nElementos = listaActual.length;
	    listaTelefonos = new CPersona[nElementos + 1];
	    for (int i = 0; i < nElementos; i++)
	    	listaTelefonos[i] = listaActual[i]; 
	    nElementos++;
	}
	  
	private void unElementoMenos(CPersona[] listaActual) {
		if (listaActual.length == 0)
			return; 
	    int k = 0;
	    nElementos = listaActual.length;
	    listaTelefonos = new CPersona[nElementos - 1];
	    for (int i = 0; i < nElementos; i++) {
	    	if (listaActual[i] != null)
	    		listaTelefonos[k++] = listaActual[i]; 
	    } 
	    nElementos--;
	}
	  
	public void ponerValorEn(int i, CPersona objeto) {
		if (i >= 0 && i < nElementos) {
			listaTelefonos[i] = objeto;
	    } else {
	    	System.out.println("indice fuera de limites");
	    } 
	}
	  
	public CPersona valorEn(int i) {
		if (i >= 0 && i < nElementos)
			return listaTelefonos[i]; 
	    System.out.println("indice fuera de limites");
	    return null;
	}
	  
	public int longitud() {
		return nElementos;
	}
	  
	public void anhadir(CPersona obj) {
		unElementoMas(listaTelefonos);
		ponerValorEn(nElementos - 1, obj);
	}
	  
	public boolean eliminar(long tel) {
		for (int i = 0; i < nElementos; i++) {
			if (listaTelefonos[i].obtenerTelefono() == tel) {
				listaTelefonos[i] = null;
				unElementoMenos(listaTelefonos);
				return true;
			} 
		} 
		return false;
	}
	  
	public int buscar(String str, int pos) {
		if (str == null)
			return -1; 
		if (pos < 0)
			pos = 0; 
		for (int i = pos; i < nElementos; i++) {
			String nom = listaTelefonos[i].obtenerNombre();
			if (nom != null)
				if (nom.indexOf(str) > -1)
					return i;  
		} 
		return -1;
	}
	  
	public void mostrarListaTfnos() {
		if (this.nElementos > 0) {
			for (int i = 0; i < nElementos; i++)
				listaTelefonos[i].mostrar(); 
	    } else {
	    	System.out.println("indice fuera de limites");
	    } 
	}

}
