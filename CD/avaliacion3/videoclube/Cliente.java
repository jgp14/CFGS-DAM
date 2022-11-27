package videoclube;

public class Cliente {

    private String nome;
    private String dni;
    private String enderezo;
    private String localidade;
    private String provincia;
    private String cpostal;
    private float saldoConta;

    public Cliente(String nome, String dni, 
    		String enderezo, String localidade, 
    		String provincia, String cpostal, float saldoConta) {
        this.nome = nome;
        this.dni = dni;
        this.enderezo = enderezo;
        this.localidade = localidade;
        this.provincia = provincia;
        this.cpostal = cpostal;
        this.saldoConta = saldoConta;
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

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCpostal() {
		return cpostal;
	}

	public void setCpostal(String cpostal) {
		this.cpostal = cpostal;
	}

	public float getSaldoConta() {
		return saldoConta;
	}

	public void setSaldoConta(float saldoConta) {
		this.saldoConta = saldoConta;
	}

    
}
