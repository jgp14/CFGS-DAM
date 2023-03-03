/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.leliadoura.ad.eva1rec.ejercicio3;

import es.leliadoura.ad.eva1rec.data.Modulo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dam205
 */
public class ListaModulos {
    
    private List<Modulo> modulos;
    
    public ListaModulos(){
        modulos = new ArrayList<>();
    }

    public List<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(List<Modulo> modulos) {
        this.modulos = modulos;
    }

    @Override
    public String toString() {
        return "ListaModulos{" + "modulos=" + modulos + '}';
    }
        
}
