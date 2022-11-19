package pedidosgson;

import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import pedidos.Pedido;
import pedidos.UtilidadesJson;

/**
 *
 * @author dam205
 */
public class UtilidadesGson {   
    
    public List<Pedido> xeraPedidos(){
        List<Pedido> pedidos = (new UtilidadesJson()).xeraPedidos();
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
    }
    
}
