/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iesleliadoura.xstream;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marco
 */
public class ListaAlumnos {
    private List<Alumno> lista;

    public ListaAlumnos() {
        this.lista = new ArrayList<>();
    }

    public List<Alumno> getLista() {
        return lista;
    }

    public void setLista(List<Alumno> lista) {
        this.lista = lista;
    }
    
    @Override
    public String toString() {
        return lista.toString();
    }
    
    
}
