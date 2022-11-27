package dioxido;

public class Contaminacion {

	private static final int LIMITE=  500;
	private int cantidade;
	private boolean sancionabel;
	
	public Contaminacion(int cantidade) {
		super();
		this.cantidade = cantidade;
		this.sancionabel = this.verificarPenalizacion();
	}

	public boolean verificarPenalizacion() {
		
		if(this.cantidade >= LIMITE)
			return true;
		else return false; 
		
	}
	
	public int getCantidade() {
		return cantidade;
	}

	public void setCantidade(int cantidade) {
		this.cantidade = cantidade;
	}

	public boolean isSancionabel() {
		return sancionabel;
	}


	@Override
	public String toString() {
		return "Contaminacion [cantidade=" + cantidade + ", sancionabel=" + sancionabel + ", getCantidade()="
				+ getCantidade() + ", isSancionabel()=" + isSancionabel() + ", verificarPenalizacion()="
				+ verificarPenalizacion() + "]";
	}
	
	
	
	
	
	
	
	
}
