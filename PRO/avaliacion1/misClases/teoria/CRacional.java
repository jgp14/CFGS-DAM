package misClases.teoria;

public class CRacional {
	
	int Numerador;
	int Denominador;

	public void AsignarDatos(int num, int den) {
		Numerador = num;
		Denominador = den;		
		if (den == 0) den = 1; // el denominador no puede ser cero
	}

	public void VisualizarRacional() {		

		System.out.println("Racional: " + Numerador + "/" + Denominador);
	}
}
