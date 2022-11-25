package es.leliadoura.ad.eva1parcial1.ejercicio3;

import es.leliadoura.ad.eva1parcial1.data.Alumno;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dam205
 */
public class ListaAlumnos implements Serializable{
    private List<Alumno> alumnos;

    public ListaAlumnos() {
        this.alumnos = new ArrayList<>();
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> listaA) {
        this.alumnos = alumnos;
    }
    
    @Override
    public String toString() {
        return alumnos.toString();
    }
    
}
