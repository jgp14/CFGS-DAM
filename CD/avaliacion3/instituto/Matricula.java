package instituto;

import java.util.Date;

public class Matricula {

    private Date data;
    private Avaliacion avaliacion;

    private Alumno alumno;
    private Ciclo ciclo;

    public Matricula(Date data, Avaliacion avaliacion, Alumno alumno, Ciclo ciclo) {
        this.data = data;
        this.avaliacion = avaliacion;
        this.alumno = alumno;
        this.ciclo = ciclo;
    }

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Avaliacion getAvaliacion() {
		return avaliacion;
	}

	public void setAvaliacion(Avaliacion avaliacion) {
		this.avaliacion = avaliacion;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Ciclo getCiclo() {
		return ciclo;
	}

	public void setCiclo(Ciclo ciclo) {
		this.ciclo = ciclo;
	}
    
    
}
