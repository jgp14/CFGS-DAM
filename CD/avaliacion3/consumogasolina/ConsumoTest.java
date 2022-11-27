package consumogasolina;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ConsumoTest {

	Consumo[] consumo = new Consumo[] 
			{new Consumo(100, 8), new Consumo(60, 4)};
	Consumos consumos = new Consumos(consumo);
	
	@Test
	void testConsumoMedio() {
		double medioEsperado = (4+8) / consumo.length;
		@SuppressWarnings("static-access")
		double medioReal = consumos.calcularConsumoMedio();
		assertEquals(medioEsperado, medioReal);
	}
	
	@Test
	void testConsumoPorcentual() {
		double porcenEsperado = (4+8);
		porcenEsperado = 100 * porcenEsperado / (100+60);
		@SuppressWarnings("static-access")
		double porcenReal = consumos.calcularConsumo100Km();
		assertEquals(porcenEsperado, porcenReal);
	}

	@Test
	void testConsumoEstimado() {
		double estimaEsperado = (4+8);
		estimaEsperado = 100 * estimaEsperado / (100+60);
		estimaEsperado = 80*estimaEsperado/100;
		@SuppressWarnings("static-access")
		double estimaReal = consumos.consumoEstimado(80);
		assertEquals(estimaEsperado, estimaReal);
	}
	
	
	/*Consumo[] consumo = new Consumo[] 
			{new Consumo(100, 8), new Consumo(60, 4)};
	Consumos consumos = new Consumos(consumo);
	
	@Test
	void testConsumoMedio() {
		float medioEsperado = (4+8) / consumo.length;
		float medioReal = consumos.consumoMedio();
		assertEquals(medioEsperado, medioReal);
	}
	
	@Test
	void testConsumoPorcentual() {
		float porcenEsperado = (4+8) / consumo.length;
		porcenEsperado = 100 * porcenEsperado / (100+60);
		float porcenReal = consumos.consumoPorcentual();
		assertEquals(porcenEsperado, porcenReal);
	}

	@Test
	void testConsumoEstimado() {
		float estimaEsperado = (4+8)/consumo.length;
		estimaEsperado = 80*estimaEsperado/100;
		float estimaReal = consumos.consumoEstimado(80);
		assertEquals(estimaEsperado, estimaReal);
	}
	
	@Test
	void testMenu() {
		int menuEsperado = 1;
		int menuReal = consumos.opcion(1);
		assertEquals(menuEsperado, menuReal);
	}*/
	
}
