package teoria.capitulo10;

public class ClaseA {
	
	public int atributo_x = 1;
	
	public int metodo_x() {
		return atributo_x * 10;
	}
	
	public int metodo_y() {
		return atributo_x + 100;
	}
	
	protected void finalize() throws Throwable { // destructor
		System.out.println("Recursos de ClaseA liberados");
	}
}

