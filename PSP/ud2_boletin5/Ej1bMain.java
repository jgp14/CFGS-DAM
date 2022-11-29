package ud2_boletin5;

public class Ej1bMain {

	public static void main(String[] args) throws InterruptedException{
		int n1 = 5, n2 = 7;
		Ej1bFactorial objetoA = new Ej1bFactorial(n1);
		Ej1bFibonacci objetoB = new Ej1bFibonacci(n2);
		Thread hilo1 = new Thread(objetoA);
		Thread hilo2 = new Thread(objetoB);
		
		System.out.print("El factorial de : "+n1+" es ");
		hilo1.start();
		hilo1.join();
		System.out.print("El resultado de Fibonacci del numero: "+n2+" es ");
		hilo2.start();

	}

}
