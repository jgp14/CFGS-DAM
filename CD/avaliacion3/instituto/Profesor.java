package instituto;

import java.util.List;

public class Profesor {

    private String nome;
    private String dni;
    private String titulacionAcademica;
    private int horas;
    private boolean coordenador;
    private String tutor;

    private List<Ciclo> imparte;

    public Profesor(String nome, String dni, String titulacionAcademica, int horas, boolean coordenador, String tutor, List<Ciclo> imparte) {
        this.nome = nome;
        this.dni = dni;
        this.titulacionAcademica = titulacionAcademica;
        this.horas = horas;
        this.coordenador = coordenador;
        this.tutor = tutor;
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTitulacionAcademica() {
		return titulacionAcademica;
	}

	public void setTitulacionAcademica(String titulacionAcademica) {
		this.titulacionAcademica = titulacionAcademica;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public boolean isCoordenador() {
		return coordenador;
	}

	public void setCoordenador(boolean coordenador) {
		this.coordenador = coordenador;
	}

	public String getTutor() {
		return tutor;
	}

	public void setTutor(String tutor) {
		this.tutor = tutor;
	}

	public List<Ciclo> getImparte() {
		return imparte;
	}

	public void setImparte(List<Ciclo> imparte) {
		this.imparte = imparte;
	}
    
    
}

