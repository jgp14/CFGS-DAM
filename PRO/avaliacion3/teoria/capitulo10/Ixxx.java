package teoria.capitulo10;

public interface Ixxx {

	public abstract void m(); // metodo m
	public abstract void p(); // metodo p
	
	public class Clase1 implements Ixxx{
		public void m() {
			System.out.println("metodo m de Clase1");
		}
		public void p() { }
	}
	
	public class Clase2 implements Ixxx{
		public void m() {
			System.out.println("metodo m de Clase2");
		}
		public void p() {}
	}
	
	public class Clase3 implements Ixxx{
		public void m() {
			System.out.println("metodo m de Clase3");
		}
		public void p() {}
	}
	
	public class Test{
		public static void main (String[] args) {
			Ixxx[] objs = new Ixxx[3]; 
			// matriz de referencias a objetos
			objs[0] = new Clase1();
			objs[1] = new Clase2();
			objs[2] = new Clase3();
			for(int i = 0; i < objs.length; i++)
				objs[i].m(); // invoca al metodo m del 
				// objeto Clase1, Clase2 o Clase3 
				// referenciado por objs[i]
		}
	}
}
