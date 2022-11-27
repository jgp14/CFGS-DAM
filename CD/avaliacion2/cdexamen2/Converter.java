package cdexamen2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Converter {

	private double valorRublo;
	private double valorEuro;
	private double cantidade;
	private double resultado;

	// opción 0, realizar conversión de rublos a euros
	// opción 1, realizar conversión de euros a rublos
	private int opcion;

	public Converter(Unit unit, int opcion) {
		super();
		this.valorRublo = unit.getRublo();
		this.valorEuro = unit.getEuro();
		this.cantidade = unit.getCantidade();
		this.opcion = getOpcion();
		this.resultado = this.convert();
	}
	
	public double convert() {

		if (this.opcion == 0) {
			this.resultado = this.cantidade * this.valorRublo;
		} else if (this.opcion == 1){
			this.resultado = this.cantidade * this.valorEuro;
		}

		return this.resultado;
	}
	
	public int getOpcion() {
		do {
			System.out.println("0 para de rublos a euros");
			System.out.println("1 para de euros a rublos");
			System.out.print("Dame opcion: ");
			this.opcion = valorIntCorrecto();
		}while(opcion < 0 || opcion > 1);
		return opcion;
	}
	
	private static String dato() {
		String sdato = "";
		try {
			InputStreamReader isr = 
			new InputStreamReader(System.in);
			BufferedReader flujoE = new BufferedReader(isr);
			sdato = flujoE.readLine();
		}catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
		return sdato;
	}
	
	private static int datoInt() {
		try {
			return Integer.parseInt(dato());
		}catch (NumberFormatException e) {
			return Integer.MIN_VALUE;
		}
	}
	
	private int valorIntCorrecto() {
	    int i = datoInt();
	    while(i == Integer.MIN_VALUE) {
	    	System.out.print("Dame un numero entero: ");
	    	i = datoInt();
	    }
	    return i;
	}

}