package heranza;

public class TrianguloRectApp {

	public static void main(String[] args) {
		
		TrianguloRect  triangulorect = new TrianguloRect(200, 500);
		System.out.println(triangulorect.calcularPerimetro());
		System.out.println(triangulorect.calcularSuperficie());
	}

}
