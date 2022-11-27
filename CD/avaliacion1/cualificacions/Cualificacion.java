package cualificacions;

public class Cualificacion {

	private double c1;
	private double c2;
	private double t;

	public Cualificacion(double c1, double c2, double t) {
		super();
		this.c1 = c1;
		this.c2 = c2;
		this.t = t;

	}

	public double getC1() {
		return c1;
	}

	public void setC1(double c1) {
		this.c1 = c1;
	}

	public double getC2() {
		return c2;
	}

	public void setC2(double c2) {
		this.c2 = c2;
	}

	public double getT() {
		return t;
	}

	public void setT(double t) {
		this.t = t;
	}

	public double global() {
		double nota;
		if (this.t >= 5.0) {
			nota = 0.3 * this.c1 + 0.7 * this.c2;
		} else {
			nota = 0.0;
		}
		return nota;

	}

}
