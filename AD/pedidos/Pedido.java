package pedidos;

import java.util.List;

/**
 *
 * @author dam205
 */
public class Pedido {
    private int id;
    private Cliente cliente;
    private List<LineaPedido> lineasPedido;
    private int importe;
    private boolean entregado;

    public Pedido(){}
    
    public Pedido(int id, Cliente cliente, 
            List<LineaPedido> lineasPedido, 
            int importe, boolean entregado) {
        this.id = id;
        this.cliente = cliente;
        this.lineasPedido = lineasPedido;
        this.importe = importe;
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

    public int getImporte() {
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

    public void setImporte(int importe) {
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
    
}
