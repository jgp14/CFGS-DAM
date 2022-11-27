package partido;

public class Xogador {
    private String dni;
    private String nome;
    private String numLicenza;
    private String nacionalidade;

    public Xogador(String dni, String nome, String numLicenza, String nacionalidade) {
        this.dni = dni;
        this.nome = nome;
        this.numLicenza = numLicenza;
        this.nacionalidade = nacionalidade;
    }
    
    //getters & setters
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

	public String getNumLicenza() {
		return numLicenza;
	}

	public void setNumLicenza(String numLicenza) {
		this.numLicenza = numLicenza;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
    
}
