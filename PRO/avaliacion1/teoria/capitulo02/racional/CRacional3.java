package teoria.capitulo02.racional;

public class CRacional3 {

	int Numerador;
	int Denominador;

	void AsignarDatos(int num, int den) {
		Numerador = num;
		Denominador = den;		
		if (den == 0) den = 1; // el denominador no puede ser cero
	}

	void VisualizarRacional() {		

		System.out.println("Racional-3: " + Numerador + "/" + Denominador);
	}
}
