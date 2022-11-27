package compilador26_34;

public class compi29 {

	public static void main(String[] args) {
		int num1 = 0, num2 = 1, suma = 1;
		for(int i = 1; i <= 16; i++) { 
			System.out.println(suma);
			suma = num1 + num2;
			num1 = num2;
			num2 = suma;
		}
	}
}
