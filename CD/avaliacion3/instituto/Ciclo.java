package instituto;

import java.util.List;

public class Ciclo {

    private String familiaProfisional;
    private String denominacion;
    private String refCurriculum;

    private List<Modulo> modulos;

    public Ciclo(String familiaProfisional, String denominacion, String refCurriculum, List<Modulo> modulos) {
        this.familiaProfisional = familiaProfisional;
        this.denominacion = denominacion;
        this.refCurriculum = refCurriculum;
        this.modulos = modulos;
    }

	public String getFamiliaProfisional() {
		return familiaProfisional;
	}

	public void setFamiliaProfisional(String familiaProfisional) {
		this.familiaProfisional = familiaProfisional;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public String getRefCurriculum() {
		return refCurriculum;
	}

	public void setRefCurriculum(String refCurriculum) {
		this.refCurriculum = refCurriculum;
	}

	public List<Modulo> getModulos() {
		return modulos;
	}

	public void setModulos(List<Modulo> modulos) {
		this.modulos = modulos;
	}

    
}
