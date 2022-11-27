package enerxia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EnerxiaTest {
	
	private static double GRAVIDADE = 9.81;	//positivo
	private static double masa = 1.0; 		//positivo
	Enerxia enerxia = new Enerxia(masa);	

	@Test
	void testEPotencial() {
		double esperaEPotencial = GRAVIDADE;
		double altura = 1.0;				//positivo
		double ePotencial = enerxia.ePotencial(altura);
		assertEquals(esperaEPotencial, ePotencial);
	}
	
	@Test
	void testECinetica() {
		double esperaECinetica = 0.5;
		double vel = 1.0;					//positivo
		double eCinetica = enerxia.eCinetica(vel);
		assertEquals(esperaECinetica, eCinetica);
	}
	
	@Test
	void testCalculaVelocidade() {
		double esperaVelocidad = 1.0;		//positivo
		double vel = 1.0;					//positivo
		enerxia.eCinetica(vel);
		double velocidad = enerxia.calculaVelocidade();
		assertEquals(esperaVelocidad, velocidad);
	}

}
