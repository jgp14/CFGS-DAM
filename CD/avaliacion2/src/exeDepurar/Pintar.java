package exeDepurar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Pintar {
	
	/*private double superficie;
	private double prezo;
	private double rendemento;
	private double importe; //resultado dos calculos que piden
	
	public Pintar(Double superficie, double prezo, 
			Double rendemento) {
		super();
		this.superficie = superficie;
		this.prezo = prezo;
		this.rendemento = rendemento;
	}
	
	public double calcularCantidade() {
		this.cantidade 
		return this.rendemento * this.superficie;
	}
	
	public double calcularImporte() {
		this.importe = this.prezo * this.rendemento * this.superficie;
		return this.importe;
	}
	
	public double calcularCusteMetro() {
		this.custeMetro = this.calcularImporte() / this.
		return
	}
	 */

	private double superficie; 	//superficie en m2
	private double prezo; 		//prezo por kg
	private double rendemento;	//rendemento en m2/kg
	private double importe;	 	//importe total traballo
	PrintStream flujoS = System.out;
	
	public Pintar(Double superficie, double prezo, 
			Double rendemento) {
		super();
		this.superficie = superficie;
		this.prezo = prezo;
		this.rendemento = rendemento;
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
	    	flujoS.print("Dame un numero real: ");
	    	d = datoDouble();
	    }
	    return d;
	}
	
	/*private void valorPositivo() {
		while(positivo < 0) {
			System.out.print
			("Dame un valor correcto do dato: ");
			this.positivo = valorDoubleCorrecto();  
		}	
	}*/
	
	public void setSuperficie() {
		do {
			flujoS.print("Superficie a pintar en m^2: ");
			this.superficie = valorDoubleCorrecto();;
		} while (superficie < 0.0);
	}

	public void setPrezo() {
		do {
			flujoS.print("Prezo da pintura en EUR/kg: ");
			this.prezo = valorDoubleCorrecto();
		} while(prezo < 0.0);
	}

	public void setRendemento() {
		do {
			flujoS.print("Rendemento da pintura en m2/Kg: ");
			this.rendemento = valorDoubleCorrecto();
		} while(rendemento < 0.0);
	}
	
	public double getImporte() {
		importe = superficie/rendemento * prezo;
		return importe;
	}
	
	public static void main(String[] args) {
		/*double rend = 12;
		double prezo = 15;
		double sup = 50;
		Pintar pintar = new Pintar(sup, prezo, rend);
		System.out.println("Importe da pintura :  ");
		System.out.println(pintar.calcularImporte());
		 */
		
		Pintar pintar = new Pintar(0.0,0.0,0.0);
		pintar.setSuperficie();
		pintar.setPrezo();
		pintar.setRendemento();
		System.out.println("Importe total do traballo e de "
		+pintar.getImporte()+" EUR");
	}
}
