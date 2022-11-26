package es.leliadoura.ad.eva1parcial1.ejercicio3;

import es.leliadoura.ad.eva1parcial1.data.Unidad;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dam205
 */
public class ListaUnidades implements Serializable{
    private List<Unidad> unidades;

    public ListaUnidades() {
        this.unidades = new ArrayList<>();
    }

    public List<Unidad> getUnidades() {
        return unidades;
    }

    public void setListaU(List<Unidad> unidades) {
        this.unidades = unidades;
    }
    
    @Override
    public String toString() {
        return unidades.toString();
    }
    
}
