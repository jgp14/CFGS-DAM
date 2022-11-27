package tenda;

public class Pedido {

	private String codigoPedido;
	private int cantidade;
	private Artigo[] artigos;
	private Cliente cliente;
	
	public Pedido(String codigoPedido, int cantidade, 
			Artigo[] artigos, Cliente cliente) {
		super();
		this.codigoPedido = codigoPedido;
		this.cantidade = cantidade;
		this.artigos = artigos;
		this.cliente = cliente;
	}
	
	public String getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido(String codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	public int getCantidade() {
		return cantidade;
	}

	public void setCantidade(int cantidade) {
		this.cantidade = cantidade;
	}

	public Artigo[] getArtigos() {
		return artigos;
	}

	public void setArtigos(Artigo[] artigos) {
		this.artigos = artigos;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Pedido [codigoPedido=" + codigoPedido + 
				", cantidade=" + cantidade + "]";
	}

}
