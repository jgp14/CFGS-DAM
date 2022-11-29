package ud2_boletin5;

public class Ej2Factorial extends Thread{

	private int n, fact = 0;
	
	public Ej2Factorial(int n) {
		this.n = n;
	}

	public void run() {
		System.out.println
		("Empieza el proceso .....Calculo del factorial de: "+n);
		fact = factorialRecur(n);
		System.out.println
		("Acabo el proceso .....El factorial de : "+n+" es: "+fact);
	}
	
	public int factorialRecur(int n) {
		if(n == 0)
			n = 1; 
		else 
			n = n * factorialRecur(n-1);
		return n; 
	}
}
