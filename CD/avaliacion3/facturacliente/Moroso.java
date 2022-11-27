package facturacliente;

import java.util.Date;

public class Moroso extends Fisicacliente{

	private float debeda;
	private Date dataCobro;
	
	public Moroso(String nome, String enderezo, String localidade, String dni, float limiteCredito, float debeda,
			Date dataCobro) {
		super(nome, enderezo, localidade, dni, limiteCredito);
		this.debeda = debeda;
		this.dataCobro = dataCobro;
	}
	
}
