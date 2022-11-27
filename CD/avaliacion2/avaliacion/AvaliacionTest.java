package avaliacion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AvaliacionTest {

	int[] notas = new int [] {4,6,8};
	Alumna alumna = new Alumna
			("Maria", "DAM", "Contornos", 1, notas);
	Avaliacion avaliacion = new Avaliacion(alumna);
	
	@Test
	void testGetNome() {
		String esperado = "Maria";
		String real = alumna.getNome();
		assertEquals(esperado, real);
	}
	
	@Test
	void testGetCiclo() {
		String esperado = "DAM";
		String real = alumna.getCiclo();
		assertEquals(esperado, real);
	}

	@Test
	void testGetModulo() {
		String esperado = "Contornos";
		String real = alumna.getModulo();
		assertEquals(esperado, real);
	}

	@Test
	void testGetCurso() {
		int esperado = 1;
		int real = alumna.getCurso();
		assertEquals(esperado, real);
	}
	
	@Test
	void testToString() {
		String esperado = "Alumna [nome=Maria, "
				+ "ciclo=DAM, modulo=Contornos, "
				+ "curso=1, cualificacions=[4, 6, 8]]";
		String real = alumna.toString();
		assertEquals(esperado, real);
	}
	
	@Test
	void testCualificacionFinalOk() {
		double esperado = 6.0;
		double real = avaliacion.cualificacionFinal();
		assertEquals(esperado, real);
	}
	
	void testCualificacionFinalNotOk() {
		int[] notas2 = new int [] {-4,-6,-8};
		Alumna alumna2 = new Alumna
				("Maria", "DAM", "Contornos", 1, notas2);
		Avaliacion avaliacion2 = new Avaliacion(alumna2);
		double esperado = 0.0;
		double real = avaliacion2.cualificacionFinal();
		assertEquals(esperado, real);
	}

}
