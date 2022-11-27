package pedidos;

import java.util.List;
import cliente.LeerMejor;

/**
 *
 * @author dam205
 */
public class PedidosMain {
    //
    public static void main(String[] args){
        String ruta = "pedidos";
        UtilidadesJson json = new UtilidadesJson();
        List<Pedido> pedidos = json.xeraPedidos();
        json.creaJsonPedidos(ruta+".json", pedidos);
        json.crearXMLPedidos(ruta);
        json.mostrarXMLPedidos(ruta+".xml");
        System.out.println("\nLista de pedidos: "+ruta+".json");
        json.MostraJsonPedidos(json.leJsonPedidos(ruta+".json"));
    }//
    
    /*
    public static void main(String[] args){              
        String ruta = "pedidos";
        UtilidadesJson json = new UtilidadesJson();  
        List<Pedido> pedidos = json.xeraPedidos();
        int n = 0;
        do{ 
            menuPedidos();            
            n = LeerMejor.datoShort();
            switch(n){
                case 1:
                    json.creaJsonPedidos(ruta+".json", pedidos);    
                    break;
                case 2:
                    json.crearXMLPedidos(ruta);
                    json.mostrarXMLPedidos(ruta+".xml");
                    break;
                case 3:
                    System.out.println("\nLista de pedidos: "+ruta+".json");
                    json.MostraJsonPedidos(json.leJsonPedidos(ruta+".json"));
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
    
    private static final void menuPedidos() {
        System.out.println("\n     PEDIDOS");
	System.out.println(" 1.- Escribir pedidos.json");
        System.out.println(" 2.- Escribir peiddos.xml y Mostrar");
	System.out.println(" 3.- Leer y Mostrar pedidos.json");
        System.out.println(" 4.- FINAL");
        System.out.print("\nDame opcion: ");
    }*/
    
}
