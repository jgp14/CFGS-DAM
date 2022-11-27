package empresa;

public class Director extends Empregado{

	private String categoria;
	private int complementoSalarial;
	
	public Director(String dni, String nome, 
			int salario, String departamento, 
			String categoria, int complementoSalarial) {
		super(dni, nome, salario, departamento);
		this.categoria = categoria;
		this.complementoSalarial = complementoSalarial;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getComplementoSalarial() {
		return complementoSalarial;
	}

	public void setComplementoSalarial(int complementoSalarial) {
		this.complementoSalarial = complementoSalarial;
	}
	

	@Override
	public String toString() {
		return "Director [categoria=" + categoria + 
		", complementoSalarial=" + complementoSalarial + "]";
	}

	
}
