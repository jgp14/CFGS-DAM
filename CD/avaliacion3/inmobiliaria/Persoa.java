package inmobiliaria;

import java.util.Date;

public class Persoa {
    private String nome;
    private String dni;
    private String telefono;
    private String localidade;
    private String enderezo;
    private String cposta;
    private Date dataAlta;

    public Persoa(String nome, String dni, String telefono, String localidade, String enderezo, String cposta, Date dataAlta) {
        this.nome = nome;
        this.dni = dni;
        this.telefono = telefono;
        this.localidade = localidade;
        this.enderezo = enderezo;
        this.cposta = cposta;
        this.dataAlta = dataAlta;
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getEnderezo() {
		return enderezo;
	}

	public void setEnderezo(String enderezo) {
		this.enderezo = enderezo;
	}

	public String getCposta() {
		return cposta;
	}

	public void setCposta(String cposta) {
		this.cposta = cposta;
	}

	public Date getDataAlta() {
		return dataAlta;
	}

	public void setDataAlta(Date dataAlta) {
		this.dataAlta = dataAlta;
	}


}
