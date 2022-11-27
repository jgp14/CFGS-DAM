package teoria.capitulo02.racional;

public class CApRacional2 {

	public static void main(String[] args) {
		CRacional2 r2 = new CRacional2(); //crear un objeto CRacional
		r2.AsignarDatos(2, 5);
		r2.VisualizarRacional();
	}

}

class CRacional2{
    
	int Numerador;
	int Denominador;

	void AsignarDatos(int num, int den) {
		Numerador = num;
		Denominador = den;		
		if (den == 0) den = 1; // el denominador no puede ser cero
	}

	void VisualizarRacional() {		

		System.out.println("Racional-2: " + Numerador + "/" + Denominador);
	}
}