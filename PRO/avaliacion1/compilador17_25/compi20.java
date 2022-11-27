package compilador17_25;

public class compi20 {

	public static void main(String[] args) {
		
		int num1 = 0, num2 = 1, suma = 1;

		while(suma < 1000) {			
			System.out.println(suma);			
			suma = num1 + num2;		
			num1 = num2;		
			num2 = suma;
		}
	}
}
