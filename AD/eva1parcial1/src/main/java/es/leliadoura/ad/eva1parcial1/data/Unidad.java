package es.leliadoura.ad.eva1parcial1.data;

import java.io.Serializable;

/**
 *
 * @author marco
 */
public class Unidad implements Serializable{
    
    private String titulo;
    private String descripcion;

    public Unidad() {
    }

    public Unidad(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Unidad{" + "titulo=" + titulo + ", descripcion=" + descripcion + '}';
    }
    
}
