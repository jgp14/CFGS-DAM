package cualificacions;

public class CualificacionCD {

	private double proba1;
	private double proba2;
	private double proba3;
	private double proxecto;
	private double notafinal;
	
	public CualificacionCD(double proba1, double proba2, double proba3, double proxecto, double notafinal) {
		super();
		this.proba1 = proba1;
		this.proba2 = proba2;
		this.proba3 = proba3;
		this.proxecto = proxecto;
		this.notafinal = notafinal;
	}

	public double getProba1() {
		return proba1;
	}

	public void setProba1(double proba1) {
		this.proba1 = proba1;
	}

	public double getProba2() {
		return proba2;
	}

	public void setProba2(double proba2) {
		this.proba2 = proba2;
	}

	public double getProba3() {
		return proba3;
	}

	public void setProba3(double proba3) {
		this.proba3 = proba3;
	}

	public double getProxecto() {
		return proxecto;
	}

	public void setProxecto(double proxecto) {
		this.proxecto = proxecto;
	}

	public double getNotafinal() {
		return notafinal;
	}

	public void setNotafinal(double notafinal) {
		this.notafinal = notafinal;
	}

	
	private double proxectoAprobado() {
		if (getProxecto() >= 5) {
			notafinal = ((getProba1() + getProba2() + getProba3())/3) * 0.4 + getProxecto() * 0.6;
		}
		return notafinal;
	}
	
	private double proxectoReprobado() {
		if(getProxecto() < 5) {
			if(getProba1() >= 5 && getProba2() >= 5 && getProba3() >= 5) {
				notafinal = ((getProba1() + getProba2() + getProba3())/3) * 0.4;
			}
			else if(getProba1() > getProba2() && getProba1() > getProba3()){
				notafinal = getProba1();				
			}
			else if(getProba2() > getProba1() && getProba2() > getProba3()){
				notafinal = getProba2();				
			}
			else if(getProba3() > getProba1() && getProba3() > getProba2()){
				notafinal = getProba3();				
			}
		}
		return notafinal;
	}
	
	public double calcularNotaFinal() {
		
		proxectoAprobado();
		
		proxectoReprobado();

		return notafinal;
	}
	
	@Override
	public String toString() {
		return "CualificacionCD [proba1=" + proba1 + ", proba2=" + proba2 + ", proba3=" + proba3 + ", proxecto="
				+ proxecto + ", notafinal=" + notafinal + "]";
	}
}
