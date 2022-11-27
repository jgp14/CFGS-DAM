package ecuacionrecta;

public class RectaApp {
	
	/*
	private static int pedirValor(String mensaxe){
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		return a;
	}
	
	private static int calculaPendente(Punto A, Punto B){
		int m = (B.getY()-A.getY())/(B.getX()-A.getX());
	}
	
	private static int calcularOrdenada
	(int abscisa, int pendente, Punto p){
		//ordenada é o valor y que lle corresponde á abscisa
		int ordenada = p.getY() + m * (abscisa - p.getX());
		return ordenada;
	}
	
	public static void main(String[] args) {`
		
		System.out.print("Punto A, abscisa x0 = ");
		int a1 = pedirValor();
		System.out.print("Punto A, ordenada y0 = ");
		int b1 = pedirValor();
		Punto A = new Punto(a1, b1);
		
		System.out.print("Punto B, abscisa x0 = ");
		int a2 = pedirValor();
		System.out.print("Punto B, ordenada y0 = ");
		int b2 = pedirValor();
		Punto B = new Punto(a2, b2);
		
		int m = calculaPendente(A, B);
		System.out.println(m);
		
		System.out.println("Valor abscisa x = ");
		int abscisa = pedirValor();
		
		int ordenada = calcularOrdenada(abscisa, m, B);
		Punto p = new Punto(abscisa, ordenada);
		System.out.println(p.toString());
		
	}*/
	
	private static final String SAL = "Saindo do aplicativo";
	private static final String ERR = "Opcion erronea, da otra";
		
	public static void main(String[] args) {

		Recta recta = new Recta();
		int opcion;
		do {
			recta.menu();
			opcion = recta.dameOpcion();
			if(opcion == 1) 
				System.out.println(recta.amosaPuntoA()); 
			else if(opcion == 2) 
				System.out.println(recta.amosaPuntoB());
			else if(opcion == 3) {
				float m = recta.pendente();
				System.out.println(m);
				System.out.println(recta.ecuacionRecta(m));
			}
			else if(opcion == 4)
				System.out.println(SAL);
			else
				System.out.println(ERR);
		} while (opcion != 4);
		
	}

}
