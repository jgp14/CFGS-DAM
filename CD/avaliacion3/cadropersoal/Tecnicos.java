package cadropersoal;

public class Tecnicos extends Persoal{

	int dieta;

	public Tecnicos(String dni, String nome, int salario, int nivel, int dieta) {
		super(dni, nome, salario, nivel);
		this.dieta = dieta;
	}

	public int getDieta() {
		return dieta;
	}

	public void setDieta(int dieta) {
		this.dieta = dieta;
	}
	
}
