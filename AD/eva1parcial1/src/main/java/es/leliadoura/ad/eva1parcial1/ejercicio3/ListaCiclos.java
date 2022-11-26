/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.leliadoura.ad.eva1parcial1.ejercicio3;

import es.leliadoura.ad.eva1parcial1.data.Ciclo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class ListaCiclos implements Serializable{
    private List<Ciclo> ciclos;

    public ListaCiclos() {
        this.ciclos = new ArrayList<>();
    }

    public List<Ciclo> getCiclos() {
        return ciclos;
    }

    public void setCiclos(List<Ciclo> ciclos) {
        this.ciclos = ciclos;
    }
    
    @Override
    public String toString() {
        return ciclos.toString();
    }
}
