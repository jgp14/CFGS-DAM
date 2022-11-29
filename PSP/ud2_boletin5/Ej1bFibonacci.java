package ud2_boletin5;

public class Ej1bFibonacci implements Runnable{
	
	private int n1=0, n2=1, n3, n;
	
	public Ej1bFibonacci(int n) {
		this.n = n;
	}
	
	public void run() {
		n3 = fibonacciRecur(n);
		System.out.print(n3);
	}
	
	public int fibonacci(int n) {
		for(int i=2;i<n;++i) {
			n3 = n1 + n2;
			n1 = n2; 
			n2 = n3;
		}
		return n3;
	}
	
	public int fibonacciRecur(int n){
		if(n<2)
			n3 = n;
		else 
			n3 = fibonacciRecur(n-1) + fibonacciRecur(n-2);
		return n3; 
	}
	
}
