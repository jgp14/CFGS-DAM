package pedidos;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author dam205
 */
public class Pedido implements Serializable{
    private int id;
    private Cliente cliente;
    private List<LineaPedido> lineasPedido;
    private float importe;
    private boolean entregado;

    public Pedido(){}
    
    public Pedido(int id, Cliente cliente, 
            List<LineaPedido> lineasPedido, boolean entregado) {
        this.id = id;
        this.cliente = cliente;
        this.lineasPedido = lineasPedido;
        this.importe = calculaImporte();
        this.entregado = entregado;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<LineaPedido> getLineasPedido() {
        return lineasPedido;
    }

    public float getImporte() {
        return importe;
    }

    public boolean isEntregado() {
        return entregado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setLineasPedido(List<LineaPedido> lineasPedido) {
        this.lineasPedido = lineasPedido;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }

    @Override
    public String toString() {
        return "Pedido{" + "id=" + id + 
                ", cliente=" + cliente + ", lineasPedido=" + lineasPedido + 
                ", importe=" + importe + ", entregado=" + entregado + '}';
    }    
    
    private float calculaImporte(){
        importe = 0;
        for(LineaPedido lineaPedido: lineasPedido)
            importe = importe + lineaPedido.getPrezoTotal();
        return importe;
    }
    
}
