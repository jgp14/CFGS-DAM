package pedidosgson;

import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import pedidos.Cliente;
import pedidos.LineaPedido;
import pedidos.Pedido;
import pedidos.Produto;

/**
 *
 * @author dam205
 */
public class UtilidadesGson {    
    
    public List<Pedido> xeraPedidos(){
        List<Pedido> pedidos = new ArrayList<>();
        List<LineaPedido> linea1 = new ArrayList<>();
        linea1.add(new LineaPedido(new Produto(1, "USB", "Pendrive", "foto1.png", 5), 4));
        linea1.add(new LineaPedido(new Produto(2, "DVD", "Unidad Optica", "foto2.png", 6), 2));
        pedidos.add(new Pedido(1,new Cliente("12345678A", "Jose", "Garcia"), linea1, 32, false));        
        List<LineaPedido> linea2 = new ArrayList<>();
        linea2.add(new LineaPedido(new Produto(3, "Auricular", "Grandes", "foto3.png", 2), 2));
        linea2.add(new LineaPedido(new Produto(4, "Raton", "Gaming", "foto4.png", 10), 1));
        pedidos.add(new Pedido(2,new Cliente("23456789B", "Pedro", "Gomez"), linea2, 14, true));  
        List<LineaPedido> linea3 = new ArrayList<>();
        linea3.add(new LineaPedido(new Produto(5, "Teclado", "Numerico", "foto5.png", 12), 1));
        linea3.add(new LineaPedido(new Produto(6, "Cables", "Informatica", "foto6.png", 2), 5));
        pedidos.add(new Pedido(3,new Cliente("34567891C", "Maria", "Perez"), linea3, 22, true));  
        return pedidos;
    }
    
    public void creaGsonPedidos(String ruta){
        List<Pedido> pedidos = xeraPedidos();
        Gson gson = new Gson();
        String jsonPedido = gson.toJson(pedidos);
        try {
            FileWriter fichero = new FileWriter(ruta);
            fichero.write(jsonPedido);
            fichero.close();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
    
    public List<Pedido> leGsonPedidos(String ruta){
        List<Pedido> pedidos = new ArrayList<>();
        Gson gson = new Gson();
        try {
            FileReader fichero = new FileReader(ruta);
            pedidos = gson.fromJson(fichero, List.class);
            fichero.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
        } catch (IOException ex) {
            System.err.println(ex);
        }        
        return pedidos;
    }
    
    public void MostraGsonPedidos(List<Pedido> pedidos){
        for(int i = 0; i < pedidos.size(); i++)
            System.out.println(pedidos.get(i));       
        System.out.println();  
    }
    
}
