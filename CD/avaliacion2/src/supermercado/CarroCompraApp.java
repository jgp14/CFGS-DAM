package supermercado;

public class CarroCompraApp {

	private static final int NUM_ARTIGOS = 2;
	
	public static void main(String[] args) {
		
		
		Artigo a1 = new Artigo(1, 20, 20, 200);
		Artigo a2 = new Artigo(2, 5, 40, 400);
		
		Artigo[] artigos = new Artigo[NUM_ARTIGOS];
		artigos[0] = a1;
		artigos[1] = a2;

		// Completa este método para que cumpra os 
		//requerimentos do enunciado da proba:
		// Cantos artigos hai no carro?
		// Cal é o listado de artigos comprados 
		//(código, prezo, cantidade e importe)
		// Cal é importe total da compra do carro?

		CarroCompra carrocompra = new CarroCompra(artigos);
		int nArtigos = carrocompra.getNumArtigos();
		System.out.println("Numero de artigos: "+nArtigos);
		carrocompra.listaCompra();
		System.out.println
		("Importe total compra: "+carrocompra.getImporte()); 

	}

}