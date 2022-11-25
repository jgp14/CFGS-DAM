package xstream;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import serializaproducto.Produto;

/**
 *
 * @author dam205
 */
public class ListaProdutos implements Serializable{
    private List<Produto> produtos;

    public ListaProdutos() {
        this.produtos = new ArrayList<>();
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setLista(List<Produto> produtos) {
        this.produtos = produtos;
    }
    
    @Override
    public String toString() {
        return produtos.toString();
    }
}
