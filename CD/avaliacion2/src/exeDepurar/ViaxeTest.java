package exeDepurar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ViaxeTest {

	/*private static final double LITROSKM7 = 7.0/100.0;
	private static final double LITROSKM9 = 9.0/100.0;
	double dist = 250.0;
	double vel = 120.0;
	double prezo = 1.5;
	 */
	
	/*@Test
	void testConsumo() {
		Consumo consumo = new consumo (dist, vel, prezo);
		double real = LITROSKM9;
		double actual = consumo.getConsumo();
		assertEquals(real , actual)
	}
	 
	@Test
	void testCalculaImporte() {
		double esperado = dist * LITROSKM7 *prezo;
		Consumo consumo = new consumo (dist, vel, prezo);
		double actual = consumo.calculaImporte();
		assertEquals(esperado , actual)
	}*/
	
	Viaxe viaxe = new Viaxe(60.0,120.0,1.5);

	@Test
	void testGetConsumo() {
		double esperado = 0.09;
		double actual = viaxe.getConsumo();
		assertEquals(esperado, actual);
	}
	
	@Test
	void testGetCuste() {
		//fail("Not yet implemented");
		double esperado = 8.1;
		double actual = viaxe.getCuste();
		assertEquals(esperado, actual);
	}

}
