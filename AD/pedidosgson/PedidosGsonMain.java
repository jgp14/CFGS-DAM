package pedidosgson;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import pedidos.LineaPedido;
import pedidos.Pedido;
import serializaproducto.LeerMejor;
import xstream.UtilidadesXStream;

/**
 *
 * @author dam205
 */
public class PedidosGsonMain {
        
    public static void menuGsonPedidos() {
	System.out.println();
        System.out.println("     PEDIDOS");
	System.out.println(" 1.- Escribir pedidos gson");
        System.out.println(" 2.- Escribir peiddos xml");
	System.out.println(" 3.- Leer y mostrar pedidos gson");
        System.out.println(" 4.- FINAL");
    } 
    
    public static void main(String[] args){
        UtilidadesGson gson = new UtilidadesGson();
        int n = 0;
        String ruta = "pedidosGson";         
        UtilidadesXStream uxs = new UtilidadesXStream();
        
        List<Pedido> pedidos = new ArrayList<>();
        do{ 
            menuGsonPedidos();
            System.out.print("\nDame opcion: ");
            n = LeerMejor.datoShort();
            switch(n){
                case 1:
                    System.out.println("\nEscrita lista de pedidos en gson");
                    pedidos = gson.xeraPedidos();
                    gson.creaGsonPedidos(ruta+".json");    
                    pedidos.removeAll(pedidos);
                    break;
                case 2:
                    System.out.println("\nEscrita lista de pedidos en xml");
                    pedidos = gson.xeraPedidos();
                    uxs.memDatToXML(ruta, "pedido", "lineaPedido", Pedido.class, 
                            LineaPedido.class, pedidos);
                    uxs.memDatToXMLMal(ruta, "pedido", "lineaPedido", Pedido.class, 
                            LineaPedido.class, pedidos);
                    break;
                case 3:
                    System.out.println("\nLeida lista de pedidos desde gson");
                    pedidos.removeAll(pedidos);
                    pedidos = gson.leGsonPedidos(ruta+".json");
                    gson.MostraGsonPedidos(pedidos);
                    break;                    
                case 4:                    
                    System.out.println("\nFINAL");
                    break;
                default:
                    System.out.println("\nOpcion erronea ");
                    break;                
            }
        } while(n !=4);        
    }
}
