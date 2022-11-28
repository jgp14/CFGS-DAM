package teoria.capitulo10;

interface Interfaz {

	public abstract void p();
	public abstract void m();
}

class Clase2{
	private int i;
	// ...
	public Interfaz metClase2() {// metodo de la clase 2
		return new Clase3();
	}
	class Clase3 implements Interfaz{
		public void p() { System.out.println("metodo p");}
		public void m() { System.out.println("metodo m");}
	}
}

public class Clase11{
	public static void main (String[] args) {
		Clase2 obj = new Clase2();
		Interfaz iobj = obj.metClase2(); 
		// devuelve un objeto Clase3
		iobj.m();
	}
}