package alimentacion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RefecionTest {

	Alimento a1 = new Alimento("Pan", 100, 10, 5, 85);
	Alimento a2 = new Alimento("Patacas", 120, 30, 25, 45);
	
	Ingrediente i1 = new Ingrediente(a1, 80);
	Ingrediente i2 = new Ingrediente(a2, 40);
	Ingrediente[] ingredientes = 
			new Ingrediente[] {i1,i2};
	
	Refecion refecion = new Refecion(ingredientes);
	
	@Test
	void testPeso() {
		int pesoEspe = 100*80 + 100*40;
		int pesoReal = refecion.peso();
		assertEquals(pesoEspe, pesoReal);
	}
	
	@Test
	void testPorcentaxes() {
		String porEspe = "Pan->66\nPatacas->33\n";
		String porReal = refecion.porcentaxes();
		assertEquals(porEspe, porReal);
	}
	
	// prueba de metodo de porcentaxes nutricionais
	/*@Test
	void testPorcentaxes() {
		String porEspe = "16 proteinas\n11 lipidos\n71 carbohidratos\n";
		String porReal = refecion.porcentaxes();
		assertEquals(porEspe, porReal);
	}*/
	
	@Test
	void testCalorias() {
		int calorEspe = 100*80 + 120*40;
		int calorReal = refecion.calorias();
		assertEquals(calorEspe, calorReal);
	}

}
