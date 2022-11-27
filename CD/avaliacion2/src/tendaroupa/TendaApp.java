package tendaroupa;

public class TendaApp {

	public static void main(String[] args) {
		Prenda a1 = new Prenda(10.0, "1A", 2, "Camiseta");
		Prenda a2 = new Prenda(20.0, "1B", 1, "Pantalon");
		Prenda[] cesta = new Prenda[] {a1, a2};
		Cliente cliente = new Cliente(cesta);
		Tenda tenda = new Tenda(cliente, 10000.0);
		cliente.setImporte();
		tenda.setCapital();
		double balance = tenda.getCapital();
		System.out.println(balance);
	}
}
