package cadropersoal;

public class Persoal {

	private String dni;
	private String nome; 
	private int salario;
	private int nivel;
	
	public Persoal(String dni, String nome, int salario, int nivel) {
		super();
		this.dni = dni;
		this.nome = nome;
		this.salario = salario;
		this.nivel = nivel;
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

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
}
