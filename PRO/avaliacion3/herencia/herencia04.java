package herencia;

import misClases.avaliacion3.ClaseA;
import misClases.avaliacion3.ClaseB;
import misClases.avaliacion3.ClaseC;
import misClases.avaliacion3.ClaseD;

class herencia04 {

	public static void main(String[] args) {
		ClaseA aB, aC, aD;
		aB = new ClaseB();
		aC = new ClaseC();
		aD = new ClaseD();
		
		System.out.println(aB.metodo_x()); // escribe -20
		System.out.println(aC.metodo_x()); // escribe -30
		System.out.println(aD.metodo_x()); // escribe -40
	}

}
