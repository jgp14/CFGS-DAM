package hospital;

import java.util.Date;

public class Persoa {

	private String sexo;
	private String nome;
	private String apelidos;
	private String enderezo;
	private String NSS;
	private Date dataNac;
	
	public Persoa(String sexo, String nome, String apelidos, String enderezo, String nSS, Date dataNac) {
		super();
		this.sexo = sexo;
		this.nome = nome;
		this.apelidos = apelidos;
		this.enderezo = enderezo;
		NSS = nSS;
		this.dataNac = dataNac;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
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

	public String getEnderezo() {
		return enderezo;
	}

	public void setEnderezo(String enderezo) {
		this.enderezo = enderezo;
	}

	public String getNSS() {
		return NSS;
	}

	public void setNSS(String nSS) {
		NSS = nSS;
	}

	public Date getDataNac() {
		return dataNac;
	}

	public void setDataNac(Date dataNac) {
		this.dataNac = dataNac;
	}
	

	
}
