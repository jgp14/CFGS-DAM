package partidobasket;

public class Equipo {

	private static final int XOGADORAS = 2;
	private Xogadora[] xogadoras = new Xogadora[XOGADORAS];
	@SuppressWarnings("unused")
	private int xornada;
	private int suma;
	
	public Equipo(Xogadora[] xogadoras, int xornada) {
		super();
		this.xogadoras = xogadoras;
		this.xornada = xornada;
	}

	public Xogadora[] getXogadoras() {
		return xogadoras;
	}
	
	public int sumaEquipo() {
		Xogadora[] xogadoras = this.xogadoras;
		for(int k = 0; k < this.getXogadoras().length; k++)
    		this.suma += xogadoras[k].getPuntos();
    	return this.suma;
	}
	
}
