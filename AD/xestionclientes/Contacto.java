package xestionclientes;

import java.io.Serializable;
import pedidos.Cliente;

/**
 *
 * @author dam205
 */
public class Contacto extends Cliente implements Serializable{
    private Enderezo enderezo;

    public Contacto(){}

    public Contacto(String DNI, String nome, 
            String apelidos, Enderezo enderezo) {
        super(DNI, nome, apelidos);
        this.enderezo = enderezo;
    }

    public Enderezo getEnderezo() {
        return enderezo;
    }

    public void setEnderezo(Enderezo enderezo) {
        this.enderezo = enderezo;
    }

    @Override
    public String toString() {
        return "Contacto{" + super.toString() + ", enderezo=" + enderezo + '}';
    }
      
}
