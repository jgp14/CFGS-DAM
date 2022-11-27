package teoria.capitulo09;

public class Circulo {

//	private Punto centro; 
	private double x, y;	//coordenadas del centro
	private double radio;	//radio del circulo
	
	//miembros protegidos
	protected void msgEsNegativo() {
		System.out.println("El radio es negativo. "
				+ "Se convierte a positivo");
	}
	
	//miembros publicos
	public Circulo() { //constructor sin parametros	
	}
	public Circulo (double cx, double cy, double r) {
		//centro = new punto(cx, cy);
	
		x = cx; y = cy; 
		if (r < 0) {
		msgEsNegativo();
		r = -r; 
		}
		radio = r;
	}
	
	public double longCircunferencia() {
		return 2 * Math.PI * radio; 
	}
	
	public double areaCirculo() {
		return Math.PI * radio * radio;
	}
}
