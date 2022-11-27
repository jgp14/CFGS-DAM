package instituto;

import java.util.List;

public class Avaliacion {
    private int trimestre;
    private Alumno alumno;
    private List<Modulo> modulos;

    public Avaliacion(int trimestre, Alumno alumno, List<Modulo> modulos) {
        this.trimestre = trimestre;
        this.alumno = alumno;
        this.modulos = modulos;
    }

	public int getTrimestre() {
		return trimestre;
	}

	public void setTrimestre(int trimestre) {
		this.trimestre = trimestre;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public List<Modulo> getModulos() {
		return modulos;
	}

	public void setModulos(List<Modulo> modulos) {
		this.modulos = modulos;
	}
    
    
}
