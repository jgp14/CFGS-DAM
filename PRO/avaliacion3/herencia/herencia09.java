package herencia;

import misClases.avaliacion3.ClaseA;
import misClases.avaliacion3.ClaseD;

class herencia09 {

	public static void main(String[] args) {
		
		ClaseA claseA = new ClaseD();
	    System.out.println(claseA.metodo_y());
	    System.out.println(claseA.metodo_x());
	    System.out.println(((ClaseD)claseA).metodo_x(10));
	}

}
