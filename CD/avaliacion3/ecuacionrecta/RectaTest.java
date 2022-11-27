package ecuacionrecta;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RectaTest {

	Punto punto1 = new Punto(1, 2);
	Punto punto2 = new Punto(10, 11);
	Recta recta = new Recta(punto1, punto2);
	
	@Test
	void testDamePunto() {
		int puntoEspe = 1;
		// Introducir el valor 1
		int puntoReal = recta.damePunto("Dame punto = ");
		assertEquals(puntoEspe, puntoReal);
	}
	
	@Test
	void testAmosaPuntoA() {
		String puntoAEspe = "Punto [ x=1.0, y=2.0 ]";
		String puntoAReal = recta.amosaPuntoA();
		assertEquals(puntoAEspe, puntoAReal);
	}
	
	@Test
	void testAmosaPuntoB() {
		String puntoBEspe = "Punto [ x=10.0, y=11.0 ]";
		String puntoBReal = recta.amosaPuntoB();
		assertEquals(puntoBEspe, puntoBReal);
	}
	
	@Test
	void testPendente() {
		float pendenteEspe = 1.0F;
		float pendenteReal = recta.pendente();
		assertEquals(pendenteEspe, pendenteReal);
	}
	
	@Test
	void testCalculoRecta() {
		float x0 = 10.0F;
		float m = 1;
		float calculoRectaEspe = 11.0F;
		float calculoRectaReal = recta.calculoRecta(x0, m);
		assertEquals(calculoRectaEspe, calculoRectaReal);
	}
	
	@Test
	void testEcuacionRecta() {
		String puntoBEspe = "Punto [ x=10.0, y=11.0 ]";
		float m =  recta.pendente();
		// Introducir el valor 10
		String puntoBReal = recta.ecuacionRecta(m);
		assertEquals(puntoBEspe, puntoBReal);
	}

}
