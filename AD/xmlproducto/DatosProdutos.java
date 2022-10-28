package xmlproducto;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author dam205
 */
public class DatosProdutos {
    
    //Atributos con datos de produtos y constructor
    private final Integer[] idProduto = {1,2,3,4,5};
    private final String[] descricion = 
    {"USB 3.1", "Raton", "Teclado", "Disco duro externo", "Cascos"};
    private final Float[] prezo = {5.0f, 8.0f, 10.0f, 30.0f, 12.0f};
    private ArrayList<Produto> produtos;

    public DatosProdutos() {
        this.produtos = new ArrayList<Produto>();
    }
    
    //Opcion1: Generador de produtos normal
    public ArrayList<Produto> xeraProdutos(){
        produtos.removeAll(produtos);
        for (int i=0; i < idProduto.length; i++) {
            produtos.add(new Produto
            (idProduto[i], descricion[i], prezo[i]));
        }
        return produtos;
    }
    
    //Opcion2: Generador de produtos aleatorios
    public ArrayList<Produto> xeraProdutosAzar(){
        int index;
        Random random;
        produtos.removeAll(produtos);
        produtos = xeraProdutos();
        ArrayList<Produto> produtosAzar = new ArrayList<Produto>();        
        for(int i = 0; i < produtos.size(); i++){
            random = new Random();
            index = random.nextInt(produtos.size()); 
            produtosAzar.add(produtos.get(index));
        }    
        return produtosAzar;
    }  

}
