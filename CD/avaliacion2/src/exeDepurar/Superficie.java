package exeDepurar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Superficie {
	
	private int positivo;		//solo positivos no nulos
	private int altura;	
	private int base;
	private int area;	
	private String unidades;	//unidades del rectangulo
	private Scanner teclado = new Scanner(System.in);

	public Superficie(int altura, int base, String unidades) {
		super();
		this.altura = altura;
		this.base = base;
		this.unidades = unidades;
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

	private void valorPositivo() {
		if(positivo < 0 || positivo == '\0') {
			System.out.println("Mensaje de error");
			base = 0; altura = 0;
			System.out.println("Area del rectangulo: "
			+getArea()+" "+getUnidades());
			System.exit(0);
		}	
	}

	public void setAltura() {
		System.out.print
		("Dame ALTURA del rectangulo: ");
		this.altura = datoInt();
		positivo = this.altura;
		valorPositivo();
	}

	public void setBase() {
		System.out.print
		("Dame BASE del rectangulo: ");
		this.base = datoInt();
		positivo = this.base;
		valorPositivo();
	}
	
	public int getArea() {
		area = base * altura;
		return area;
	}
	
	public void setUnidades() {
		System.out.print("Dame las UNIDADES del rectangulo: ");
		unidades = teclado.next();
	}
	
	public String getUnidades() {
		return unidades;
	}
	
	public static void main(String[] args) {
		Superficie superficie = new Superficie(1, 1, "m");
		superficie.setUnidades();
		superficie.setBase();
		superficie.setAltura();
		System.out.println("El area del rectangulo es de "
		+superficie.getArea()+" "+superficie.getUnidades());
	}
}
