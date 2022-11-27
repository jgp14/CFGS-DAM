package instituto;

import java.util.List;

public class Departamento {

    private String nome;
    private List<Profesor> profesores;
    private List<Ciclo> ciclos;

    public Departamento(String nome, List<Profesor> profesores, List<Ciclo> ciclos) {
        this.nome = nome;
        this.profesores = profesores;
        this.ciclos = ciclos;
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(List<Profesor> profesores) {
		this.profesores = profesores;
	}

	public List<Ciclo> getCiclos() {
		return ciclos;
	}

	public void setCiclos(List<Ciclo> ciclos) {
		this.ciclos = ciclos;
	}

    
}
