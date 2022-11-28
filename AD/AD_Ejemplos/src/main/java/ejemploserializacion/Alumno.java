package ejemploserializacion;

import java.io.Serializable;

/**
 *
 * @author marco
 */
public class Alumno implements Serializable{
    
    private String dni;
    private String nombre;

    public Alumno(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Alumno{" + "dni=" + dni + ", nombre=" + nombre + '}';
    }
    
    
    
}
