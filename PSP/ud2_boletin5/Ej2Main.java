package ud2_boletin5;

public class Ej2Main {

	public static void main(String[] args) {
		Ej2Factorial[] hilosFact = new Ej2Factorial[10];
		int x=0;
		for(int i=5;i<=14;i++) {
			hilosFact[x]=new Ej2Factorial(i);
			hilosFact[x].start();
			x++;
		}//for
		System.out.println("Programa principal terminado");
	}

}
