package ecuacionrecta;

import java.util.Scanner;

public class Recta {
	
	/*
	private Punto a; 
	private Punto b;
	private int pendente; 
	private int ordenada;
	
	public Recta(Punto a, Punto b){
		super();
		this.a = a;
		this.b = b; 
	}
	
	private static int calculaPendente(Punto A, Punto B){
		int m = (this.b.getY()-this.a.getY())/(this.b.getX()-a.getX());
	}
	
	private int calcularOrdenada
	(int abscisa, int pendente, Punto p){
		//ordenada é o valor y que lle corresponde á abscisa
		int ordenada = this.b.getY() + pendente *
		return ordenada;
	}
	 */
	
	private float a1, b1, a2, b2;
	private float m;
	private static Scanner scanner = new Scanner(System.in);
	
	private static final String A1 = "Punto A, abscisa x0 = ";
	private static final String B1 = "Punto A, ordenada y0 = ";
	private static final String A2 = "Punto B, abscisa x0 = ";
	private static final String B2 = "Punto B, ordenada y0 = ";
	private static final String ECU = "Valor abscisa x = ";
	private static final String PEN = 
			"Valor pendente da recta m = ";

	public Recta() {
		super();
		this.a1 = damePunto(A1);
		this.b1 = damePunto(B1);
		this.a2 = damePunto(A2);
		this.b2 = damePunto(B2);
	}
	
	public Recta(Punto punto1, Punto punto2) {
		this.a1 = punto1.getX();
		this.b1 = punto1.getY();
		this.a2 = punto2.getX();
		this.b2 = punto2.getY();
	}
	
	public void  menu() {
		System.out.println("\nElige opcion: ");
		System.out.println("1. Dame punto A ");
		System.out.println("2. Dame punto B ");
		System.out.println("3. Calcula punto P ");
		System.out.println("4. Sair da app ");
	}
	
	public int dameOpcion() {
		int opcion;
		do { opcion = scanner.nextInt();
		}while (opcion <= 0 || opcion > 4);
		return opcion;
	}

	public int damePunto(String msg) {
		System.out.print(msg);
		int punto = scanner.nextInt();
		return punto;
	}
	
	public String amosaPuntoA() {
		Punto A = new Punto(a1, b1);
		return A.toString();
	}
	
	public String amosaPuntoB() {
		Punto B = new Punto(a2, b2);
		return B.toString();
	}
	
	public float pendente() {
		System.out.println(PEN); 
		m = (float)(b2-b1)/(float)(a2-a1);
		return m;
	}
	
	public float calculoRecta(float xx0, float mm ) {
		float yy0;
		yy0 =  b2 + m *(xx0-a2);
		return yy0;
	}
	
	public String ecuacionRecta(float m) {
		System.out.println(ECU);
		float x0 = scanner.nextFloat();
		float y0 = calculoRecta(x0, m);
		// float y0 =  b2 + m *(x0-a2);
		Punto P = new Punto(x0, y0);
		return P.toString();
	}
	
}
