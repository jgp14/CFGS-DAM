package es.leliadoura.ad.eva1parcial1.ejercicio3;

import es.leliadoura.ad.eva1parcial1.data.Modulo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dam205
 */
public class ListaModulos implements Serializable{
    private List<Modulo> modulos;

    public ListaModulos() {
        this.modulos = new ArrayList<>();
    }

    public List<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(List<Modulo> modulos) {
        this.modulos = modulos;
    }
    
    @Override
    public String toString() {
        return modulos.toString();
    }
    
}
