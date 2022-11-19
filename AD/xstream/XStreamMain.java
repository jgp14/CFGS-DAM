package xstream;

import java.util.List;
import serializaproducto.LeerMejor;
import serializaproducto.Produto;
import serializaproducto.Utilidades;
import xmlproducto.CrearXmlPedidos;
import xmlproducto.Pedido;


/**
 *
 * @author dam205
 */
public class XStreamMain {
    
    //Menu de opciones de XStream
    public static final void menuXStream(){
        System.out.println();
        System.out.println("     XSTREAM");
        System.out.println(" 1.- Generar produtos.xml desde memoria");       
        System.out.println(" 2.- Genera pedidos.xml desde memoria");          
        System.out.println(" 3.- Generar produtos.xml desde produtos.dat");
        System.out.println(" 4.- Genera pedidos.xml desde pedidos.dat");
        System.out.println(" 5.- FINAL"); 
    }
    
    //Metodo main del paquete XStream
    public static void main(String[] args) {                      
        int n = 0;
        //Establecer los alias
        String rPro = "produtos";
        String itemPro = "produto";
        Class CPro = Produto.class;
        String rPed = "pedidos";
        String itemPed = "pedido";
        Class CPed = Pedido.class;        
        
        //Creacion de objetos en memoria para pasarlos a xml
        UtilidadesXStream uxs = new UtilidadesXStream();
        
        Utilidades utilidades = new Utilidades();
        utilidades.guardarProdutos(rPro);
        List<Produto> lPro = utilidades.leerProdutos(rPro);

        CrearXmlPedidos crearXmlPedidos = new CrearXmlPedidos();
        crearXmlPedidos.gardaListaPedidos();
        crearXmlPedidos.setAleatorio(false);
        List<Pedido> lPed = crearXmlPedidos.lePedidos();        
        
        do{
            menuXStream();
            System.out.print("\nDame opcion: ");            
            n = LeerMejor.datoShort();
            switch(n){ 
                case 1://2 primeros casos generar produtos y pedidos desde memoria
                    System.out.println("\nGenerados produtos.xml desde memoria");
                    uxs.listToXML(rPro, itemPro,itemPro, CPro, CPro, lPro);
                    System.out.println("\nMostrado produtos.xml por pantalla");
                    uxs.verXML(rPro, itemPro, itemPro, CPro, CPro, lPro); 
                    break;
                case 2:
                    System.out.println("\nGenerado pedidos.xml desde memoria");
                    uxs.listToXML(rPed, itemPed, itemPro, CPed, CPro, lPed);
                    System.out.println("\nMostrado pedidos.xml por pantalla");
                    uxs.verXML(rPed, itemPed, itemPro, CPed,CPro,lPed); 
                    break;
                case 3://2 ultimos casos generar produtos y pedidos desde archivos dat                   
                    System.out.println("\nGenerado produtos.xml desde produtos.dat");
                    lPro = uxs.datToXML(rPro,itemPro, itemPed, CPro, CPed);             
                    System.out.println("\nMostrado produtos.xml por pantalla");
                    uxs.verXML(rPro, itemPro, itemPro, CPro, CPro, lPro); 
                    break;                
                case 4:
                    lPed = uxs.datToXML(rPed, itemPed, itemPro, CPed, CPro);  
                    System.out.println("\nMostrado pedidos.xml por pantalla");
                    uxs.verXML(rPed, itemPed, itemPro, CPed,CPro, lPed); 
                    break;
                case 5:
                    System.out.println("\nFINAL");
                    break;
                default:
                    System.out.println("\nOpcion erronea ");
                    break;                
            }            
        }while(n != 5);        
    }
}
