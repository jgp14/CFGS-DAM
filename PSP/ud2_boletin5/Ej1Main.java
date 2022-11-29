package ud2_boletin5;

public class Ej1Main {

	public static void main(String[] args) throws InterruptedException{
		int n1 = 5, n2 = 7;
		Ej1Factorial hilo1 = new Ej1Factorial(n1);
		Ej1Fibonacci hilo2 = new Ej1Fibonacci(n2);
		
		System.out.print("El factorial de : "+n1+" es ");
		hilo1.start();
		hilo1.join();
		System.out.print("El resultado de Fibonacci del numero: "+n2+" es ");
		hilo2.start();
	}

}
