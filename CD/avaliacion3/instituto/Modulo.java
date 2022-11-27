package instituto;

public class Modulo {

    private String denominacion;
    private int curso;

    public Modulo(String denominacion, int curso) {
        this.denominacion = denominacion;
        this.curso = curso;
    }

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public int getCurso() {
		return curso;
	}

	public void setCurso(int curso) {
		this.curso = curso;
	}
    
    
}
