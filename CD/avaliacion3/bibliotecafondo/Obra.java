package bibliotecafondo;

public class Obra {

	private String titulo;
	private String autor;
	private String linguaOr;
	
	public Obra(String titulo, String autor, String linguaOr) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.linguaOr = linguaOr;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getLinguaOr() {
		return linguaOr;
	}

	public void setLinguaOr(String linguaOr) {
		this.linguaOr = linguaOr;
	}
	
	
	
}
