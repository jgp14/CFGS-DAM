package cualificacions;

public class CualificacionApp {

	public static void main(String[] args) {
	
		Cualificacion cualificacion = new Cualificacion(10, 2, 4.9);
		//Cualificacion cualificacion2 = new Cualificacion(10, 2, 4.9);

		//cualificacion.setC1(10);
		//cualificacion.setC2(6);
		//cualificacion.setT(4.3);

		double notaFinal = cualificacion.global();
		System.out.print("Cualificacion final ");
		if (notaFinal >= 5.0) {
			System.out.print("Aprobado : ");
			System.out.print(notaFinal);
		} else {
			System.out.print("Suspenso : ");
			System.out.print(notaFinal);
		}
	}
}
