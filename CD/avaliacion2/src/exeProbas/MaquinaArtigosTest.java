package exeProbas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MaquinaArtigosTest {

	String[] nome = new String[] {"bollo", "dulce", "refresco", "snack"};
	double[] prezo = new double[] {10.0, 10.0, 10.0, 10.0};
	int[] stock = new int[] {3,3,3,3};
	double importe; 
	double totalCompras = 0.0;
	MaquinaArtigos m = new MaquinaArtigos(nome, prezo, stock, 0);
	
	@Test 
	void testGetCodigo() {
		int esperado = 0;
		int actual = m.getCodigo();
		assertEquals(esperado, actual);	
	}
	
	@Test
	void testAvisoStock() {
		boolean esperado = true;
		boolean actual = m.avisoStock();
		assertEquals(esperado, actual);	
	}
	
	@Test
	void testGetCantidad() {
		m.setCantidad(); //Introducir una catidad de 2
		int esperado = 2;
		int actual = m.getCantidad();
		assertEquals(esperado, actual);	
	}
	
	@Test
	void testGetImporte() {
		double esperado = 10.0 * m.getCantidad();
		double actual = m.getImporte();
		assertEquals(esperado, actual);	
	}
	
	@Test
	void testContinuarCompra() {
		boolean esperado = false;
		boolean actual = m.continuarCompra();
		assertEquals(esperado, actual);	
	}
}
