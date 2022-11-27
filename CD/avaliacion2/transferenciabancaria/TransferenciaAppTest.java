package transferenciabancaria;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TransferenciaAppTest {

    @Test
	void testMensaxeOk() {
		String Ok = "TRANSFERENCIA REALIZADA";
		Clienta orixe = new Clienta("1A", 100);	
	    Clienta destino = new Clienta("2B", 200);
	    Transferencia transferencia = 
	    		new Transferencia(orixe, destino);
	    double cantidade1 = 50; 
		@SuppressWarnings("unused")
		boolean resultado = true;
		@SuppressWarnings("unused")
		boolean ok = transferencia.transferencia(cantidade1);
		String msg = transferencia.mensaxeOk();
		assertEquals(msg, Ok);
	}
	
	@Test
	void testMensaxeOkNot() {
		String notOk = "TRANSFERENCIA NON REALIZADA";		
		Clienta orixe = new Clienta("1A", 100);	
	    Clienta destino = new Clienta("2B", 200);
	    Transferencia transferencia = 
	    		new Transferencia(orixe, destino);
	    double cantidade1 = 150; 
		@SuppressWarnings("unused")
		boolean resultado = false;
		@SuppressWarnings("unused")
		boolean ok = transferencia.transferencia(cantidade1);
		String msg = transferencia.mensaxeOk();
		assertEquals(msg, notOk);
	}
	
   /* @Test
	void testMensaxeNotOk() {
		String NOTOK = "TRANSFERENCIA NON REALIZADA";
		Clienta orixe = new Clienta("1A", 100);	
	    Clienta destino = new Clienta("2B", 200);
	    Transferencia transferencia = 
	    		new Transferencia(orixe, destino);
	    double cantidade1 = 150; 
		boolean resultado = true;
		boolean ok = transferencia.transferencia(cantidade1);
		String msg = transferencia.mensaxeNotOk();
		assertEquals(msg, NOTOK);
	}
	
	@Test
	void testMensaxeNotOkNot() {
		String notOkNot = "TRANSFERENCIA REALIZADA";		
		Clienta orixe = new Clienta("1A", 100);	
	    Clienta destino = new Clienta("2B", 200);
	    Transferencia transferencia = 
	    		new Transferencia(orixe, destino);
	    double cantidade1 = 50; 
		boolean resultado = true;
		boolean ok = transferencia.transferencia(cantidade1);
		String msg = transferencia.mensaxeNotOk();
		assertEquals(msg, notOkNot);
	}*/
    
	@Test
	void testTransferenciaOk() {
		Clienta orixe = new Clienta("1A", 100);	
	    Clienta destino = new Clienta("2B", 200);
	    Transferencia transferencia = 
	    		new Transferencia(orixe, destino);
		double cantidade1 = 50; 
		@SuppressWarnings("unused")
		boolean resultado = true;
		boolean ok = transferencia.transferencia(cantidade1);
		assert(ok);
	}
	
	@Test
	void testTransferenciaNotOk() {
		Clienta orixe = new Clienta("1A", 100);	
	    Clienta destino = new Clienta("2B", 200);
	    Transferencia transferencia = 
	    		new Transferencia(orixe, destino);
	    double cantidade1 = 150; 
		boolean resultado = false;
		boolean ok = transferencia.transferencia(cantidade1);
		assertEquals(ok, resultado);
	}
    
}
