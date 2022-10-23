package xmlproducto;

import java.util.ArrayList;

/**
 *
 * @author dam205
 */
public class DatosPedidos {
    private final int[] idPedido = {1,2,3,4};
    private final String[] nomeCliente = 
    {"Cesar", "Beatriz", "Marco", "Rocio"};
    private DatosProdutos datosProdutos;
    private ArrayList<Produto> produtos;
    private ArrayList<Pedido> pedidos;
    
    public DatosPedidos(){
        datosProdutos = new DatosProdutos();
        produtos = datosProdutos.xeraProdutos();
        pedidos = new ArrayList<Pedido>();
    }
    
    public ArrayList<Pedido> xeraPedidos(){
        pedidos.removeAll(pedidos);
        ArrayList<Produto> listaProdutos;
        
        ArrayList<Produto> listaProdutos0 = new ArrayList<>();
        listaProdutos0.add(produtos.get(0));
        listaProdutos0.add(produtos.get(2));
        listaProdutos0.add(produtos.get(4));
        
        ArrayList<Produto> listaProdutos1 = new ArrayList<>();
        listaProdutos1.add(produtos.get(1));
        listaProdutos1.add(produtos.get(3));
        listaProdutos1.add(produtos.get(4));
        
        ArrayList<Produto> listaProdutos2 = new ArrayList<>();
        listaProdutos2.add(produtos.get(1));
        listaProdutos2.add(produtos.get(2));
        listaProdutos2.add(produtos.get(4));
        
        ArrayList<Produto> listaProdutos3 = new ArrayList<>();
        listaProdutos2.add(produtos.get(0));
        listaProdutos2.add(produtos.get(1));
        listaProdutos2.add(produtos.get(3));
        
        Object[] matrizListaProdutos = 
        {listaProdutos0, listaProdutos1, listaProdutos2, listaProdutos3};
        
        for (int i=0; i<idPedido.length; i++) {
            listaProdutos = new ArrayList<Produto>();
            listaProdutos = (ArrayList<Produto>)matrizListaProdutos[i];
            pedidos.add(new Pedido
            (idPedido[i], nomeCliente[i], listaProdutos));
        }
        return pedidos;
    }
    
    public ArrayList<Pedido> xeraPedidosAzar(){
        ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
        for (int i=0; i<idPedido.length; i++) {
            datosProdutos = new DatosProdutos();
            listaProdutos = datosProdutos.xeraProdutosAzar();
            pedidos.add(new Pedido
            (idPedido[i], nomeCliente[i], listaProdutos));
        }
        return pedidos;
    }
        
}
