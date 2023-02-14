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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marco
 */
@Entity
@Table(name="EMPRESAS")
public class Empresa implements Serializable{
    
    @Id
    @Column(name="nif", nullable=false, unique=true)
    private String NIF;
    @Basic
    @Column(name="razonSocial", nullable=false)
    private String razonSocial;
    @Basic
    @Column(name="iban", nullable=false)
    private String IBAN;
    @OneToMany   
    private List<Contacto> contactos;

    public Empresa(){}
    
    public Empresa(String NIF, String razonSocial, String IBAN) {
        this.NIF = NIF;
        this.razonSocial = razonSocial;
        this.IBAN = IBAN;
        this.contactos = new ArrayList<>();
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public void setContactos(List<Contacto> contactos) {
        this.contactos = contactos;
    }

    public String getNIF() {
        return NIF;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public String getIBAN() {
        return IBAN;
    }

    public List<Contacto> getContactos() {
        return contactos;
    }

    @Override
    public String toString() {
        return "Empresa{" + "NIF=" + NIF + ", razonSocial=" + razonSocial 
                + ", IBAN=" + IBAN + ", contactos=" + contactos.toString() + '}';
    }
    
    public boolean isEmpty(){
        return (StringUtils.isEmptyOrWhitespaceOnly(NIF) 
                || StringUtils.isEmptyOrWhitespaceOnly(razonSocial) 
                || StringUtils.isEmptyOrWhitespaceOnly(IBAN));
    }
        
}
