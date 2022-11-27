package persoahacienda;

import java.util.Date;

public class Persoa {

	private String nomeCompleto;
	private Date dataNacimiento;
	private String enderezo;
	private String cPostal;
	private String Localidade;
	private String provincia;
	
	public Persoa
	(String nomeCompleto, Date dataNacimiento, String enderezo, 
		String cPostal, String localidade,String provincia) {
		super();
		this.nomeCompleto = nomeCompleto;
		this.dataNacimiento = dataNacimiento;
		this.enderezo = enderezo;
		this.cPostal = cPostal;
		Localidade = localidade;
		this.provincia = provincia;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
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
	
}
