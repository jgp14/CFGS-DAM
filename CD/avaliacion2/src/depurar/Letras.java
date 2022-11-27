package depurar;

public class Letras {

	private String frase = "";
	@SuppressWarnings("unused")
	private CharSequence letra;
	
	
	
	public Letras(String frase, CharSequence letra) {
		super();
		this.frase = frase;
		this.letra = letra;
	}

	public boolean verificar() {
		boolean verdadeiro = 
				this.frase.contains("")?true:false;
		return verdadeiro;
	}

	public static void main(String[] args) {
		String frase = "Esrtamos a luns por iso "
				+ "nos costa tanto traballar";
		CharSequence letra = "z";
		Letras letras = new Letras(frase, letra);
		System.out.println(letras.verificar());
	}
}
