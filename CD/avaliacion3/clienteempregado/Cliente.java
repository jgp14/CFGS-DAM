package clienteempregado;

public class Cliente extends Persoa{

	private float cantidadeCredito;
	private Empresa empresa;
	
	public Cliente(String nome, String dni, String localidade, int telefono, float cantidadeCredito, Empresa empresa) {
		super(nome, dni, localidade, telefono);
		this.cantidadeCredito = cantidadeCredito;
		this.empresa = empresa;
	}
	
}
