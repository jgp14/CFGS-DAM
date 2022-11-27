package ecuacion;

public class EcuacionApp {
	public static void main(String[] args) {
		Ecuacion ecuacion = new Ecuacion();
		
		ecuacion.setA(1);
		ecuacion.setB(10);
		ecuacion.setC(2);
		
		/*System.out.println(ecuacion.x1());
		System.out.printlnecuacion.x2());*/
		
		double x1 = ecuacion.x1();
		double x2 = ecuacion.x2();
		
		System.out.println(x1);
		System.out.println(x2);
	}
}
