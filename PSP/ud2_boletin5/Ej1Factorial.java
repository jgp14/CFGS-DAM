package ud2_boletin5;

public class Ej1Factorial extends Thread{

	private int n, fact;
	
	public Ej1Factorial(int n) {
		this.n = n;
	}
	
	public void run() {
		for(int i=1;i<=n;i++)
			fact=fact*i;
	}
	
	public int factorialRecursivo(int n) {
		if(n == 0)
			n = 1; 
		else 
			n = n * factorialRecursivo(n-1);
		return n; 
	}
}
