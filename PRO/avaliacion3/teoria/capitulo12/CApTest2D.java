package teoria.capitulo12;

public class CApTest2D {

	public static void main(String[] args) {
		
		char car, cero = '0', nueve ='9', menos = '-', mas='+';
		String s = null;
		double d = 0.0;
		
		System.out.println("dato: ");
		if((car = Leer.mirar()) >= cero && car <= nueve || 
				car == menos || car == mas)
			d = Leer.datoDouble();
		else
			s = Leer.dato();
		
		//continua mas
		
	}
	
}
