package facturacliente;

public class Fisicacliente extends Persoa{

	private String dni;
	private float limiteCredito;
	
	public Fisicacliente(String nome, String enderezo, String localidade, String dni, float limiteCredito) {
		super(nome, enderezo, localidade);
		this.dni = dni;
		this.limiteCredito = limiteCredito;
	}
	
}
