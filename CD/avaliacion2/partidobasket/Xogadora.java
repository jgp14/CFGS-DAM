package partidobasket;

public class Xogadora {
	
	@SuppressWarnings("unused")
	private String dni;
	private int puntos;
	
	public Xogadora(String dni, int puntos) {
		super();
		this.dni = dni;
		this.puntos = puntos;
	}

	public int getPuntos() {
		return puntos;
	}
	
}
