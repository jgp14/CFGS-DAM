package clienteempregado;

import java.util.Date;

public class Empregado extends Persoa{

	private float salario;
	private Date dataContrato;
	private Departamento departamento;
	
	public Empregado(String nome, String dni, String localidade, int telefono, float salario, Date dataContrato,
			Departamento departamento) {
		super(nome, dni, localidade, telefono);
		this.salario = salario;
		this.dataContrato = dataContrato;
		this.departamento = departamento;
	}
	
}
