package inmobiliaria;

public class Propiedade {

    private String referenciaCatastral;
    private String enderezo;
    private String localidade;
    private String cPostal;
    private String provincia;

    public Propiedade(String referenciaCatastral, String enderezo, String localidade, String cPostal, String provincia) {
        this.referenciaCatastral = referenciaCatastral;
        this.enderezo = enderezo;
        this.localidade = localidade;
        this.cPostal = cPostal;
        this.provincia = provincia;
    }

	public String getReferenciaCatastral() {
		return referenciaCatastral;
	}

	public void setReferenciaCatastral(String referenciaCatastral) {
		this.referenciaCatastral = referenciaCatastral;
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

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

    
}
