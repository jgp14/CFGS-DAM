package heranza;

public class RectanguloApp {

	public static void main(String[] args) {
		
		/*int lado1 = 3;
		int lado2 = 4;
		Rectangulo rectangulo = new Rectangulo(30,40);
		rectangulo.toString();*/
		
		Rectangulo rectangulo = new Rectangulo(200, 500);
		System.out.println(rectangulo.calcularPerimetro());
		System.out.println(rectangulo.calcularSuperficie());
	}

}
