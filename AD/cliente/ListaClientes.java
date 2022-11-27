package cliente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dam205
 */
public class ListaClientes implements Serializable{
    private List<Cliente> clientes;

    public ListaClientes() {
        this.clientes = new ArrayList<>();
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    @Override
    public String toString() {
        return clientes.toString();
    }
}
