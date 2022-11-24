package xmlproducto;

import java.util.ArrayList;
import java.util.List;

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
    private List<Pedido> pedidos = new ArrayList<Pedido>();
    
    //Constructores de pedidos
    public DatosPedidos(){}

    public DatosPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }        
    
    //Generar los pedidos de forma lineal
    public List<Pedido> xeraPedidos(){
        pedidos.removeAll(pedidos);
        ArrayList<Produto> listaProdutos;
        Object[] matrizListaProdutos = 
            {listaProdutos0(), listaProdutos1(), 
            listaProdutos2(), listaProdutos3()};
        for (int i=0; i<idPedido.length; i++) {
            listaProdutos = new ArrayList<Produto>();
            listaProdutos = (ArrayList<Produto>)matrizListaProdutos[i];
            pedidos.add(new Pedido
            (idPedido[i], nomeCliente[i], listaProdutos));
        }
        return pedidos;
    }
    
    private ArrayList<Produto> listaProdutos0(){
        List<Produto> pro = (new DatosProdutos()).xeraProdutos();
        ArrayList<Produto> listaProdutos0 = new ArrayList<>();
        listaProdutos0.add(pro.get(0));
        listaProdutos0.add(pro.get(2));
        listaProdutos0.add(pro.get(4));
        return listaProdutos0;
    }
    
    private ArrayList<Produto> listaProdutos1(){
        List<Produto> pro = (new DatosProdutos()).xeraProdutos();
        ArrayList<Produto> listaProdutos1 = new ArrayList<>();
        listaProdutos1.add(pro.get(0));
        listaProdutos1.add(pro.get(2));
        listaProdutos1.add(pro.get(4));
        return listaProdutos1;
    }
    private ArrayList<Produto> listaProdutos2(){
        List<Produto> pro = (new DatosProdutos()).xeraProdutos();
        ArrayList<Produto> listaProdutos2 = new ArrayList<>();
        listaProdutos2.add(pro.get(1));
        listaProdutos2.add(pro.get(2));
        listaProdutos2.add(pro.get(4));
        return listaProdutos2;
    }
    
    private ArrayList<Produto>listaProdutos3(){
        List<Produto> pro = (new DatosProdutos()).xeraProdutos();
        ArrayList<Produto> listaProdutos3 = new ArrayList<>();
        listaProdutos3.add(pro.get(0));
        listaProdutos3.add(pro.get(1));
        listaProdutos3.add(pro.get(3));
        return listaProdutos3;
    }
    
    //Generar los pedidos de forma aleatoria
    public List<Pedido> xeraPedidosAzar(){
        ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
        for (int i=0; i<idPedido.length; i++) {
            listaProdutos = (new DatosProdutos()).xeraProdutosAzar();
            pedidos.add(new Pedido
            (idPedido[i], nomeCliente[i], listaProdutos));
        }
        return pedidos;
    }
        
}
