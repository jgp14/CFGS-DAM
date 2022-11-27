package factura;

public class Moroso extends Cliente{

	private int debeda;
	private boolean EstadoCobroDebeda;
	
	public Moroso(String nome, int limiteCredito, int debeda, boolean estadoCobroDebeda) {
		super(nome, limiteCredito);
		this.debeda = debeda;
		EstadoCobroDebeda = estadoCobroDebeda;
	}

	public int getDebeda() {
		return debeda;
	}

	public void setDebeda(int debeda) {
		this.debeda = debeda;
	}

	public boolean isEstadoCobroDebeda() {
		return EstadoCobroDebeda;
	}

	public void setEstadoCobroDebeda(boolean estadoCobroDebeda) {
		EstadoCobroDebeda = estadoCobroDebeda;
	}
	
	
}
