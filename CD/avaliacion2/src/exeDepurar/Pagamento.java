package exeDepurar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Pagamento {

	/*private double [] ingresos = new double[12];
	private double totalIve;
	private static final double COTA_IVE = 0.21;
	
	public Pagamento(double[] ingresos) {
		super();
		this.ingresos = ingresos;
	}
	
	private boolean valoresPositivos() {
		boolean positivos = false;
		
		for(int k = 0; k<this.ingresos.length; k++) {
			if (this.ingresos[k] < 0.0)
				return false;
		}
		return true;
	}
	
	public double calcularIve() {
		boolean ok = this.valoresPositivos();
		double suma = 0.0;
		suma = sumar(ok);
		return suma * COTA_IVE;
	}

	private double sumar(boolean ok) {
		double suma = 0.0;
		if (ok) {
			for(int k = 0; k<this.ingresos.length; k++) {
				suma = suma +this.ingresos[k];
			}
		}
		return suma;
	}*/
	
	private double[] valores = new double[3];//tres meses
	private double suma;					 //suma meses
	private double pagamento;				 //iva pagado
	private int i;							 //indice
	private static final double COTA_IVE = 0.21;
	PrintStream flujoS = System.out;
	
	public Pagamento(double[] valores) {
		super();
		this.valores = valores;
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
	
	public void recogerMes() {
		suma = 0;
		for (i = 0; i < valores.length; i++) {
			do {
				flujoS.print("Valor do mes "+(i+1)+": ");
				valores[i] = valorDoubleCorrecto();  
			} while(valores[i] < 0); 
		}
	}
	
	/*private void recogerMesPositivo() {
		while(valores[i] < 0) {
			System.out.print
			("Dame un valor correcto do mes "+(i+1)+": ");
			valores[i] = datoDouble();  
		}	
	}*/
	
	private boolean valoresPositivos() {
		@SuppressWarnings("unused")
		boolean positivos = false;
		
		for(i = 0; i<this.valores.length; i++) {
			if (this.valores[i] < 0.0)
				return false;
		}
		return true;
	}
	
	public double sumarMes() {
		suma = 0.0;
		if(valoresPositivos()) {
			for (i = 0; i < valores.length; i++)
				suma += valores[i];
		}
		return suma;
	}
	
	public double calcularPagamento() {
		pagamento = sumarMes() * COTA_IVE;
		return pagamento;
	}
	
	public String resultadoPagamento() {
		return "Efectua o pagamento de ".concat
				(String.valueOf(pagamento))+" EUR"+
				"\n sobre un valores totais de "+sumarMes();
	}
	
	public static void main(String[] args) {
		/*double[] ingresos = 
			{1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 
			1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0 };
		Pagamento pago = new Pagamento(ingresos);
		double resultado = pago.calcularIve();
		System.out.println(resultado);*/
		
		double[] valores = new double[] 
				{1000.0, 2000.0, 3000.0};
		Pagamento pago = new Pagamento(valores);
		pago.recogerMes();
		pago.calcularPagamento();
		System.out.println(pago.resultadoPagamento());
	}
}
