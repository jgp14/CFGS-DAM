package bibliotecafondo;

public class Catalogo {

	private Exemplar[] listaExemplares;

	public Catalogo(Exemplar[] listaExemplares) {
		super();
		this.listaExemplares = listaExemplares;
	}

	public Exemplar[] getListaExemplares() {
		return listaExemplares;
	}

	public void setListaExemplares(Exemplar[] listaExemplares) {
		this.listaExemplares = listaExemplares;
	}
	
	
	
}
