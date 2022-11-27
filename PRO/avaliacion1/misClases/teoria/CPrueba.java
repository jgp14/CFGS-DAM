package misClases.teoria;

import java.lang.System; // importar la clase System

public class CPrueba {
	
	// Definición de constantes
	final static int limInferior = -30;
	final static int limSuperior = 100;
	final static int incremento = 6;

	// Declaración de variables
	private CGrados grados = new CGrados();
	// float centrigrados
	float gradosCent = limInferior;
	float gradosFahr = 0;
	
	public void RecogeGrados(){
		while (gradosCent <= limSuperior) 
		{
			//Asignar al objeto grados el valor en grados centígrados
			grados.CentigradosAsignar(gradosCent);
			//Obtener del objeto grados los grados fahrenheit
			gradosFahr = grados.FahrenheitObtener();
			//Escribir la siguiente linea de la tabla
			System.out.println(gradosCent + " C" + "\t" + gradosFahr + " F");
			// Siguiente valor
			gradosCent += incremento;
		}
	}
	
	public float AmosaGrados() {
		return gradosCent;
	}
	
}
