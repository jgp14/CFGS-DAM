package misClases.avaliacion2;

import java.io.IOException;

public class CRecursivo {
	
	private int[] vector = 
		new int [] {1, 3, 6, 2, 8, 7, 12};
	private char[] cadena = new char[40];
	
	public int longitud() {
		return vector.length;
	}
	
	public void amosa1_N(int n) {
		if(n > 1)
			amosa1_N(n - 1);
		System.out.print("   " + n);
	}
	
	public void amosaN_1(int n) {
		System.out.print("   " + n);
		if (n > 1)
			amosaN_1(n - 1);
	}
	
	public void amosaA_B(int a, int b) {
		System.out.print("   " + a);
		if(a < b)
			amosaA_B(a + 1, b);
	}
	
	public void amosaB_A(int a, int b) {
		if(a < b)
			amosaB_A(a + 1, b);
		System.out.print("   " + a);
	}
	
	public long factorial(long n) {
		long facto;
		if (n > 1L)
			facto = n * factorial(n - 1L);
		else
			facto = 1L;
		return facto;
	}
	
	public int suma1_N(int n) {
		int suma; 
		if(n > 1)
			suma = n + suma1_N(n-1);
		else
			suma = 1;
		return suma;
	}
	
	public int sumaA_B(int a, int b) {
		int suma;
		if(a < b)
			suma = a + sumaA_B((a+1), b);
		else
			suma = b;
		return suma;
	}
	
	public void amosa(int n) {
		if(n > 1)
			amosa(n - 1);
		System.out.print("   " + vector[n - 1]);
	}
	
	public void amosaReves(int n) {
		System.out.print("   " + vector[n - 1]);
		if(n > 1)
			amosaReves(n - 1);
	}
	
	public void recolleCadena() throws IOException {
		char letra = (char) System.in.read(); 
		for(int i = 0; letra != '\r'; i++) {
			cadena[i] = letra;
			letra = (char) System.in.read(); 
		}			
	}
	
	public void amosaRevesCadena(int n) {
		if(cadena[n] != '\0') {
			amosaRevesCadena(n + 1);
			System.out.print(cadena[n]);
		}
	}
	
	public void amosaSenDixitos(int n) {
		if(cadena[n] != '\0') {
			if(cadena[n] < '0' || cadena[n] > '9')
				System.out.print(cadena[n]);
			amosaSenDixitos(n + 1);
		}
	}
	
	public void amosaDixitosDuplicados(int n) {; 
		if(n > 0) {
			amosaDixitosDuplicados(n - 1);
			System.out.print(cadena[n - 1]);
			if(cadena[n - 1] >= '0' && cadena[n - 1] <= '9'){
				System.out.print(cadena[n - 1]);
			}
		}
	}
	
	public int total() {
		int i = 0;
		while (cadena[i] != '\0') i++;
		return i;
	}
	
	//metodos recursivos buscados en internet:
	
	public void amosaVocalesDuplicadas(int n) {
		if(cadena[n] != '\0') {
			System.out.print(cadena[n]);
			if(cadena[n] == 'a' || cadena[n] == 'e'
				|| cadena[n] == 'i' || cadena[n] == 'o'
				|| cadena[n] == 'u')
				System.out.print(cadena[n]);
			amosaVocalesDuplicadas(n + 1);
		}
	}
	
	public void amosaRevesAaEeDuplicados(int n) {
		if(cadena[n] != '\0') {
			amosaRevesAaEeDuplicados(n + 1);
			System.out.print(cadena[n]);
			if(cadena[n] == 'A' || cadena[n] == 'a' 
			|| cadena[n] == 'E' || cadena[n] == 'e')
				System.out.print(cadena[n]);
		}
	}

	public void amosaDixitosDuplicados2(int n) {; 
		if(cadena[n] != '\0') {	
			System.out.print(cadena[n]);
			if(cadena[n] >= '0' && cadena[n] <= '9')
				System.out.print(cadena[n]);
			amosaDixitosDuplicados2(n + 1);
		}
	}
	
	public static int factorial(int n) {
		if(n == 0) return 1;
		else return n * factorial(n - 1);
	}
	
	public void amosaSenVocales(int n) {
		if(cadena[n] != '\0') {
			if(cadena[n] != 'A' && cadena[n] != 'a' 
				&& cadena[n] != 'E' && cadena[n] != 'e'
				&& cadena[n] != 'I' && cadena[n] != 'i' 
				&& cadena[n] != 'O' && cadena[n] != 'o'
				&& cadena[n] != 'U' && cadena[n] != 'u')
				System.out.print(cadena[n]);
			amosaSenVocales(n + 1);
		}
	}

	public void amosaRevesConsonantesDuplicados(int n) {
		if(cadena[n] != '\0') {
			amosaRevesConsonantesDuplicados(n + 1);
			System.out.print(cadena[n]);
			if(cadena[n] != 'A' && cadena[n] != 'a' 
				&& cadena[n] != 'E' && cadena[n] != 'e'
				&& cadena[n] != 'I' && cadena[n] != 'i' 
				&& cadena[n] != 'O' && cadena[n] != 'o'
				&& cadena[n] != 'U' && cadena[n] != 'u')
				System.out.print(cadena[n]);
		}
	}
	
	public void amosaVocalesDuplicadas2(int n) {; 
	if(n > 0) {
		amosaVocalesDuplicadas2(n - 1);
		System.out.print(cadena[n - 1]);
		if(cadena[n - 1] == 'A' || cadena[n - 1] == 'a' 
			|| cadena[n - 1] == 'E' || cadena[n - 1] == 'e'
			|| cadena[n - 1] == 'I' || cadena[n - 1] == 'i' 
			|| cadena[n - 1] == 'O' || cadena[n - 1] == 'o'
			|| cadena[n - 1] == 'U' || cadena[n - 1] == 'u')
			System.out.print(cadena[n - 1]);
		}
	}
	
	public void amosaSenDixitos2(int n) {; 
	if(n > 0) {
		amosaSenDixitos2(n - 1);
		if(cadena[n - 1] < '0' || cadena[n - 1] > '9')
			System.out.print(cadena[n - 1]);
	
		}
	}
}
