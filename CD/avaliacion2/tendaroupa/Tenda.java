package tendaroupa;

public class Tenda {
	
	private Cliente cliente;
	private double capital;
	
	public Tenda(Cliente cliente, double capital) {
		super();
		this.cliente = cliente;
		this.capital = capital;
	}
	
	public double getCapital() {
		return capital;
	}
	
	public void setCapital() {
		Cliente cliente = this.cliente;
		this.capital = this.capital + cliente.getImporte();
	}
}
