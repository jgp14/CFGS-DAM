package partidobasket;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EquipoTest {

	@Test
	void testSumaEquipoOk() {
		Xogadora x11 = new Xogadora("A1", 1);
		Xogadora x12 = new Xogadora("A2", 5);
		Xogadora[] xogadoras1 = new Xogadora[] {x11, x12};
		Equipo equipo1 = new Equipo(xogadoras1, 1);
		int esperado = 1+5;
		int real = equipo1.sumaEquipo();
		assertEquals(esperado, real);
	}

}
