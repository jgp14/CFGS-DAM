package tendaroupa;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TendaTest {
	
	Prenda a1 = new Prenda(10.0, "1A", 2, "Camiseta");
	Prenda a2 = new Prenda(20.0, "1B", 1, "Pantalon");
	Prenda[] cesta = new Prenda[] {a1, a2};
	Cliente cliente = new Cliente(cesta);

	@Test
	void testSetImporte() {
		double esperado = 40.0;
		double importe = cliente.setImporte();
		assertEquals(esperado, importe);
	}

	@Test
	void testGetCapital() {
		Tenda tenda = new Tenda(cliente, 10000.0);
		double esperado = 10040.0;
		cliente.setImporte();
		tenda.setCapital();
		double capital = tenda.getCapital();
		assertEquals(esperado, capital);
	}
}
