package restaurante;

import java.util.Date;

public class Cliente extends Persoa{

	private String localidade;
	private Date dataVisita;
	
	public Cliente(String nome, String enderezo, String localidade, Date dataVisita) {
		super(nome, enderezo);
		this.localidade = localidade;
		this.dataVisita = dataVisita;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public Date getDataVisita() {
		return dataVisita;
	}

	public void setDataVisita(Date dataVisita) {
		this.dataVisita = dataVisita;
	}
	
	
}
