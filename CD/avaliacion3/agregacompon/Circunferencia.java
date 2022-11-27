package agregacompon;

public class Circunferencia {

	private Punto centro;
	private int radio;
	private int circunferencia;
	private int area;
	
	public Circunferencia(Punto centro, int radio, int circunferencia, int area) {
		super();
		this.centro = centro;
		this.radio = radio;
		this.circunferencia = circunferencia;
		this.area = area;
	}

	public Punto getCentro() {
		return centro;
	}

	public void setCentro(Punto centro) {
		this.centro = centro;
	}

	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}

	public int getCircunferencia() {
		return circunferencia;
	}

	public void setCircunferencia(int circunferencia) {
		this.circunferencia = circunferencia;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}
	
	
}
