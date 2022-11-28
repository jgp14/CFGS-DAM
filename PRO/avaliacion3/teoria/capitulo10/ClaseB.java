package teoria.capitulo10;

public class ClaseB extends ClaseA {
	
	protected int atributo_x = 2;
	
	public int metodo_x() {
		//System.out.println("ClaseB metodoX");
		return atributo_x * -10;
	}
	
	public int metodo_z() {
		atributo_x = super.atributo_x + 3;
		return super.metodo_x() + atributo_x;
	}
	
	protected void finalize() throws Throwable { // destructor
		System.out.println("Recursos de ClaseB liberados");
		super.finalize();
	}
}
