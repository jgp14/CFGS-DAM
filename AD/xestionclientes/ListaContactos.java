package xestionclientes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dam205
 */
public class ListaContactos {
    private List<Contacto> contactos;
    
    public ListaContactos() {
        this.contactos = new ArrayList<>();
    }

    public List<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(List<Contacto> contactos) {
        this.contactos = contactos;
    }

    @Override
    public String toString() {
        return contactos.toString();
    }
    
}
