package pedidosgson;

import java.util.List;
import pedidos.Pedido;
import cliente.LeerMejor;

/**
 *
 * @author dam205
 */
public class PedidosGsonMain {
    //
    public static void main(String[] args){
        UtilidadesGson gson = new UtilidadesGson();
        String ruta = "pedidosG";
        List<Pedido> pedidos = gson.xeraGsonPedidos();
        gson.creaGsonPedidos(ruta+".json", pedidos);
        gson.crearXMLPedidosG(ruta);
        gson.MostraGsonPedidos(gson.leGsonPedidos(ruta+".json"));
    }//
    
    /*
    public static void main(String[] args){
        String ruta = "pedidosG";
        UtilidadesGson gson = new UtilidadesGson();
        List<Pedido> pedidos = gson.xeraGsonPedidos();
        int n = 0;
        do{ 
            menuGsonPedidos();
            n = LeerMejor.datoShort();
            switch(n){
                case 1:
                    gson.creaGsonPedidos(ruta+".json", pedidos);   
                    break;
                case 2:
                    gson.crearXMLPedidosG(ruta);
                    break;
                case 3:
                    gson.MostraGsonPedidos(gson.leGsonPedidos(ruta+".json"));
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

    public static void menuGsonPedidos() {
        System.out.println("\n     PEDIDOS");
	System.out.println(" 1.- Escribir pedidos gson");
        System.out.println(" 2.- Escribir peiddos xml");
	System.out.println(" 3.- Leer y mostrar pedidos gson");
        System.out.println(" 4.- FINAL");
        System.out.print("\nDame opcion: ");
    }*/
}
