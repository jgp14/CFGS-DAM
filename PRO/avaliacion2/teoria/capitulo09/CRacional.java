package teoria.capitulo09;

public class CRacional {
	int Numerador; 
	int Denominador;
	
	void AsignarDatos(int num, int den) {
		Numerador = num;
		if(den == 0) den = 1; 
		// el denominador no puede ser cero
	}
	
	void VisualizarRacional() {
		System.out.println(Numerador + "/" + Denominador);
	}
}
