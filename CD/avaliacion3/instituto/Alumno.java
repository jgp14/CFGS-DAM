package instituto;

import java.util.Date;

public class Alumno {

    private String dni;
    private String nome;
    private Date dataNacimento;
    private String enderezo;
    private String localidade;
    private String cPostal;

    public Alumno(String dni, String nome, Date dataNacimento, String enderezo, String localidade, String cPostal) {
        this.dni = dni;
        this.nome = nome;
        this.dataNacimento = dataNacimento;
        this.enderezo = enderezo;
        this.localidade = localidade;
        this.cPostal = cPostal;
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

	public Date getDataNacimento() {
		return dataNacimento;
	}

	public void setDataNacimento(Date dataNacimento) {
		this.dataNacimento = dataNacimento;
	}

	public String getEnderezo() {
		return enderezo;
	}

	public void setEnderezo(String enderezo) {
		this.enderezo = enderezo;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getcPostal() {
		return cPostal;
	}

	public void setcPostal(String cPostal) {
		this.cPostal = cPostal;
	}
    
    
}
