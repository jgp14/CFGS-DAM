package teoria.capitulo11;

import misClases.teoria.CMiClase;
import misClases.teoria.EValorNoValido;

public class CApListado {

	public static void main(String[] args) {
		int x = 10;
		CMiClase obj = new CMiClase();
		while (x >= -10) {
			try {
				obj.muestra(x);
			} catch (EValorNoValido e) {
				System.out.println(e.getMessage());
				continue;
			} finally {
				x--;
			} 
		} 
	}

}
