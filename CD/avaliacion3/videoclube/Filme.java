package videoclube;

public class Filme {

    private String titulo;
    private String director;
    private int duracion;
    private String nacionalidade;
    private String studio;
    private String idiomaOrixinal;
    private int importe;
    private int prazoEmprestimo;

    public Filme(String titulo, String director, int duracion, 
    		String nacionalidade, String studio, 
    		String idiomaOrixinal, int importe, int prazoEmprestimo) {
        this.titulo = titulo;
        this.director = director;
        this.duracion = duracion;
        this.nacionalidade = nacionalidade;
        this.studio = studio;
        this.idiomaOrixinal = idiomaOrixinal;
        this.importe = importe;
        this.prazoEmprestimo = prazoEmprestimo;
    }

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getStudio() {
		return studio;
	}

	public void setStudio(String studio) {
		this.studio = studio;
	}

	public String getIdiomaOrixinal() {
		return idiomaOrixinal;
	}

	public void setIdiomaOrixinal(String idiomaOrixinal) {
		this.idiomaOrixinal = idiomaOrixinal;
	}

	public int getImporte() {
		return importe;
	}

	public void setImporte(int importe) {
		this.importe = importe;
	}

	public int getPrazoEmprestimo() {
		return prazoEmprestimo;
	}

	public void setPrazoEmprestimo(int prazoEmprestimo) {
		this.prazoEmprestimo = prazoEmprestimo;
	}


}
