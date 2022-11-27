package persoa;

import java.util.Date;

public class Persoa {

	private String dni;
	private String nome;
	private String apelidos;
	private Date dataNacimiento;
	private String enderezo;
	private String cPostal;
	private String Localidade;
	private String provincia;
	private double bonificacion;
	
	
	public Persoa(String dni, String nome, String apelidos, 
		Date dataNacimiento, String enderezo, 
		String cPostal, String localidade, String provincia) {
		super();
		this.dni = dni;
		this.nome = nome;
		this.apelidos = apelidos;
		this.dataNacimiento = dataNacimiento;
		this.enderezo = enderezo;
		this.cPostal = cPostal;
		Localidade = localidade;
		this.provincia = provincia;
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
	public String getApelidos() {
		return apelidos;
	}
	public void setApelidos(String apelidos) {
		this.apelidos = apelidos;
	}
	public Date getDataNacimiento() {
		return dataNacimiento;
	}
	public void setDataNacimiento(Date dataNacimiento) {
		this.dataNacimiento = dataNacimiento;
	}
	public String getEnderezo() {
		return enderezo;
	}
	public void setEnderezo(String enderezo) {
		this.enderezo = enderezo;
	}
	public String getcPostal() {
		return cPostal;
	}
	public void setcPostal(String cPostal) {
		this.cPostal = cPostal;
	}
	public String getLocalidade() {
		return Localidade;
	}
	public void setLocalidade(String localidade) {
		Localidade = localidade;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	

	@Override
	public String toString() {
		return "Persoa [dni=" + dni + ", nome=" + nome + 
				", apelidos=" + apelidos + ", dataNacimiento=" 
				+ dataNacimiento + ", enderezo=" + enderezo + 
				", cPostal=" + cPostal + ", Localidade=" + 
				Localidade + ", provincia=" + provincia + 
				", getBonificacion()=" + getBonificacion() + "]";
	}

	private double calculaBonificacion() {
		double valor = 0.0;
		String cp = "15940";
		if(this.cPostal == cp) {
			valor = 100.0;			
		} else {
			valor = 0.0;
		}
		return valor;
	}
		
	public double getBonificacion() {
		this.bonificacion = calculaBonificacion();
		return this.bonificacion;
	}
	
}
