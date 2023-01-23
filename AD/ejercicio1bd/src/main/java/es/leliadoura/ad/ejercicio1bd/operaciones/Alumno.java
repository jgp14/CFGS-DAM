package es.leliadoura.ad.ejercicio1bd.operaciones;

/**
 *
 * @author dam205
 */
public class Alumno {
    private String dni;
    private String nombre;
    private String apellidos;
    private Integer edad;

    public Alumno() {
    }
    
    public Alumno(String dni, String nombre, String apellidos, Integer edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Alumno{" + "dni=" + dni + ", nombre=" + nombre + 
                ", apellidos=" + apellidos + ", edad=" + edad + '}';
    }
    
}
