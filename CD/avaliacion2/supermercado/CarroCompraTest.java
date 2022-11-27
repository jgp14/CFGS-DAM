package supermercado;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarroCompraTest {

	Artigo a1 = new Artigo(1, 20, 20, 200);
	Artigo a2 = new Artigo(2, 5, 40, 400);
	
	Artigo[] artigos = {a1, a2};
	CarroCompra carrocompra = new CarroCompra(artigos);
	
	@Test
	void testGetImporteArtigo() {
		int importeEsperado = 400;
		int importeReal = a1.getImporte();
		assertEquals(importeEsperado, importeReal);
	}
	
	@Test
	void testGetImporteCarro() {
		int importeEsperado = 600;
		int importeReal = carrocompra.getImporte();
		assertEquals(importeEsperado, importeReal);
	}
	
	@Test
	void testGetNumArtigos() {
		int numeroEsperado = 2;
		int numeroReal = carrocompra.getNumArtigos();
		assertEquals(numeroEsperado, numeroReal);
	}

}
