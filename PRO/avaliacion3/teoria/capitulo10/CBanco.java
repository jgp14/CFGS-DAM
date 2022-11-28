package teoria.capitulo10;

public class CBanco {
	
	private CCuenta[] clientes; // matriz de objetos
	private int nElementos; // numero de elementos de la matriz
	
	public CBanco() {
		// Crear una matriz vacia
		nElementos = 0; 
		clientes = new CCuenta[nElementos];
	}
	
	private void unElementoMas(CCuenta[] clientesActuales) {
		nElementos = clientesActuales.length;
		// Crear una matriz con un elemento mas
		clientes = new CCuenta[nElementos + 1];
		// Copiar los clientes que hay actualmente
		for(int i = 0; i < nElementos; i++)
			clientes[i] = clientesActuales[i];
		nElementos++;
	}
	
	private void unElementoMenos(CCuenta[] clientesActuales) {
		if(clientesActuales.length == 0) return;
		int k = 0;
		nElementos = clientesActuales.length;
		// Crear una matriz con un elemento menos
		clientes = new CCuenta[nElementos - 1];
		// Copiar los clientes no nulos que hay actualmente
		for(int i = 0; i < nElementos; i++)
			if(clientesActuales[i] != null)
				clientes[k++] = clientesActuales[i];
		nElementos--;
	}
	public void insertarCliente(int i, CCuenta objeto) {
		// Asignar al elemento i de la matriz, un nuevo objeto
		if(i >= 0 && i < nElementos)
			clientes[i] = objeto;
		else
			System.out.println("Indice fuera de limites");
	}
	
	public CCuenta clienteEn(int i) {
		// Devolver la referencia al objeto i de la matriz
		if(i >= 0 && i < nElementos)
			return clientes[i];
		else {
			System.out.println("Indice fuera de limites");
			return null;
		}
	}
	
	public int longitud() { return nElementos; }
	
	public void anhadir(CCuenta obj) {
		// Anhadir un objeto a esla matriz
		unElementoMas(clientes);
		insertarCliente(nElementos - 1, obj);
	}
	
	public boolean eliminar(String cuenta) {
		// Buscar la cuenta y eliminar el objeto
		for(int i = 0; i < nElementos; i++)
			if(cuenta.compareTo
					(clientes[i].obtenerCuenta())==0) {
				clientes[i] = null; // enviar objeto a basura
				unElementoMenos(clientes);
				return true;
			}
		return false;
	}
	
	public int buscar(String str, int pos) {
		// Buscar un objeto y devolver su poscicion 
		String nom, cuen;
		if(str == null) return -1;
		if(pos < 0) pos = 0;
		for(int i = pos; i < nElementos; i++) {
			// Buscar por el nomnre
			nom = clientes[i].obtenerNombre();
			if(nom == null) continue;
			// ¿str esta contenida en nom?
			if(nom.indexOf(str) > -1)
				return i;
			// Buscar por la cuenta
			cuen = clientes[i].obtenerCuenta();
			if(cuen == null) continue;
			// ¿str esta contenida en cuen?
			if (cuen.indexOf(str) > -1)
				return -1;
		}
		return -1;
	}
}