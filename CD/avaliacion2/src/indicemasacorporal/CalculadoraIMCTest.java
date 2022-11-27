package indicemasacorporal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculadoraIMCTest {

	private static final String SOBREPESO = 
			"EXISTE SOBREPESO";
	private static final String PESO_NORMAL = 
			"O PESO ESTÁ DENTRO DOS LÍMITES";
	
	double peso = 80.0;
	Persoa persoa = new Persoa("Castro", "Carballo", 
			"Antonio", "1234567P", 1.60);
	CalculadoraIMC calculadora = 
			new CalculadoraIMC(persoa, peso);
	
	@Test
	void testGetIndiceMasaCorporal() {
		double esperado = 31.249999999999993;
		double real = calculadora.getIndiceMasaCorporal();
		assertEquals(esperado, real);
	}
	
	@Test
	void testValorarImc() {
		int esperado = -1;
		int real = calculadora.valorarImc();
		assertEquals(esperado, real);
	}
	
	@Test
	void testImprimirAvisoSobrepeso() {
		String esperado = SOBREPESO;
		String real = calculadora.imprimirAviso();
		assertEquals(esperado, real);
	}
	
	@Test
	void testImprimirAvisoPesoNormal() {
		double peso = 70.0;
		Persoa persoa = new Persoa("Castro", "Carballo", 
				"Antonio", "1234567P", 1.80);
		CalculadoraIMC calculadora = 
				new CalculadoraIMC(persoa, peso);
		String esperado = PESO_NORMAL;
		String real = calculadora.imprimirAviso();
		assertEquals(esperado, real);
	}
	
}
