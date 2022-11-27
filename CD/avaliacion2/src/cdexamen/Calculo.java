package cdexamen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculo {
	private static final int MAX_NUM = 3;
    private int i = 0;
	private double suma = 0.0;
    private double media = 0.0;
    private double[] numeros = new double[MAX_NUM];

    public Calculo() {
        this.numeros = this.inserirValores();
    }

    private double suma() {
        this.suma = 0.0;
        for (int k = 0; k < numeros.length; k++)
            suma += numeros[k];
        return suma;
    }

    private double media() {
    	this.media = this.suma / this.numeros.length;
        return media;
    }

    public double getSuma() {
    	this.suma();
        return suma;
    }

    public double getMedia() {
    	this.media();
        return media;
    }
    
    private static String dato() {
		String sdato = "";
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader flujoE = new BufferedReader(isr);
			sdato = flujoE.readLine();
		}catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
		return sdato;
	}
    
    private static double datoDouble() {
		try {
			//@SuppressWarnings("deprecation")
			Double d = new Double(dato());
			return d.doubleValue();
		}catch (NumberFormatException e) {
			return Double.MIN_VALUE;
		}
	}
    
    private double valorDoubleCorrecto() {
    	double d = datoDouble();
    	while(d == Double.MIN_VALUE) {
			System.out.print("Valor de numeros["+i+"]: ");
    		d = datoDouble();
    	}
    	return d;
    }
    
    public double[] inserirValores() {
    	for(; i < numeros.length; i++) {
			System.out.print("Valor de numeros["+i+"]: ");
			numeros[i] = valorDoubleCorrecto(); 
    	}
    	return numeros;
    }
}