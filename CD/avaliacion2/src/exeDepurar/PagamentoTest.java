package exeDepurar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PagamentoTest {

	/*@Test
	void testCalcularIve() {
		//fail("Not yet implemented");
		double[] ingresos = 
			{1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 
			1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0 };
		Pagamento pago = new Pagamento(ingresos);

		double esperado = 12000*0.21;
		double actual = pago.calcularIve();
		assertEquals(esperado, actual);
	}*/
		
	double[] valores = new double[] 
			{1000.0, 2000.0, 3000.0};
	Pagamento pago = new Pagamento(valores);
	
	@Test
	void testSumarMes() {
		double esperado = 6000.0;
		double actual = pago.sumarMes();
		assertEquals(esperado, actual);
	}
	
	@Test
	void testCalcularPagamento() {
		double esperado = 6000*0.21;
		double actual = pago.calcularPagamento();
		assertEquals(esperado, actual);	
	}
}
