package exeDepurar;

import java.io.*;

public class Comision {
	
	//Primer ejempo resuelto del profesor
	/*private int[] comisions = new int[12];
	private final int MINIMO = 50000;
	
	public Comision(int[] valores) {
		this.comisions = valores;
	}
	
	private int sumarValores() {
		int suma = 0; 
		for (int k = 0; k < this.comisions.length; k++)
			suma += this.comisions[k];
		return suma;
	}
	
	public boolean cobrarComision() {
		return (this.sumarValores() >= MINIMO) ? true : false;
	}
	
	public static void main (String[] args) {
		
		int[] valores = new int[] {8000,8000,10080,8000,
				8000,80,8000,80,8000,8000,8000,8000};
		Comision comision = new Comision(valores);
		System.out.println(comision.cobrarComision());
	}*/
	
	
	//Segundo ejemplo resuelto del profesor 
	/*private static final int LIMITE = 50000;
	private boolean comision = false;
	int[] valores = new int[6];
			
	public Comision(int[] datosVenda) {
		this.valores = datosVenda;
		this.comision = this.cobrarComision();
			
	}
	
	public boolean cobrarComision() {
		boolean cobrar = false;
		if(sumarVendas()>=LIMITE)
				cobrar = true;
		return cobrar;
	}
	
	private int sumarVendas() {
		int suma = 0;
		for(int k = 0; k < this.valores.length; k++)
			suma += this.valores[k];
		return  suma;
	}
	
	public String resultadoComision() {
		return "Cobra comision? ".concat(String.valueOf(comision));
	}
	
	public static void main(String[] args) {
		int[] valores = new int[] 
		{12000,20000,20000,2000,2000,2000};
		Comision comision = new Comision(valores);
		System.out.println(comision.resultadoComision());
	}*/

	private double[] ventas = new double[3];   //12 meses
	private boolean comision; 			//si o no comision
	private int porcentaje; 			//porcentaje cobro
	private int i;						//indice
	private static final double LIMITE = 50000.0; //Limite
	
	private double suma;				//valore total mes
	private double valorcomision;		//comision en euro
	PrintStream flujoS = System.out;
	
	public Comision
	(double[] ventas, boolean comision, int porcentaje) {
		super();
		this.ventas = ventas;
		this.comision = comision;
		this.porcentaje = porcentaje;
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
	    	flujoS.print("Dame un numero entero: ");
	    	i = datoInt();
	    }
	    return i;
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
	
	public void inicializaArray() {
		for (i = 0; i < ventas.length; i++) {
			do {
				flujoS.print("Ventas no mes "+(i+1)+": ");
				ventas[i] = valorDoubleCorrecto(); 
			} while(ventas[i] <= 0.0);	
			suma += ventas[i]; 
		}	
	}
	
	public boolean setBooleanComision() {
		comision = (this.suma >= LIMITE)?true:false;
		return comision;
	}
	
	public void setComision() {
		setBooleanComision();
		if (comision = true) 
			flujoS.print("Si cobran comision");
		else 
			flujoS.print("No cobran comision");
		flujoS.print(" por ventas totales de: "+suma+" EUR");
	}
	
	public void porcentajeComision() {
		do {
			flujoS.print("\nPorcentaje (%) de comision: ");
			porcentaje = valorIntCorrecto();
		} while (porcentaje <= 0 || porcentaje > 100);
	}
	
	public double valorComision() {
		if(comision == true) {
			porcentajeComision();
			valorcomision = suma * porcentaje/100;
		} else valorcomision = 0;
		return valorcomision;
	}
	
	public void mostraValorComision() {
		flujoS.println
		("Porcentaje (%) de comision del "+porcentaje+"%");
		flujoS.println
		("Cobrara "+valorcomision+" EUR sobre as ventas");
	}
	
	public static void main(String[] args) {
		double [] ventas = new double[] {0,0,0};
		Comision comision = new Comision(ventas, false, 0);
		comision.inicializaArray();
		comision.setComision();
		comision.valorComision();
		comision.mostraValorComision();
	}
}
