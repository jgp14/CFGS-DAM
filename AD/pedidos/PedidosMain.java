package pedidos;

import java.util.List;
import utilidades.LeerMejor;
import utilidades.UtilidadesXStream;

/**
 *
 * @author dam205
 */
public class PedidosMain {
    
    public static void main(String[] args){
        int n = 0;
        UtilidadesJson json = new UtilidadesJson();        
        String ruta = "pedidos";         
        UtilidadesXStream uxs = new UtilidadesXStream();
        List<Pedido> pedidos = json.xeraPedidos();
        do{ 
            json.menuPedidos();
            System.out.print("\nDame opcion: ");
            n = LeerMejor.datoShort();
            switch(n){
                case 1:
                    System.out.println("\nEscrita lista de pedidos en json");
                    json.creaJsonPedidos(ruta+".json");    
                    break;
                case 2:
                    System.out.println("\nEscrita lista de pedidos en xml");
                    uxs.listToXML(ruta, "pedido", "lineaPedido", Pedido.class, 
                            LineaPedido.class, pedidos);
                    break;
                case 3:
                    System.out.println("\nLeida lista de pedidos desde json");
                    json.MostraJsonPedidos(ruta+".json");
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
