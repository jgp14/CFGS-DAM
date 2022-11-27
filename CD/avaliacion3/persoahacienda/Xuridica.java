package persoahacienda;

public class Xuridica {

	private String[] titulares;
	private int capitalizacion;
	private int beneficios;
	
	public Xuridica(String[] titulares, int capitalizacion, int beneficios) {
		super();
		this.titulares = titulares;
		this.capitalizacion = capitalizacion;
		this.beneficios = beneficios;
	}

	public String[] getTitulares() {
		return titulares;
	}

	public void setTitulares(String[] titulares) {
		this.titulares = titulares;
	}

	public int getCapitalizacion() {
		return capitalizacion;
	}

	public void setCapitalizacion(int capitalizacion) {
		this.capitalizacion = capitalizacion;
	}

	public int getBeneficios() {
		return beneficios;
	}

	public void setBeneficios(int beneficios) {
		this.beneficios = beneficios;
	}
	
	
	
}
