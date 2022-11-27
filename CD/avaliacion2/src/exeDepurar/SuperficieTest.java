package exeDepurar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SuperficieTest {

	@Test
	void testGetArea() {
		//fail("Not yet implemented");
		Superficie superficie = new Superficie(2, 2, "m");
		double esperado = 4;
		double actual = superficie.getArea();
		assertEquals(esperado, actual);
	}
}
