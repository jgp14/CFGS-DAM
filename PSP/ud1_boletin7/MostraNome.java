package ud1_boletin7;

public class MostraNome {
	
	public static void main(String[] args) {
		Runtime r = Runtime.getRuntime();
		if(args.length <= 0) {
			System.err.println("Se necesita un nombre a mostrar");
			System.exit(-1);
		}
		ProcessBuilder pb = new ProcessBuilder(args);
	}
	
}
