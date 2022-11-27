package tenda;

public class PedidoApp {

	public static void main(String[] args) {
		
		Artigo[] artigos = new Artigo[] {
				new Artigo(1234, "Pila", 2),
				new Artigo(1235, "Bateria", 3)};
		Cliente cliente = new Cliente("123JGP", "Jaime",
				"Plaza Mayor, 1 Boiro", "15960");
		Pedido pedido = new Pedido("123ABC", 2, artigos, cliente);
		
		for(Artigo artigo: artigos)
			System.out.println(artigo.toString());
		
		System.out.println(pedido.getCliente().toString());
		
		System.out.println(pedido.toString());
		
	}

}
