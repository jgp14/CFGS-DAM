package xstream;

import java.util.List;
import serializaproducto.LeerMejor;
import serializaproducto.Produto;
import serializaproducto.Utilidades;
import xmlproducto.CrearXmlPedidos;
import xmlproducto.Pedido;


/**
 *
 * @author user
 */
public class XStreamMain {
    
    //Menu de opciones de XStream
    public static void menuXStream(){
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
        String rPro = "produtos";
        String itemPro = "produto";
        Class CPro = Produto.class;
        String rPed = "pedidos";
        String itemPed = "pedido";
        Class CPed = Pedido.class;        
        
        //Creacion de objetos en memoria para pasarlos a xml
        UtilidadesXStream utilidadesXStream = new UtilidadesXStream();
        
        Utilidades utilidades = new Utilidades();
        utilidades.guardarProdutos();
        List<Produto> lPro = utilidades.leerProdutos();

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
                    utilidadesXStream.memDatToXMLMal
                    (rPro, itemPro,itemPro, CPro, CPro, lPro);
                    utilidadesXStream.memDatToXML
                    (rPro, itemPro, itemPro, CPro, CPro, lPro);
                    System.out.println("\nMostrado produtos.xml por pantalla");
                    utilidadesXStream.verXML
                    (rPro, itemPro, itemPro, CPro, CPro, lPro); 
                    break;
                case 2:
                    System.out.println("\nGenerado pedidos.xml desde memoria");
                    utilidadesXStream.memDatToXMLMal
                    (rPed, itemPed, itemPro, CPed, CPro, lPed);
                    utilidadesXStream.memDatToXML
                    (rPed, itemPed, itemPro, CPed, CPro, lPed);
                    System.out.println("\nMostrado pedidos.xml por pantalla");
                    utilidadesXStream.verXML
                    (rPed, itemPed, itemPro, CPed,CPro,lPed); 
                    break;
                case 3://2 ultimos casos generar produtos y pedidos desde archivos dat                   
                    System.out.println("\nGenerado produtos.xml desde produtos.dat");
                    utilidadesXStream.datToXML(rPro, rPro +".dat", 
                    rPro+".xml",itemPro, itemPed, CPro, CPed, lPro);                    
                    System.out.println("\nMostrado produtos.xml por pantalla");
                    utilidadesXStream.verXMLMal
                    (rPro, itemPro, itemPro, CPro, CPro, lPro); 
                    break;                
                case 4:
                    System.out.println("\nGenerado pedidos.xml desde pedidos.dat");
                    utilidadesXStream.datToXML(rPed, rPed +".dat", 
                    rPed+".xml",itemPed, itemPro, CPed, CPro, lPed);  
                    System.out.println("\nMostrado pedidos.xml por pantalla");
                    utilidadesXStream.verXMLMal
                    (rPed, itemPed, itemPro, CPed,CPro,lPed); 
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
