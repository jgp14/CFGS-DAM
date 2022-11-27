package supermercado;

public class CarroCompra {

	private Artigo[] artigos;
	private int numArtigos;
	private int importe;

	public CarroCompra(Artigo[] artigos) {
		super();
		this.artigos = artigos;
		this.numArtigos = this.artigos.length;
	}

	public Artigo[] getArtigos() {
		return artigos; 
	}

	public int getNumArtigos() {
		return numArtigos;
	}

	public int getImporte() {
		int suma = 0;

		for (Artigo artigo : artigos) {
			suma = suma + artigo.getImporte();
			//completa o método para que calcule o 
			//importe dos artigos do carro
		}

		this.importe = suma;
		return this.importe;
	}
	
	public void listaCompra() {

	// Implementa este método para que liste todos os produtos que están no carro
		for (Artigo artigo : artigos) {
			System.out.println(artigo.toString());
		}
	}

}