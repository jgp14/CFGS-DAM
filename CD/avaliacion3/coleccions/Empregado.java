package coleccions;

import java.util.Date;

public class Empregado {

	String nome;
	String dni;
	Date dataAlata;
	int salario;
	
	public Empregado
	(String nome, String dni, Date dataAlata, int salario) {
		super();
		this.nome = nome;
		this.dni = dni;
		this.dataAlata = dataAlata;
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Empregado [nome=" + nome + 
				", dni=" + dni + ", dataAlata=" + dataAlata + 
				", salario=" + salario + "]";
	}
	
	
}
