package pedidos;

import java.util.ArrayList;
import java.util.List;
import serializaproducto.LeerMejor;
import xstream.UtilidadesXStream;

/**
 *
 * @author dam205
 */
public class PedidosMain {
    
    public static void menuPedidos() {
	System.out.println();
        System.out.println("     PEDIDOS");
	System.out.println(" 1.- Escribir pedidos json");
        System.out.println(" 2.- Escribir peiddos xml");
	System.out.println(" 3.- Leer y mostrar pedidos json");
        System.out.println(" 4.- FINAL");
    } 
    
    public static void main(String[] args){
        UtilidadesJson json = new UtilidadesJson();
        int n = 0;
        String ruta = "pedidos";         
        UtilidadesXStream uxs = new UtilidadesXStream();
        
        List<Pedido> pedidos = json.xeraPedidos();
        do{ 
            menuPedidos();
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
