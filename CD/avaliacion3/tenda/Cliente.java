package tenda;

public class Cliente {

	private String codigoCliente;
	private String nome;
	private String enderezo;
	private String cPostal;
	
	public Cliente
	(String codigoCliente, String nomeCompleto,
			String enderezoCompleto, String cPostal) {
		super();
		this.codigoCliente = codigoCliente;
		this.nome = nomeCompleto;
		this.enderezo = enderezoCompleto;
		this.cPostal = cPostal;
	}

	@Override
	public String toString() {
		return "Cliente [codigoCliente=" + codigoCliente + 
				", nome=" + nome + 
				", enderezo=" + enderezo + 
				", cPostal=" + cPostal + "]";
	}

	public String getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
	
	
}
