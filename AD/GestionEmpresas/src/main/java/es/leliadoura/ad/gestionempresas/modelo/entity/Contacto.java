/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.leliadoura.ad.gestionempresas.modelo.entity;

import com.mysql.cj.util.StringUtils;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author marco
 */
@Entity
@Table(name="CONTACTOS")
public class Contacto implements Serializable{
    
    @Id
    @GeneratedValue
    private Long id;
    @Basic
    @Column(name="nombre", nullable = false)
    private String nombre;
    @Basic
    @Column(name="apellidos", nullable = false)
    private String apellidos;
    @Basic
    @Column(name="correo", nullable = false)
    private String correo;
    @Basic
    @Column(name="telefono", nullable = false)
    private Long telefono;

    public Contacto(){}
    
    public Contacto(String nombre, String apellidos, 
            String correo, Long telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public Long getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        return "Contacto{" + "id=" + id + ", nombre=" + nombre + 
                ", apellidos=" + apellidos + ", correo=" + correo + 
                ", telefono=" + telefono + '}';
    }
    
    public boolean isEmpty(){
        return (
            StringUtils.isEmptyOrWhitespaceOnly(nombre) 
                || StringUtils.isEmptyOrWhitespaceOnly(apellidos) 
                || StringUtils.isEmptyOrWhitespaceOnly(correo) 
                || StringUtils.isEmptyOrWhitespaceOnly(String.valueOf(telefono)) 
        );
    }
    
}
