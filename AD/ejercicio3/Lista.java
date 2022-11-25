package es.leliadoura.ad.eva1parcial1.ejercicio3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dam205
 */
public class Lista implements Serializable{
    //Clase de lista generica con 
    //constructor getter, settet y toString
    private List lista;

    public Lista() {
        this.lista = new ArrayList<>();
    }

    public List getLista() {
        return lista;
    }

    public void setLista(List lista) {
        this.lista = lista;
    }
    
    @Override
    public String toString() {
        return lista.toString();
    }
    
}
