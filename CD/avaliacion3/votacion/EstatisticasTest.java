package votacion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EstatisticasTest {

	int[] votos = new int[] { 100, 200, 300 };

	@Test
	void testCalcularMedia() {
		int esperado = (100 + 200 + 300) / votos.length;
		int real = Estatisticas.calcularMedia(votos);
		assertEquals(esperado, real);
	}

	@Test
	void testCalcularMaximo() {
		int esperado = 300;
		int real = Estatisticas.calculaMaximo(votos);
		assertEquals(esperado, real);
	}
	
	/*int[] votos = new int[] {200, 400, 600};
	Estatisticas estatisticas = new Estatisticas();
	
	private static final String DISTRITOS = 
			"Numero de distritos ";
	private static final String MAXIMO = 
			"Maximo dos votos emitidos max = ";
	private static final String MINIMO = 
			"Minimo dos votos emitidos min = ";
	private static final String MEDIA = 
			"Media dos votos emitidos m = ";
	
	@Test
	void testAmosaVotos() {
		String votoEsperado = 
				200+"\n"+400+"\n"+600+"\n";
		String votoReal = 
				estatisticas.amosaVotos(votos);
		assertEquals(votoEsperado, votoReal);
	}
	
	@Test
	void testMin() {
		int minEsperado = 200;
		int minReal = estatisticas.min(votos);
		assertEquals(minEsperado, minReal);
	}
	
	@Test
	void testMax() {
		int maxEsperado = 600;
		int maxReal = estatisticas.max(votos);
		assertEquals(maxEsperado, maxReal);
	}
	
	@Test
	void testMedia() {
		int mediaEsperada = 400;
		int mediaReal = estatisticas.media(votos);
		assertEquals(mediaEsperada, mediaReal);
	}
	
	@Test
	void testEstadisticas() {
		String esperado = 
				(DISTRITOS + votos.length+"\n")
				+ (MAXIMO+600+"\n")
				+ (MINIMO+200+"\n")
				+ (MEDIA+400+"\n");
		String real = estatisticas.estadisticas(votos);
		assertEquals(esperado, real);
	}*/

}
