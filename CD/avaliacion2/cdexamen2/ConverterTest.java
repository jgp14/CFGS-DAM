package cdexamen2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ConverterTest {

	final double valorRublo= 0.0095;
	final double valorEuro = 113.9670;
	final double cantidade = 100;
	
	@Test
	void testConverter0() {
		Unit unit = new Unit
		(valorRublo, valorEuro, cantidade);
		Converter converter = new Converter(unit, 0);
		double esperado = 0.95;
		double resultado = converter.convert();
		assertEquals(esperado, resultado);
	}
	
	@Test
	void testConverter1() {
		Unit unit = new Unit
		(valorRublo, valorEuro, cantidade);
		Converter converter = new Converter(unit, 1);
		double esperado = 11396.7;
		double resultado = converter.convert();
		assertEquals(esperado, resultado);
	}
	
	void testConverterOtroValor() {
		Unit unit = new Unit
		(valorRublo, valorEuro, cantidade);
		Converter converter = new Converter(unit, -1);
		double esperado = 0.0;
		double resultado = converter.convert();
		assertEquals(esperado, resultado);
	}

}
