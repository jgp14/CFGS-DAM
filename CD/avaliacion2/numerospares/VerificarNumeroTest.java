package numerospares;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VerificarNumeroTest {

	@Test
	void testEParOk() {
		int n = 200;
		VerificarNumero verificarNumero = new VerificarNumero(n);
		boolean esperado = true; 
		assertEquals(esperado, verificarNumero.ePar());
	}

	@Test
	void testEParNotOk() {
		int n = 201;
		VerificarNumero verificarNumero = new VerificarNumero(n);
		boolean esperado = false; 
		assertEquals(esperado, verificarNumero.ePar());
	}
}
