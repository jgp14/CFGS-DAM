package exeProbas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class MaquinaBebidas {
	
	private static final int numPro = 4;
	private String[] producto = new String[numPro];
	private int[] stock = new int[numPro];
	private double[] importe = new double[numPro];
	private int cod;
	private int resto;
	private double prezo;
	private double pago;
	PrintStream flujoS = System.out;


	public MaquinaBebidas(String[] producto, int[] stock, double[] importe, int cod) {
		super();
		this.producto = producto;
		this.stock = stock;
		this.importe = importe;
		this.cod = cod;
	}
	
	public void menu() {
		flujoS.println("   MENU DE MAQUINA DE BEBIDAS");
		flujoS.println("   ==========================");
		flujoS.println("   Codigo Importe Producto");
		for(cod = 0; cod < numPro; cod++)
			System.out.println
			("    "+cod+"---> "+importe[cod]+"€ -> "+producto[cod]);
		flujoS.println("");
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
	
	private void setProducto() {
		for (cod = 0; cod < numPro; cod++) {
			flujoS.print
			("Dame nome do artigo con codigo "+cod+": ");
			producto[cod] = dato();
		}	
	}
	
	private void setStock() {
		for (cod = 0; cod < numPro; cod++) {
			do {
				flujoS.print("Stock do artigo con codigo "+cod+": ");
				stock[cod] = valorIntCorrecto();
			} while(stock[cod] < 0);
		}	
	}
	
	private void setImporte() {
		for (cod = 0; cod < numPro; cod++) {
			do {
				flujoS.print
				("Dame importe do artigo con codigo "+cod+": ");
				importe[cod] = valorDoubleCorrecto();
			} while(importe[cod] < 0.0);
		}	
	}
	
	public void introducirDatos() {
		setProducto(); 	flujoS.println("");
		setStock(); 	flujoS.println("");
		setImporte(); 	flujoS.println("");
	}
	
	private String getProducto() {
		return producto[cod];
	}
	
	private int getStock() {
		return stock[cod];
	}	
	
	public double getImporte() {
		return importe[cod];
	}
	
	public void setCodigo() {
		do {
			flujoS.print("Codigo do artigo a mercar "
					+ "do 0 a o "+(numPro-1)+": ");
			cod = valorIntCorrecto();
		} while(cod >= numPro || cod < 0);
	}
	
	public int getCodigo() {
		return cod;
	}
	
	public boolean avisoStock() {
		boolean aviso = false;
		int cifraAlerta = 4;
		if(getStock() <= cifraAlerta)
			aviso = true;
		return aviso;
	}
	
	public void mostraAviso() {
		if(avisoStock() == true) 
			flujoS.println("AVISO, quedan solo "+getStock()+" en stock");
	}
	
	public double getPrezo() {
		prezo = importe[cod];
		return prezo;
	}

	private int getResto() {
		resto = getStock()-1;
		return resto;
	}

	public void restoExistencias() {
		flujoS.print("O cliente pediu 1 "+getProducto());
		resto = getStock()-1;
		if(resto < 0) {
			flujoS.print(" e non quedan artigos en stock, bloquease a venda.");
			prezo = 0.0;
		}
		else if(resto == 0) flujoS.print(" e quedan 0 en stock.");
		else flujoS.print(" e quedan "+getResto()+" en stock.");
		flujoS.println("\nA un precio de "+getImporte()+
				" EUR por unidad y acumulado de "+prezo+" EUR.");
	}
	
	public boolean continuarCompra() {
		boolean continuar = false;
		int opcion;
		 do {
			 flujoS.print
			("\n¿Desea continuar las compras? Pon: '0' false o '1' true: ");
			opcion = datoInt();
			if(opcion == 1)
				continuar = true;
			else if(opcion == 0)
				continuar = false;
		}while (opcion != 0 &&  opcion != 1);
		return continuar;
	}	
	
	public void setPago() {
		do {
			flujoS.print("Introduzca pago dos artigos totales: ");
			pago = valorDoubleCorrecto();
		}while(pago <= 0.0);
	}

	public double getPago() {
		return pago;
	}
}
