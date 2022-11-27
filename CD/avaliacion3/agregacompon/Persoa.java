package agregacompon;

import java.util.Date;

public class Persoa{
	private String dni;
	private String nome;
	private String apelidos;
	private Date dataNacimiento;
	private String enderezo;
	private int cPostal;
	
	public Persoa(String dni, String nome, String apelidos, Date dataNacimiento, String enderezo, int cPostal) {
		super();
		this.dni = dni;
		this.nome = nome;
		this.apelidos = apelidos;
		this.dataNacimiento = dataNacimiento;
		this.enderezo = enderezo;
		this.cPostal = cPostal;
	}

	@Override
	public String toString() {
		return "Persoa [dni=" + dni + ", nome=" + nome + ", apelidos=" + apelidos + ", dataNacimiento="
				+ dataNacimiento + ", enderezo=" + enderezo + ", cPostal=" + cPostal + "]";
	}
}
