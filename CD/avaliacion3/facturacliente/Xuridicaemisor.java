package facturacliente;

public class Xuridicaemisor extends Persoa{

	private String codigofiscal;

	public Xuridicaemisor(String nome, String enderezo, String localidade, String codigofiscal) {
		super(nome, enderezo, localidade);
		this.codigofiscal = codigofiscal;
	}
	
}
