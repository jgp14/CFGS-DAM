package herencia;

import misClases.avaliacion3.ClaseA;
import misClases.avaliacion3.ClaseB;
import misClases.avaliacion3.ClaseC;
import misClases.avaliacion3.ClaseD;

class herencia05 {

	public static void main(String[] args) {
		ClaseA a;
		
		a = new ClaseB();
		System.out.println(a.metodo_x()); // escribe -20
		a = new ClaseC();
		System.out.println(a.metodo_x()); // escribe -30
		a = new ClaseD();
		System.out.println(a.metodo_x()); // escribe -40
	}

}
