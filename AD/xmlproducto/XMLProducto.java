package xmlproducto;
import org.w3c.dom.Document;
import serializaproducto.LeerMejor;

/**
 *
 * @author dam205
 */
public class XMLProducto {
    
    public static void main(String[] args) {
        //Programa para elegir entre metodos de la clase CrearXmlPedidos        
        int n = 0;   
        Document doc = null;
        CrearXmlPedidos crearXmlPedidos = new CrearXmlPedidos();
        //Generar datos normal (false) o aleatorios (true)
        crearXmlPedidos.setAleatorio(false);
        crearXmlPedidos.setRuta("pedidos");
        do{
            crearXmlPedidos.menuPedidos();
            System.out.print("\nDame opcion: ");
            n = LeerMejor.datoShort();
            switch(n){
                case 1:
                    System.out.println("\nCreada lista pedidos");
                    crearXmlPedidos.xeraListaPedidos();
                    break;
                case 2:
                    System.out.println("\nGuardada lista pedidos");
                    crearXmlPedidos.gardaListaPedidos();
                    break;
                case 3:
                    System.out.println("\nLeida lista pedidos: ");
                    crearXmlPedidos.lePedidos();
                    break;
                case 4:
                    System.out.println("\nMostrada lista pedidos: ");
                    crearXmlPedidos.mostraPedidos();
                    break;
                case 5:
                    System.out.println("\nGenerado xml de pedidos: ");
                    crearXmlPedidos.xeraXmlPedidos();
                    break;                
                case 6:
                    System.out.println("\nLeyendo xml de pedidos: ");
                    doc = crearXmlPedidos.leXmlPedidos();            
                    break;
                case 7:
                    System.out.println("\nMostrando xml de pedidos: ");
                    crearXmlPedidos.mostraXmlPedidos
                    (doc.getDocumentElement());
                    break;
                case 8:
                    System.out.println("\nFINAL");
                    break;
                default:
                    System.out.println("\nOpcion erronea ");
                    break;                
            }
        } while (n != 8);        
    }
    
}