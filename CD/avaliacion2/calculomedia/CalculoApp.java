package calculomedia;

public class CalculoApp {
	
    private static final int MAX_NUM = 4;

	public static void main(String[] args) {
		//double [] numeros = new double[] {0.0,2.0,4.0,6.0};
		System.out.println("\nDame valores calcular media: ");
		Calculo calculo = new Calculo();
		double suma = calculo.getSuma();
		double media = calculo.getMedia();
		System.out.println
		("Media e ("+suma+"/"+MAX_NUM+") = "+media);
	}
}
