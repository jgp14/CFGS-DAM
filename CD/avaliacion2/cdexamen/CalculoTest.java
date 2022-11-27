package cdexamen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculoTest {

	@Test
	void testGetSuma() {
		System.out.println
		("\nDame valores calcular media: ");
		Calculo calculo = new Calculo();
		double esperado = 6.0;
		double suma = calculo.getSuma();
		assertEquals(esperado, suma);
	}
	
	@Test
	void testGetMedia() {
		System.out.println
		("\nDame valores calcular media: ");
		Calculo calculo = new Calculo();
		calculo.getSuma();
		double esperado = 2.0;
		double media = calculo.getMedia();
		assertEquals(esperado, media);
	}
}
