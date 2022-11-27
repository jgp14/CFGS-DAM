package factura;

public class Emisor {

	private String nome;
	private String codigoFiscal;
	
	public Emisor(String nome, String codigoFiscal) {
		super();
		this.nome = nome;
		this.codigoFiscal = codigoFiscal;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigoFiscal() {
		return codigoFiscal;
	}

	public void setCodigoFiscal(String codigoFiscal) {
		this.codigoFiscal = codigoFiscal;
	}
	
	
}
