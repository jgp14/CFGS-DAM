package factura;

public class Cliente {

	private String nome;
	private int limiteCredito;
	
	public Cliente(String nome, int limiteCredito) {
		super();
		this.nome = nome;
		this.limiteCredito = limiteCredito;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(int limiteCredito) {
		this.limiteCredito = limiteCredito;
	}
	
	
}
