package herencia;

import misClases.avaliacion3.ClaseA;
import misClases.avaliacion3.ClaseB;
import misClases.avaliacion3.ClaseC;
import misClases.avaliacion3.ClaseD;

class herencia06 {

	public static void main(String[] args) {
		ClaseA[] a = new ClaseA[3];
		a[0] = new ClaseB();
		a[1] = new ClaseC();
		a[2] = new ClaseD();
		for (int i = a.length - 1; i >= 0; i--)
			System.out.println(a[i].metodo_x()); 
	}

}
