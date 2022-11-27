package exeDepurar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ComisionTest {
	double [] ventas = new double[] {0,0,0};
	Comision comision = new Comision(ventas,false,0);
	
	@Test
	void testSetBooleanComision() {
		boolean esperado = false;
		boolean real = comision.setBooleanComision();
		assertEquals(esperado, real);
	}
	
	@Test
	void testValorComision() {
		double esperado = 0.0;
		double real = comision.valorComision();
		assertEquals(esperado, real);	
	}
}
