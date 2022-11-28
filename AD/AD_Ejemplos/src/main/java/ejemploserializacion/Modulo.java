package ejemploserializacion;

import java.io.Serializable;

/**
 *
 * @author marco
 */
public class Modulo implements Serializable{
    private String codigo;
    private Integer horasSemanales;
    private String nombre;

    public Modulo(String codigo, Integer horasSemanales, String nombre) {
        this.codigo = codigo;
        this.horasSemanales = horasSemanales;
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getHorasSemanales() {
        return horasSemanales;
    }

    public void setHorasSemanales(Integer horasSemanales) {
        this.horasSemanales = horasSemanales;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Modulo{" + "codigo=" + codigo + ", horasSemanales=" + horasSemanales + ", nombre=" + nombre + '}';
    }
    
    
    
}
