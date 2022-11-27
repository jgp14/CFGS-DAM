package exeDepurar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PintarTest {

	/*double rend = 12;
	double prezo = 15;
	double sup = 50;
	Pintar pintar = new Pintar(sup, prezo, rend);
	 */
	
	/*@Test
	void testCalcularCusteMetro() {
		double esperado = pintar.calcularImporte() /sup;
		double resultado = pintar.calcularCusteMetro();
		assertEquals(esperado, resultado);
	}
	 */
	
	/*@Test 
	void testCalcularCantidade() {
		double esperado = 12.0 * 50.0;
		double resultado = pintar.calcularCantidade();
		assertEquals(esperado, resultado);
	}*/
	
	/*@Test 
	void testCalcularImporte() {
		//fail("Not yet implemented");
		double esperado = 9000.0;
		double resultado = pintar.calcularImporte();
		assertEquals(esperado, resultado);
	}*/
	
	
	@Test
	void testGetImporte() {	
		Pintar pintar = new Pintar(1.0,1.0,1.0);
		double esperado = 1.0;
		double actual = pintar.getImporte();
		assertEquals(esperado, actual);
	}
}
