package exeProbas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MaquinaBebidasTest {
	String[] producto = new String[] {"Agua", "Bollo", "Refresco", "Snack"};
	int[] stock = new int[] {10,10,10,10};
	double[] importe = new double[] {2.0, 2.0, 2.0, 2.0};
	double cambio; 
	double importesCobrados = 0.0;
	MaquinaBebidas m = new MaquinaBebidas(producto, stock, importe, 0);
	
	@Test 
	void testGetCodigo() {
		int esperado = 0;
		int actual = m.getCodigo();
		assertEquals(esperado, actual);	
	}
	
	@Test
	void testAvisoStock() {
		boolean esperado = false;
		boolean actual = m.avisoStock();
		assertEquals(esperado, actual);	
	}
	
	@Test
	void testGetImporte() {
		m.mostraAviso();
		double esperado = m.getPrezo();
		double actual = m.getImporte();
		assertEquals(esperado, actual);	
	}
	
	@Test
	void testContinuarCompra() {
		boolean esperado = false;
		boolean actual = m.continuarCompra(); //no
		assertEquals(esperado, actual);	
	}
}
