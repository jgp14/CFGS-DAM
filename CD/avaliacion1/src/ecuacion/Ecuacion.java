package ecuacion;

public class Ecuacion {
	
	private double a;
	private double b;
	private double c;
	
	public double getA() {
		return a;
	}
	public void setA(double a) {
		this.a = a;
	}
	public double getB() {
		return b;
	}
	public void setB(double b) {
		this.b = b;
	}
	public double getC() {
		return c;
	}
	public void setC(double c) {
		this.c = c;
	}
	
	/*private boolean verificar() {
		if(b * b > 4 * a * c) {
			return true;
		} else {
			return false;
		}*
	}*/
	
	private double calcular() {
			return Math.sqrt(b * b - 4 * a * c);
	}
	
	public double x1() {
		return (-b + this.calcular())/(2*a);
	}
	public double x2() {
		return (-b - this.calcular())/(2*a);
	}
}
