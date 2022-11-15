package pedidos;

/**
 *
 * @author dam205
 */
public class LineaPedido {
    private Produto produto;
    private int cantidade;
    private int prezoTotal;

    public LineaPedido(Produto produto, 
            int cantidade) {
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

    public int getPrezoTotal() {
        return prezoTotal;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setCantidade(int cantidade) {
        this.cantidade = cantidade;
    }

    @Override
    public String toString() {
        return "LineaPedido{" + "produto=" + produto + 
                ", cantidade=" + cantidade + 
                ", prezoTotal=" + prezoTotal + '}';
    }
    
}
