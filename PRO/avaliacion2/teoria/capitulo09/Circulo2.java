package teoria.capitulo09;

public class Circulo2 {
	
	private static double pi = 3.141592;
	private static int numCirculos;

	
	private Punto centro; 
	private double x, y;
	private double radio;
	
	protected void msgEsNegativo() {
		System.out.println("El radio es negativo. "
				+ "Se convierte a positivo");
	}
	
	public Circulo2() { //constructor sin parametros
		this(100.0, 100.0, 100.0);
	}
	
	public Circulo2 (double cx, double cy, double r) {
		//centro = new punto(cx, cy);
	
		centro = new Punto(cx, cy);
		if (r < 0) {
			msgEsNegativo();
			r = -r; 
		}
		this.radio = r;
		numCirculos++;
	}
	
	public double longCircunferencia() {
		return 2 * Math.PI * radio; 
	}
	
	public double areaCirculo() {
		return pi * radio * radio;
	}
}
