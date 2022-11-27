package misClases.teoria;

import teoria.capitulo09.Punto;

public class CCirculo {

	private CPunto centro; 
	private double radio;
	private static double pi = 3.141592D;
	public static int numCirculos;
	public static double[] seno = new double[360];
	public static double[] coseno = new double[360];
	
	static {
		//Tablas del seno y coseno de grado en grado
		for (int i = 0; i < 360; i++) {
			double s, c; 
			// Calcular el seno y el coseno de i 
			s = Math.sin(Math.toRadians(i));
			c = Math.cos(Math.toRadians(i));
			// Almacenar los valores redondeados a 6 dec
			seno[i] = Math.rint(s*1000000.0D)/1000000.0D;
			coseno[i] = Math.rint(c*1000000.0D)/1000000.0D;
		}
	}
	
	public CCirculo() { //constructor sin parametros
		this(100.0D, 100.0D, 100.0D);
	}
	
	public CCirculo (double cx, double cy, double r) {
		//centro = new punto(cx, cy);
	
		centro = new CPunto(cx, cy);
		if (r < 0.0D) {
			msgEsNegativo();
			r = -r; 
		}
		this.radio = r;
		numCirculos++;
	}
	
	protected void msgEsNegativo() {
		System.out.println("El radio es negativo. "
				+ "Se convierte a positivo");
	}
	
	public double longCircunferencia() {
		return 2 * pi * radio; 
	}
	
	public double areaCirculo() {
		return pi * radio * radio;
	}
	
	public static void cambiarPrecisionPiA(double nuevoValor) {
		if(nuevoValor < 3.14D || nuevoValor > 3.1416D) return;
		pi = nuevoValor;
	}
	
	public static double damePi() {
		return pi;
	}

	public static double getSeno(int i) {
		return seno[i];
	}

	public static double getCoseno(int i) {
		return coseno[i];
	}
	
}
