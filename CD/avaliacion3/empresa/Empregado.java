package empresa;

public class Empregado {

	private String dni;
	private String nome; 
	private int salario;
	private String departamento;
	
	public Empregado(String dni, String nome, 
			int salario, String departamento) {
		super();
		this.dni = dni;
		this.nome = nome;
		this.salario = salario;
		this.departamento = departamento;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	
	@Override
	public String toString() {
		return "Empregado [dni=" + dni + ", nome=" + nome + 
				", salario=" + salario + ", departamento=" + 
				departamento + "]";
	}

	
}
