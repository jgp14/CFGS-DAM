package teoria.capitulo10;

public class Clase1 {

	public static void main(String[] args) {
		// Clase2 obj = new Clase2();
		// obj.metClase2(1,2);
	}

	public class Clase2{
		public void metClase2(int x, final int y) {
			int i = x + y;
			final int c = x + y;
			class Clase3{
				// int a = x; // error: x no es final
				int b = y;
				void metClase3() {
					System.out.println(b+i); 
					// error: i no es final
					System.out.println(b + c);
				}
			}
			Clase3 obj = new Clase3();
			obj.metClase3();
		}
	}
}
