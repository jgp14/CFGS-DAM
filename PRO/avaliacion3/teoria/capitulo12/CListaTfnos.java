package teoria.capitulo12;

import java.io.Serializable;

import teoria.capitulo12.CPersona;

public class CListaTfnos implements Serializable{

	private CPersona[] listaTelefonos; // matriz objetos
	private int nElementos; // n de elementos de la matriz
	
	public CListaTfnos() {
		// Crear una lista vacia
		nElementos = 0; 
		listaTelefonos = new CPersona[nElementos];
	}// constructor
	
	private void unElementoMas (CPersona[] listaActual) {
		nElementos = listaActual.length;
		listaTelefonos = new CPersona[nElementos + 1];
		// Copiar la lista actual
		for (int i = 0; i < nElementos; i++)
			listaTelefonos[i] = listaActual[i];
		nElementos++;
	}
	
	private void unElementoMenos(CPersona[] listaActual) {
		if(listaActual.length == 0) return;
		int k = 0;
		nElementos = listaActual.length;
		listaTelefonos = new CPersona[nElementos - 1];
		// Copiar la lista actual 
		for (int i = 0; i < nElementos; i++)
			if(listaActual[i] != null)
				listaTelefonos[k++] = listaActual[i];
		nElementos--;
	}
	
	public void ponerValorEn(int i, CPersona objeto) {
		if(i >= 0 && i < nElementos)
			listaTelefonos[i] = objeto;
		else
			System.out.println("Indice fuera de limites");
	}
	
	public CPersona valorEn(int i) {
		if(i >= 0 && i < nElementos)
			return listaTelefonos[i];
		else {
			System.out.println("Indice fuera de limites");
			return null;
		}
	}
	
	public int longitud() {return nElementos;}
	
	public void anhadir(CPersona obj) {
		unElementoMas(listaTelefonos);
		ponerValorEn(nElementos - 1, obj);
	}
	
	public boolean eliminar(long tel) {
		// Buscar el telefono y eliminar registro
		for(int i = 0; i < nElementos; i++)
			if(listaTelefonos[i].obtenerTelefono() == tel) {
				listaTelefonos[i] = null;
				unElementoMenos(listaTelefonos);
				return true;
			}
		return false;
	}
	
	public int buscar(String str, int pos) {
		String nom; 
		if(str == null) return - 1;
		if(pos < 0) pos = 0;
		for(int i = pos; i < nElementos; i++) {
			nom = listaTelefonos[i].obtenerNombre();
			if(nom == null) continue;
			// ¿str esta contenida en nom?
			if(nom.indexOf(str) > -1)
				return i;
		}
		return -1;
	}
	
	public void mostrarListaTfnos() {
		if(nElementos > 0)
			for(int i = 0; i < nElementos; i++)
				listaTelefonos[i].mostrarPersona();
		//else
		/*System.out.println();
		for(int i = 0; i < nElementos; i++)
			System.out.println("Tfno"+i+": "
			+listaTelefonos[i].obtenerTelefono());*/
	}
}
