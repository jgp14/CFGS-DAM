package exeDepurar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Viaxe {
	
	/*private static final double LITROSKM7 = 7.0/100.0;
	private static final double LITROSKM9 = 9.0/100.0;
	
	private double consumo;
	private double distancia; 
	private double velocidade;
	private double prezo;
	private double importe;
	
	public Viaxe(double distancia, double velocidade, double prezo) {
		super();
		this.percorrido = distancia;
		this.velocidade = velocidade;
		this.prezo = prezo;
		this.consumo = (this.velocidade>=100.0)?LITROSKM9:LITROSKM7;
	}
	
	public double getConsumo()�{
		return consumo:
	}
 	
	public double calcularImporte() {
		this.importe = this.consumo * this.distancia * this.prezo;
		return this.importe;
	}
	 */

	private double percorrido;	//km
	private double velocidade;	//km/h
	private double prezo;		//EUR/l
	private double custe;		//EUR
	private double consumo;		//l/km
	private static final double LITROSKM7 = 7.0/100.0;
	private static final double LITROSKM9 = 9.0/100.0;
	private static final double LIMITE = 100.0;
	PrintStream flujoS = System.out;
	
	public Viaxe(double percorrido, double velocidade, double prezo) {
		super();
		this.percorrido = percorrido;
		this.velocidade = velocidade;
		this.prezo = prezo;
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
	
	public void setPercorrido() {
		do {
			flujoS.print("Recorrido a circular en km: ");
			this.percorrido = valorDoubleCorrecto();
		} while(percorrido < 0.0);		
	}

	public void setVelocidade() {
		do {
			flujoS.print("Velocidade circulacion km/h: ");
			this.velocidade = valorDoubleCorrecto();
		} while(velocidade < 0.0);
	}

	public void setPrezo() {
		do {
			flujoS.print("Prezo de gasolina en EUR/l: ");
			this.prezo = valorDoubleCorrecto();
		} while(prezo < 0.0);
	}
	
	public double getConsumo() {
		if (velocidade >= LIMITE)
			consumo = LITROSKM9;	//(/km)
		else consumo = LITROSKM7;	//(l/km)
		return consumo;
	}
	
	public double getCuste() {
		custe = getConsumo()*percorrido*prezo;
		custe = Math.round(custe * 100)/100d;
		return custe;
	}

	public static void main(String[] args) {
		/*double dist = 250.0;
		double vel = 120.0;
		double prezo = 1.5;
		
		Consumo consumo = new Consumo(dist, vel, prezo);
		System.out.println(consumo.calculaImporte());
		double resultado = dist * LITROSKM9 * prezo *
		*/
		
		Viaxe viaxe = new Viaxe(0.0,0.0,0.0);
		viaxe.setPercorrido();
		viaxe.setVelocidade();
		viaxe.setPrezo();
		System.out.println
		("Coste total del recorrido "+viaxe.getCuste()+" euros");
	}
}
