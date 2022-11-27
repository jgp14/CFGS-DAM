package depurar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PositivoTest {

	@Test
	void testEPositivo() {
		//fail("Not yet implemented");
		Positivo positivo = new Positivo(2);
		boolean esperado = true;
		boolean real = positivo.ePositivo();
		assertEquals(esperado, real);
	}

}
