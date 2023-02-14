/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.leliadoura.ad.gestionempresas.modelo.entity;

import com.mysql.cj.util.StringUtils;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author marco
 */
@Entity
@Table(name="TRABAJADORES")
public class Trabajador implements Serializable{
    
    @Id
    @Column(name="dni", nullable=false, unique=true)
    private String DNI;
    @Basic
    @Column(name="nombre", nullable=false)
    private String nombre;
    @Basic
    @Column(name="apellidos", nullable=false)
    private String apellidos;
    @Basic
    @Column(name="iban", nullable=false)
    private String IBAN;
    @Basic
    @Column(name="segSocial", nullable=false)
    private Long segSocial;
    @Basic
    @Column(name="correo", nullable=false)
    private String correo;
    @Basic
    @Column(name="telefono", nullable=false)
    private Long telefono;

    public Trabajador(){}
    
    public Trabajador(String DNI, String nombre, 
            String apellidos, String IBAN, Long segSocial, 
            String correo, Long telefono) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.IBAN = IBAN;
        this.segSocial = segSocial;
        this.correo = correo;
        this.telefono = telefono;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public void setSegSocial(Long segSocial) {
        this.segSocial = segSocial;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getDNI() {
        return DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getIBAN() {
        return IBAN;
    }

    public Long getSegSocial() {
        return segSocial;
    }

    public String getCorreo() {
        return correo;
    }

    public Long getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        return "Trabajador{" + "DNI=" + DNI + ", nombre=" + nombre + 
                ", apellidos=" + apellidos + ", IBAN=" + IBAN + 
                ", segSocial=" + segSocial + ", correo=" + correo + 
                ", telefono=" + telefono + '}';
    }    
    
    public boolean isEmpty(){
        return (StringUtils.isEmptyOrWhitespaceOnly(DNI) 
                || StringUtils.isEmptyOrWhitespaceOnly(nombre) 
                || StringUtils.isEmptyOrWhitespaceOnly(apellidos) 
                || StringUtils.isEmptyOrWhitespaceOnly(correo) 
                || StringUtils.isEmptyOrWhitespaceOnly(String.valueOf(segSocial))
                || StringUtils.isEmptyOrWhitespaceOnly(String.valueOf(telefono))
            );
    }
    
}
