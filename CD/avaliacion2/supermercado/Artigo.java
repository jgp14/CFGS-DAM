package supermercado;

public class Artigo {
	
	private int codigo;
	// O prezo debe ser sempre un valor positivo distinto de 0
	private int prezo;
	// Existencias debe ser sempre un valor positivo ou nulo
	private int existencias;
	// A cantidade que se adquire dun artigo debe ser sempre un valor positivo distinto de 0
	private int cantidade;
	// É o resultado da compra deste artigo, en función das unidades e do seu prezo
	private int importe;
	
	public Artigo(int codigo, int cantidade, int prezo, int existencias) {
		this.codigo = codigo;
		this.prezo = prezo;
		this.existencias = existencias;
		this.cantidade = cantidade;
	}


	public int getPrezo() {
		return prezo;
	}

	public int getExistencias() {
		return existencias;
	}
	
	public int getCantidade() {
		return cantidade;
	}

	public int getImporte() {
		
		// Implementa este método para que 
		//se calcule o importe total deste artigo
		importe = cantidade * prezo;
		return importe;
	}

	@Override
	public String toString() {
		return "Artigo [codigo=" + codigo + ", prezo=" 
	+ prezo + ", existencias=" + existencias + ", cantidade="
				+ cantidade + ", importe=" + importe + "]";
	}
}

