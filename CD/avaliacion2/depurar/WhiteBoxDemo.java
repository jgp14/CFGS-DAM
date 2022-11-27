//Depura o seguinte código para comprobar:
//1. Que valor inicial ten x
//2. Cal é o resultado de cada caso no método main().
//3. Que valor toma a variábel temp en cada execución de verifyValue().
//4. Que retorna o método verifyValue() no último return.
//5. Resulta posíbel unha actualización da variábel temp?

package depurar;

public class WhiteBoxDemo {

	private int x;
	private final static int LIMIT = 100;

	public boolean verifyValue(int value) {

		if (x > value) {
			return true;
		} else if ((x <= value) && (x >= 0))
			return false;
		@SuppressWarnings("unused")
		int temp = 0;
		if (value < LIMIT)
			temp = value;

		return (this.x == 0) ? false : true;
	}
	
	public static void main(String[] args) {
		WhiteBoxDemo whiteBoxDemo = new WhiteBoxDemo();
		boolean res1 = whiteBoxDemo.verifyValue(-200);
		System.out.println(res1);
		boolean res2 = whiteBoxDemo.verifyValue(200);
		System.out.println(res2);
		boolean res3 = whiteBoxDemo.verifyValue(300);
		System.out.println(res3);

	}
	//Solucions:
	//1. x ten valor inicial de cero x = 0
	//2. 1º caso o valor de x = 0 é maior que -200 da true
	//	 2º caso o valor de x = 0 é menor  que 200 
	// 	 e igual a cero polo que res2 da false
	//	 3º caso o valor de x = 0 é menor  que 300 
	// 	 e igual a cero polo que res3 da false
	//3. 1º temp = -200, 2º temp = 0, 3º temp = 0
	//4. Retorna true o false dependendo se x == 0 ou non
	//5. Si resulta posible 
	
}
