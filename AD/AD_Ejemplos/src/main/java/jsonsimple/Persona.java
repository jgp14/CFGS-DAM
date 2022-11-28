package jsonsimple;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marco
 */
public class Persona {
    
    private String nombre;
    private Long edad;
    private Double salario;
    private List<String> aficiones;

    public Persona() {
        this.aficiones = new ArrayList<>();
    }
    
    public Persona(String nombre, Long edad, Double salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
        this.aficiones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getEdad() {
        return edad;
    }

    public void setEdad(Long edad) {
        this.edad = edad;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public List<String> getAficiones() {
        return aficiones;
    }

    public void setAficiones(List<String> aficiones) {
        this.aficiones = aficiones;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", edad=" + edad + ", salario=" + salario + ", aficiones=" + aficiones + '}';
    }
    
    
    
    
    
}
