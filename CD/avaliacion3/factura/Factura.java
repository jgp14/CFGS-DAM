package factura;

public class Factura {

	private int importe;
	private String dataEmision;
	private Emisor emisor;
	private Cliente cliente;
	
	public Factura(int importe, String dataEmision, Emisor emisor, Cliente cliente) {
		super();
		this.importe = importe;
		this.dataEmision = dataEmision;
		this.emisor = emisor;
		this.cliente = cliente;
	}

	public int getImporte() {
		return importe;
	}

	public void setImporte(int importe) {
		this.importe = importe;
	}

	public String getDataEmision() {
		return dataEmision;
	}

	public void setDataEmision(String dataEmision) {
		this.dataEmision = dataEmision;
	}

	public Emisor getEmisor() {
		return emisor;
	}

	public void setEmisor(Emisor emisor) {
		this.emisor = emisor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
