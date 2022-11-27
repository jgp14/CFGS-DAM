package teoria.capitulo02.ordenador;

import misClases.teoria.COrdenador;

public class CApOrdenador {
	
	public static void main (String[] args){
		COrdenador MiOrdenador = new COrdenador();
		MiOrdenador.EncenderOrdenador();
		MiOrdenador.Estado();
		MiOrdenador.ApagarOrdenador();
		MiOrdenador.Estado();
		MiOrdenador.ModificarOrdenador();
		MiOrdenador.Estado();
	}
}
