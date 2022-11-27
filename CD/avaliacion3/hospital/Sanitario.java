package hospital;

import java.util.Date;

public class Sanitario extends Persoa{

	private String cod_emp;
	private int salario;
	private int antiguedade;

	public Sanitario(String sexo, String nome, String apelidos, String enderezo, String nSS, Date dataNac,
			String cod_emp, int salario, int antiguedade) {
		super(sexo, nome, apelidos, enderezo, nSS, dataNac);
		this.cod_emp = cod_emp;
		this.salario = salario;
		this.antiguedade = antiguedade;
	}

	public String getCod_emp() {
		return cod_emp;
	}

	public void setCod_emp(String cod_emp) {
		this.cod_emp = cod_emp;
	}

	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}

	public int getAntiguedade() {
		return antiguedade;
	}

	public void setAntiguedade(int antiguedade) {
		this.antiguedade = antiguedade;
	}
	
	
}
