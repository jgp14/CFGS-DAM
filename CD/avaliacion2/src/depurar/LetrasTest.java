package depurar;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.logging.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

@SuppressWarnings("unused")
class LetrasTest {

	private static Logger logger = Logger.getLogger("rexistro");
	
	private Letras letras;
	
	@BeforeClass
	public void setUpClass() throws IOException {
		letras = new Letras("abc", "a");
		logger.info("instanciando clase probas");
	}
	
	@Test
	void testVerificar() {
		//fail("Not yet implemented");
		Letras letras = new Letras("abc", "a");
		boolean esperado = true;
		boolean real = letras.verificar();
		//Logger.info("verificando resultado verificar() "+real);
		assertEquals(esperado, real);
	}

}
