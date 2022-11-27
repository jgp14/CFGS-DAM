package cdexamen;

public class CalculoApp {

	public static void main(String[] args) {
		System.out.println("\nDame valores calcular media: ");
		Calculo calculo = new Calculo();
		calculo.inserirValores();
		double suma = calculo.getSuma();
		double media = calculo.getMedia();
		int largo = calculo.inserirValores().length;
		System.out.println
		("Media e ("+suma+"/"+largo+") = "+media);
	}
}
