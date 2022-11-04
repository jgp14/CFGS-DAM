package xmlproducto;

import java.io.Serializable;
import java.util.ArrayList;
import serializaproducto.Produto;

/**
 *
 * @author user
 */
public class Pedido implements Serializable{
    //Clase Pedido con todos sus atributos, 
    //constructores, getters y setters y toString
    private Integer idPedido;
    private String nomeCliente;
    private ArrayList<Produto> produtos;

    public Pedido(){}
    
    public Pedido(Integer idPedido, 
            String nomeCliente, ArrayList produtos) {
        this.idPedido = idPedido;
        this.nomeCliente = nomeCliente;
        this.produtos = produtos;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public ArrayList getProdutos() {
        return produtos;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public void setProdutos(ArrayList produtos) {
        this.produtos = produtos;
    }

    @Override
    public String toString() {
        return "Pedido{" + "idPedido=" + idPedido + ", nomeCliente=" 
                + nomeCliente + ", produtos=" + produtos + '}';
    }

}
