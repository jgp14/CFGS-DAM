package pedidospcs;

public class Pedido {

	private Computadora computadora;
	private Dispositivo[] dispositivos;
	private int precioTotal;
	
	public Pedido(Computadora computadora, Dispositivo[] dispositivos, int precioTotal) {
		super();
		this.computadora = computadora;
		this.dispositivos = dispositivos;
		this.precioTotal = precioTotal;
	}

	public Computadora getComputadora() {
		return computadora;
	}

	public void setComputadora(Computadora computadora) {
		this.computadora = computadora;
	}

	public Dispositivo[] getDispositivos() {
		return dispositivos;
	}

	public void setDispositivos(Dispositivo[] dispositivos) {
		this.dispositivos = dispositivos;
	}

	public int getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(int precioTotal) {
		this.precioTotal = precioTotal;
	}
	
}
