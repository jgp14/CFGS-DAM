package bibliotecafondo;

import java.util.Date;

public class Autor {

	private String nome;
	private Date dataNac;
	private String nacionalidade;
	
	public Autor(String nome, Date dataNac, String nacionalidade) {
		super();
		this.nome = nome;
		this.dataNac = dataNac;
		this.nacionalidade = nacionalidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNac() {
		return dataNac;
	}

	public void setDataNac(Date dataNac) {
		this.dataNac = dataNac;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	
	
	
}
