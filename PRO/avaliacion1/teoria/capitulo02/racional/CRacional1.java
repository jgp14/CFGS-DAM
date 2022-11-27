package teoria.capitulo02.racional;

public class CRacional1 {

	int Numerador;
	int Denominador;
	
	void AsignarDatos(int num, int den) {
		Numerador = num;
		Denominador = den;		
		if (den == 0) den = 1; // el denominador no puede ser cero
	}
	
	void VisualizarRacional() {		
	
		System.out.println("Racional-1: " + Numerador + "/" + Denominador);
	}
	
	public static void main(String[] args) {
		CRacional1 r1 = new CRacional1(); //crear un objeto CRacional
		r1.AsignarDatos(2, 5);
		r1.VisualizarRacional();
		
	}
}
