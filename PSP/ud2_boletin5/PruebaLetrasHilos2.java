package ud2_boletin5;

public class PruebaLetrasHilos2 {

	public static void main(String[] args) {
		if (args.length!=1) {
			System.out.println("Hay que introducir un argumento");
			System.exit(0);
		} 
		LetrasHilos Instancia = new LetrasHilos(args[0]);
	}
	
}
