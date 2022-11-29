package ud2_boletin5;

public class Ej1Factorial extends Thread{

	private int n, fact = 0;
	
	public Ej1Factorial(int n) {
		this.n = n;
	}

	public void run() {
		fact = factorialRecur(n);
		System.out.println(fact);
	}
	
	public int factorialRecur(int n) {
		if(n == 0)
			n = 1; 
		else 
			n = n * factorialRecur(n-1);
		return n; 
	}
}
