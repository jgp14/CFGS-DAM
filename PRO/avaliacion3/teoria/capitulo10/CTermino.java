package teoria.capitulo10;

import java.math.*;

public class CTermino {

	private double coeficiente = 0.0; 	// coeficiente
	private int exponenteDeX = 1; 		// exponente de x
	private int exponenteDeY = 1;		// exponente de y
	
	public CTermino() {}
	public CTermino(double coef, int expx, int expy) {// constructor
		coeficiente = coef;
		exponenteDeX = expx;
		exponenteDeY = expy;
	}
}
