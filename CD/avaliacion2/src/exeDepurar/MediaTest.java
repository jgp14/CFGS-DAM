package exeDepurar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MediaTest {
	
	double[] notas = new double[] {4.0, 5.0, 9.0};
	Media media = new Media(notas);

	@Test 
	void testSumarNotas() {
		double esperado = 18.0;
		double real = media.sumarNotas();
		assertEquals(esperado, real);
	}
	
	@Test 
	void testGetMedia() {
		media.sumarNotas();
		double esperado = 6.0;
		double real = media.getMedia();
		assertEquals(esperado, real);
	}
	
	@Test
	void testSetAprobado() {
		media.sumarNotas();
		media.getMedia();
		boolean esperado = true;
		boolean real = media.setAprobado();
		assertEquals(esperado, real);
	}

}
