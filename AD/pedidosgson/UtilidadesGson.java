package pedidosgson;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import java.io.*;
import java.util.List;
import pedidos.Cliente;
import pedidos.LineaPedido;
import pedidos.ListaPedidos;
import pedidos.Pedido;
import pedidos.Produto;
import pedidos.UtilidadesJson;

/**
 *
 * @author dam205
 */
public class UtilidadesGson {   
    
    public List<Pedido> xeraGsonPedidos(){
        List<Pedido> pedidos = (new UtilidadesJson()).xeraPedidos();
        return pedidos;
    }
    
    public void creaGsonPedidos(String ruta, List<Pedido> pedidos){
        Gson gson = new Gson();
        ListaPedidos lista = new ListaPedidos();
        lista.setPedidos(pedidos);
        String json = gson.toJson(lista);
        try {
            FileWriter fw = new FileWriter(ruta);
            fw.write(json);
            fw.close();
        } catch (IOException ex) {e(ex);}
    }
    
    private void e(Exception ex) {ex.printStackTrace();} 
    
    public void crearXMLPedidosG(String ruta){
        ListaPedidos lista = new ListaPedidos();
        try{            
            lista.setPedidos((List<Pedido>)leGsonPedidos(ruta+".json"));
            XStream xs = new XStream();
            xs.setMode(XStream.NO_REFERENCES);
            xs.alias("produto", Produto.class);
            xs.alias("produtos", List.class);
            xs.alias("cliente", Cliente.class);
            xs.alias("clientes", List.class);
            xs.alias("lineaPedido", LineaPedido.class);
            xs.alias("lineasPedido", List.class);
            xs.alias("pedido", Pedido.class);
            xs.alias("pedidos", ListaPedidos.class); 
            xs.toXML(lista, new FileOutputStream(new File(ruta+".xml")));
        } catch(FileNotFoundException ex){e(ex);};
    } 
    
    public List<Pedido> leGsonPedidos(String ruta){
        ListaPedidos lista = new ListaPedidos();
        Gson gson = new Gson();
        try {
            FileReader fr = new FileReader(ruta);
            lista = gson.fromJson(fr, ListaPedidos.class);
            fr.close();
        } catch (FileNotFoundException ex) {e(ex);} 
        catch (IOException ex) {e(ex);}        
        return lista.getPedidos();
    }
    
    public void MostraGsonPedidos(List<Pedido> pedidos){
        System.out.println("Lista de pedidos: ");
        for(Pedido p: pedidos)
            System.out.println(p);        
    }
    
}
