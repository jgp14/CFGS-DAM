package cdexamen2;

import java.io.PrintStream;

public class ConverteApp {

	public static void main(String[] args) {
		
		final double valorRublo= 0.0095;
		final double valorEuro = 113.9670;
		final double cantidade = 100;
		
		// Completa este método para facer uso 
		//da clase Converter
		Unit unit = new Unit
		(valorRublo, valorEuro, cantidade);
		Converter converter = new Converter(unit, 0);
		PrintStream flujoS = System.out;
		
		double esperado = 100.0;
		double resultado = converter.convert();
		String OK = "Resultado e correcto"; 
		String NOTOK = "Resultado non e correcto"; 
		
		flujoS.println(esperado);
		flujoS.println(resultado);
		if(esperado == resultado)
			flujoS.println(OK);
		else flujoS.println(NOTOK);		
	}
}
