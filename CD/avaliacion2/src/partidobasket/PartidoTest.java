package partidobasket;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PartidoTest {

	@Test
	void testSumaEquipo() {
		Xogadora x11 = new Xogadora("A1", 10);
		Xogadora x12 = new Xogadora("A2", 5);
		Xogadora[] xogadoras1 = new Xogadora[] {x11, x12};
		Equipo equipo1 = new Equipo(xogadoras1, 1);
		
		Xogadora x21 = new Xogadora("B1", 1);
		Xogadora x22 = new Xogadora("B2", 5);
		Xogadora[] xogadoras2 = new Xogadora[] {x21, x22};
		Equipo equipo2 = new Equipo(xogadoras2, 1);
		
		Partido partido = new Partido(equipo1, equipo2);
		int numGanhador = partido.verificarGanador();
		int esperado = 1;
		assertEquals(esperado, numGanhador);
	}
	
	@Test
	void testSumaEquipoOkEmpate() {
		Xogadora x11 = new Xogadora("A1", 1);
		Xogadora x12 = new Xogadora("A2", 5);
		Xogadora[] xogadoras1 = new Xogadora[] {x11, x12};
		Equipo equipo1 = new Equipo(xogadoras1, 1);
		
		Xogadora x21 = new Xogadora("B1", 1);
		Xogadora x22 = new Xogadora("B2", 5);
		Xogadora[] xogadoras2 = new Xogadora[] {x21, x22};
		Equipo equipo2 = new Equipo(xogadoras2, 1);
		
		Partido partido = new Partido(equipo1, equipo2);
		int numGanhador = partido.verificarGanador();
		int esperado = 0;
		assertEquals(esperado, numGanhador);
	}
	
	/*@Test
	void testSumaEquipoOkGana1() {
		Xogadora x11 = new Xogadora("A1", 15);
		Xogadora x12 = new Xogadora("A2", 8);
		Xogadora x21 = new Xogadora("B1", 3);
		Xogadora x22 = new Xogadora("B2", 12);
		Partido partido = new Partido();
		int puntos1 = x11.getPuntos() + x12.getPuntos();
		int puntos2 = x21.getPuntos() + x22.getPuntos();
		partido.setSumaEquipos(puntos1, puntos2);
		partido.Ok();
		String esperado = "GANADOR DO PARTIDO E O EQUIPO: 1";
		String real = partido.getMensaxeEquipos();
		assertEquals(esperado, real);

	}

	@Test
	void testSumaEquipoOkEmpate() {
		Xogadora x11 = new Xogadora("A1", 15);
		Xogadora x12 = new Xogadora("A2", 0);
		Xogadora x21 = new Xogadora("B1", 3);
		Xogadora x22 = new Xogadora("B2", 12);
		Partido partido = new Partido();
		int puntos1 = x11.getPuntos() + x12.getPuntos();
		int puntos2 = x21.getPuntos() + x22.getPuntos();
		partido.setSumaEquipos(puntos1, puntos2);
		partido.Ok();
		String esperado = "EMPATE NO PARTIDO";
		String real = partido.getMensaxeEquipos();
		assertEquals(esperado, real);
	}
	
	@Test
	void testSumaOk() {
		Xogadora x11 = new Xogadora("A1", 15);
		Xogadora x12 = new Xogadora("A2", 0);
		Xogadora x21 = new Xogadora("B1", 3);
		Xogadora x22 = new Xogadora("B2", 12);
		Partido partido = new Partido();
		int puntos1 = x11.getPuntos() + x12.getPuntos();
		int puntos2 = x21.getPuntos() + x22.getPuntos();
		partido.setSumaEquipos(puntos1, puntos2);
		boolean esperado = false;
		boolean real = partido.Ok();
		assertEquals(esperado, real);
	}*/
}
