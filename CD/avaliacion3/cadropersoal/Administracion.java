package cadropersoal;

public class Administracion extends Persoal{

	private int incentivo;

	public Administracion(String dni, String nome, int salario, int nivel, int incentivo) {
		super(dni, nome, salario, nivel);
		this.incentivo = incentivo;
	}

	public int getIncentivo() {
		return incentivo;
	}

	public void setIncentivo(int incentivo) {
		this.incentivo = incentivo;
	}
	
}
