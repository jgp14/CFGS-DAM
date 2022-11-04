package xmlproducto;

import java.util.ArrayList;

import serializaproducto.Produto;
import serializaproducto.DatosProdutos;

/**
 *
 * @author dam205
 */
public class DatosPedidos {
    //Clase con los datos y ejemplos de pedidos
    private final int[] idPedido = {1,2,3,4};
    private final String[] nomeCliente = 
    {"Cesar", "Beatriz", "Marco", "Rocio"};
    private ArrayList<Pedido> pedidos;
    
    //Constructores de pedidos
    public DatosPedidos(){
        pedidos = new ArrayList<Pedido>();
    }

    public DatosPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }        
    
    //Generar los pedidos de forma lineal
    public ArrayList<Pedido> xeraPedidos(){
        pedidos.removeAll(pedidos);
        ArrayList<Produto> listaProdutos;
        ArrayList<Produto> pro;
        
        pro = (new DatosProdutos()).xeraProdutos();
        ArrayList<Produto> listaProdutos0 = new ArrayList<>();
        listaProdutos0.add(pro.get(0));
        listaProdutos0.add(pro.get(2));
        listaProdutos0.add(pro.get(4));
        
        pro = (new DatosProdutos()).xeraProdutos();
        ArrayList<Produto> listaProdutos1 = new ArrayList<>();
        listaProdutos1.add(pro.get(1));
        listaProdutos1.add(pro.get(3));
        listaProdutos1.add(pro.get(4));
        
        pro = (new DatosProdutos()).xeraProdutos();
        ArrayList<Produto> listaProdutos2 = new ArrayList<>();
        listaProdutos2.add(pro.get(1));
        listaProdutos2.add(pro.get(2));
        listaProdutos2.add(pro.get(4));
        
        pro = (new DatosProdutos()).xeraProdutos();
        ArrayList<Produto> listaProdutos3 = new ArrayList<>();
        listaProdutos3.add(pro.get(0));
        listaProdutos3.add(pro.get(1));
        listaProdutos3.add(pro.get(3));
       
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
    
    //Generar los pedidos de forma aleatoria
    public ArrayList<Pedido> xeraPedidosAzar(){
        ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
        for (int i=0; i<idPedido.length; i++) {
            listaProdutos = (new DatosProdutos()).xeraProdutosAzar();
            pedidos.add(new Pedido
            (idPedido[i], nomeCliente[i], listaProdutos));
        }
        return pedidos;
    }
        
}
