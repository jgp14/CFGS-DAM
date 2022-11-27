package rectangulo;

public class RectanguloApp {

	private static final String LADO1 = "Lado a = ";
	private static final String LADO2 = "Lado b = ";
	private static final String OPCIONS_CALCULO = 
	"Opcion\r\n\t1. Perimetro\r\n\t2. "
	+ "Superficie\r\n\t0. Sair";
	
	public static void main(String[] args) {
		Rectangulo rectangulo = new Rectangulo();
		int a = rectangulo.inserirDato(LADO1);
		int b = rectangulo.inserirDato(LADO2);
		int opcion = rectangulo.inserirDato(OPCIONS_CALCULO);
		rectangulo.menu(a, b, opcion);
	}
	
	
	/*private static final String LADO1 = "Lado a = ";
	private static final String LADO2 = "Lado b = ";
	private static final String OPCIONS_CALCULO = 
	"Opcion\r\n\t1. Perimetro\r\n\t2. "
	+ "Superficie\r\n\t0. Sair"; 
	 
	public static void main(String[] args) {
		Rectangulo rectangulo = new Rectangulo();
		int a = rectangulo.inxerirDato(LADO1);
		int b = rectangulo.inxerirDato(LADO2);
		int opcion;
		opcion = rectangulo.inxerirDato(OPCIONS_CALCULO);
		rectangulo.menu(a, b, opcion);
	}*/
	
}
