package elementos;

public class ElementosApp {

	public static int f(int x) { //a funcion coincide co metodo
		return x + 1;
	}
	
	public static void main(String[] args) {
		
		//declaraci�n de variabeis
		//referencian unha posicio�n de memoria RAM
		//conte�en un dato dun rango dado
		//$ABCD:$0123 -> dataNacemento
		//tipo: def�nea, rango. int, double, char, byte
		int x;
		double y;
		String nome;
		double a;
		boolean si; 
		
		//expresi�ns
		a = 5.3; //asignaci�n
		si = true;
		x = 2;
		y = Math.sqrt(a);
		si = (x>0?true:false); //true
		
		//sentenzas, frases, sentences
		//Decisi�n
		if(x>0)
			si = true;
			else
				si = false;
		
		//Iterativas, bucles, lazos
		int n = 0;
		while (n<10) //contamos 10 pasos, de 0 a 9
			n++;
			//n = n + 1
		for (int i = 0; i < 100; i++) {
			System.out.println(i);
		}
		/*while (true) {
			//fai algo, executa sentenzas
			System.out.println(a);
		}*/
	
		//funci�n: bloque de c�digo que ten un nome
		//ou sinatura, que recebe par�metros ou argumentos
		// e produce un resultado
		//f(x) = x + 1;
		int m = f(200);
		System.out.println(f(300));
		System.out.println(m);
	}

}
