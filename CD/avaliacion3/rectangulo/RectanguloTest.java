package rectangulo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RectanguloTest {
	
	private static final String LADO1 = "Lado a = ";
	private static final String LADO2 = "Lado b = ";
	private static final String OPCIONS_CALCULO = 
	"Opcion\r\n\t1. Perimetro\r\n\t2. "
	+ "Superficie\r\n\t0. Sair";
	Rectangulo rectangulo = new Rectangulo();

	
	@Test
	void testInserirDato() {
		int Aesperada = 2, Besperada = 2, Oesperada = 2;
		// Introducir o valor 2 en todos
		int Areal = rectangulo.inserirDato(LADO1);
		int Breal = rectangulo.inserirDato(LADO2);
		int Oreal = rectangulo.inserirDato(OPCIONS_CALCULO);
		assertEquals(Aesperada, Areal);
		assertEquals(Besperada, Breal);
		assertEquals(Oesperada, Oreal);
	}
	
	@Test
	void testMenu1() {
		int a = 2, b = 2, opcion = 1;
		rectangulo.menu(a, b, opcion);
	}
	
	@Test
	void testMenu2() {
		int a = 2, b = 2, opcion = 2;
		rectangulo.menu(a, b, opcion);
	}
	
	
	/*private static final String LADO1 = "Lado a = ";
	private static final String LADO2 = "Lado b = ";
	private static final String OPCIONS_CALCULO = 
			"Opcion\r\n\t1. Perimetro\r\n\t2. "
			+ "Superficie\r\n\t0. Sair";
	Rectangulo rectangulo = new Rectangulo();
	
	@Test
	void testInxerirDato() {
		int Aesperada = 2, Besperada = 2, Oesperada = 2;
		// Introducir o valor 2 en todos
		int Areal = rectangulo.inxerirDato(LADO1);
		int Breal = rectangulo.inxerirDato(LADO2);
		int Oreal = rectangulo.inxerirDato(OPCIONS_CALCULO);
		assertEquals(Aesperada, Areal);
		assertEquals(Besperada, Breal);
		assertEquals(Oesperada, Oreal);
	}
	
	@Test
	void testMenuPerimetro() {
		int a = 2, b = 2, opcion = 1; 
		int Pesperado = 8;
		int Preal = rectangulo.menu(a,b,opcion);
		assertEquals(Pesperado, Preal);
	}
	
	@Test
	void testMenuSuperficie() {
		int a = 2, b = 2, opcion = 2; 
		int Sesperado = 4;
		int Sreal = rectangulo.menu(a,b,opcion);
		assertEquals(Sesperado, Sreal);
	}*/
	
}
