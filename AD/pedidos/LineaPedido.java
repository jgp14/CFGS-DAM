package pedidos;

import java.io.Serializable;

/**
 *
 * @author dam205
 */
public class LineaPedido implements Serializable{
    private Produto produto;
    private int cantidade;
    private float prezoTotal;

    public LineaPedido(){}
    
    public LineaPedido(Produto produto, int cantidade) {
        this.produto = produto;
        this.cantidade = cantidade;
        this.prezoTotal = cantidade * produto.getPrezo();
    }

    public Produto getProduto() {
        return produto;
    }

    public int getCantidade() {
        return cantidade;
    }

    public float getPrezoTotal() {
        return prezoTotal;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setCantidade(int cantidade) {
        this.cantidade = cantidade;
    }

    public void setPrezoTotal(float prezoTotal) {
        this.prezoTotal = prezoTotal;
    }

    @Override
    public String toString() {
        return "LineaPedido{" + "produto=" + produto + 
                ", cantidade=" + cantidade + 
                ", prezoTotal=" + prezoTotal + '}';
    }
    
}
