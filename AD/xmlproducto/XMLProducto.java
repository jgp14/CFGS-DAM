package xmlproducto;

import org.w3c.dom.Document;
import serializaproducto.LeerMejor;

/**
 *
 * @author dam205
 */
public class XMLProducto {
    
    /*public static void main(String[] args) {
        String ruta = "pedidos";
        CrearXmlPedidos cxp = new CrearXmlPedidos();        
        cxp.gardaListaPedidos(ruta, cxp.xeraListaPedidos());
        cxp.lePedidos(ruta);
        cxp.mostraPedidos(ruta);
        cxp.xeraXmlPedidos(ruta);
        Document doc = cxp.leXmlPedidos(ruta); 
        cxp.mostraXmlPedidos (doc.getDocumentElement());
    }*/
    
    //Programa para elegir entre metodos de la clase CrearXmlPedidos        
    public static void main(String[] args) {        
        String ruta = "pedidos";
        Document doc = null;
        CrearXmlPedidos cxp = new CrearXmlPedidos();
        int n = 0;  
        do{
            menuPedidos();
            n = LeerMejor.datoShort();
            switch(n){
                case 1:
                    cxp.gardaListaPedidos(ruta, cxp.xeraListaPedidos());
                    break;
                case 2:
                    cxp.mostraPedidos(cxp.lePedidos(ruta));
                    break;
                case 3:
                    cxp.xeraXmlPedidos(ruta);
                    break;                
                case 4:
                    doc = cxp.leXmlPedidos(ruta);            
                    break;
                case 5:
                    try{
                        cxp.mostraXmlPedidos(doc.getDocumentElement());
                    }catch(NullPointerException e){System.err.println(e);}
                    break;
                case 6:
                    System.out.println("\nFINAL");
                    break;
                default:
                    System.out.println("\nOpcion erronea ");
                    break;                
            }
        } while (n != 6);        
    }
    
    private static final void menuPedidos() {
        String items = "pedidos";
        System.out.println("\n     "+items.toUpperCase());
	System.out.println(" 1.- Crear y Guardar "+items);
	System.out.println(" 2.- Leer y Mostrar "+items);
        System.out.println(" 3.- Genera xml "+items);
        System.out.println(" 4.- Leer xml "+items);
        System.out.println(" 5.- Mostrar xml "+items);
        System.out.println(" 6.- FINAL");    
        System.out.print("\nDame opcion: ");
    }//*/
    
}