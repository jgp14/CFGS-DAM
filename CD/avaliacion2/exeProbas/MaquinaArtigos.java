package exeProbas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class MaquinaArtigos {

	private static final int artigos = 4;
	private String[] nome = new String[artigos];
	private double[] prezo = new double[artigos];
	private int[] stock = new int[artigos];
	private int cod;
	private int cantidad;
	private double importe;
	private int resto;
	PrintStream flujoS = System.out;
	
	public MaquinaArtigos(String[] nome, double[] prezo, int[] stock, int cod) {
		super();
		this.nome = nome;
		this.prezo = prezo;
		this.stock = stock;
		this.cod = cod;
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
	
	private void setNomes() {
		for (cod = 0; cod < artigos; cod++) {
			flujoS.print("Nome do artigo con codigo "+cod+": ");
			nome[cod] = dato();
		}	
	}
	
	private void setPrezos() {
		for (cod = 0; cod < artigos; cod++) {
			do {
				flujoS.print("Prezo do artigo con codigo "+cod+": "); 
				prezo[cod] = valorDoubleCorrecto();
			} while(prezo[cod] < 0.0);
		}	
	}
	
	private void setStock() {
		for (cod = 0; cod < artigos; cod++) {
			do {
				flujoS.print("Stock do artigo con codigo "+cod+": ");
				stock[cod] = valorIntCorrecto();
			} while(stock[cod] < 0);
		}	
	}
	
	public void introducirDatos() {
		setNomes(); 	System.out.println();
		setPrezos(); 	System.out.println();
		setStock(); 	System.out.println();
	}
	
	private String getNome() {
		return nome[cod];
	}
	
	private double getPrezo() {
		return prezo[cod];
	}
	
	private int getStock() {
		return stock[cod];
	}	
	
	public void setCodigo() {
		do {
			flujoS.print("Codigo do artigo a mercar "
					+ "do 0 a o "+(artigos-1)+": ");
			cod = valorIntCorrecto();
		} while(cod >= artigos || cod < 0);
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
			flujoS.println
			("AVISO, quedan solo "+getStock()+" en stock");
	}
	
	public void setCantidad() {
		do {
			flujoS.print
			("Dame cantidade de artigos a mercar "
					+ "co codigo "+cod+": ");
			cantidad = valorIntCorrecto();
		} while (cantidad < 0);
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public void mostraCantidad() {
		if(getCantidad()==1)
			flujoS.print("O cliente pediu 1 "+getNome());
		else flujoS.print
			("O cliente pediu "+getCantidad()+"  "+getNome()+"s");
	}
	
	public double getImporte() {
		importe = cantidad * prezo[cod];
		return importe;
	}
	
	private int getResto() {
		resto = getStock()-getCantidad();
		return resto;
	}
	
	public void restoExistencias() {
		if(resto < 0) {
			flujoS.print(" e non quedan artigos en stock, bloquease a venda.");
			importe = 0.0;
		}
		else if(resto == 0) flujoS.print(" e quedan 0 en stock.");
		else flujoS.print(" e quedan "+getResto()+" en stock.");
		flujoS.println("\nA un precio de "+getPrezo()+
				" EUR por unidad y acumulado de "+importe+" EUR.");
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
		} while (opcion != 0 &&  opcion != 1);
		return continuar;
	}
}
