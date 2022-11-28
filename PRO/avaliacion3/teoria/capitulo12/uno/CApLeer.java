package teoria.capitulo12.uno;

import misClases.teoria.Leer;

public class CApLeer {

	public static void main(String[] args) {
		char car = 0, cero = '0', nueve = '9', 
				menos = '-', mas = '+';
		String s = null;
		double d = 0.0;
		
		System.out.print("dato: ");
		if((car = Leer.mirar()) >= cero && car <= nueve 
				|| car == menos || car == mas) 
			d = Leer.datoDouble();
		else 
			s = Leer.dato();
		if(s != null)
			System.out.println("Un String: " + s);
		else
			System.out.println("Un Double: " + d);
	}

}
