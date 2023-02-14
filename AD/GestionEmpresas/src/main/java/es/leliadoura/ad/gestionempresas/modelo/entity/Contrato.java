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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author marco
 */
@Entity
@Table(name="CONTRATOS")
public class Contrato implements Serializable{
    
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Trabajador trabajador;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Empresa empresa;
    @Temporal(TemporalType.DATE)
    @Column(name="fecInicio", nullable = false)
    private Date fecInicio;
    @Temporal(TemporalType.DATE)
    @Column(name="fecFin", nullable = true)
    private Date fecFin;
    @Basic
    @Column(name="salario", nullable = false)
    private Double salario;
    @Basic
    @Column(name="jornada", nullable = false)
    private Integer jornada;

    public Contrato(){}
    
    public Contrato(Trabajador trabajador, Empresa empresa, 
            Date fecInicio, Date fecFin, Double salario, 
            Integer jornada) {
        this.trabajador = trabajador;
        this.empresa = empresa;
        this.fecInicio = fecInicio;
        this.fecFin = fecFin;
        this.salario = salario;
        this.jornada = jornada;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public void setFecInicio(Date fecInicio) {
        this.fecInicio = fecInicio;
    }

    public void setFecFin(Date fecFin) {
        this.fecFin = fecFin;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public void setJornada(Integer jornada) {
        this.jornada = jornada;
    }

    public Long getId() {
        return id;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public Date getFecInicio() {
        return fecInicio;
    }

    public Date getFecFin() {
        return fecFin;
    }

    public Double getSalario() {
        return salario;
    }

    public Integer getJornada() {
        return jornada;
    }

    @Override
    public String toString() {
        return "Contrato{" + "id=" + id 
                + ", trabajador=" + trabajador 
                + ", empresa=" + empresa 
                + ", fecInicio=" + fecInicio 
                + ", fecFin=" + fecFin 
                + ", salario=" + salario 
                + ", jornada=" + jornada + '}';
    }


    public boolean isEmpty(){
        Fechas f = new Fechas();
        return (StringUtils.isEmptyOrWhitespaceOnly(trabajador.toString())
                || StringUtils.isEmptyOrWhitespaceOnly(empresa.toString())
                || StringUtils.isEmptyOrWhitespaceOnly(f.dateToString(fecInicio))
                || StringUtils.isEmptyOrWhitespaceOnly(String.valueOf(salario))
                || StringUtils.isEmptyOrWhitespaceOnly(String.valueOf(jornada))
        );
    }
    
    
}
