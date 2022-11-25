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
    
    /*public static void main(String[] args) {  
        UtilidadesXStream uxs = new UtilidadesXStream();
        
        String rPro = "produtos";
        uxs.datToXML(rPro, Produto.class);
        uxs.datToXMLBien(rPro);
        uxs.mostrarXML(rPro, Produto.class);
        uxs.mostrarXMLBien(rPro);
        uxs.datToXMLProduto(rPro);
        uxs.mostrarXMLProdutos(rPro);
        
        String rPed = "pedidos";
        uxs.datToXML(rPed, Pedido.class);
        uxs.datToXMLBien(rPed);
        uxs.mostrarXML(rPed, Pedido.class);
        uxs.mostrarXMLBien(rPed);
        uxs.datToXMLPedido(rPed);
        uxs.mostrarXMLPedidos(rPed);
    }*/
    
    //Metodo main del paquete XStream
    public static void main(String[] args) {                      
        String rPro = "produtos";
        Class CPro = Produto.class;
        String rPed = "pedidos";
        Class CPed = Pedido.class;        
        UtilidadesXStream uxs = new UtilidadesXStream();        
        int n = 0;
        do{
            menuXStream();
            n = LeerMejor.datoShort();
            switch(n){ 
                case 1://2 primeros escribir y leer con XStream produtos.dat
                    uxs.datToXML(rPro, CPro);
                    uxs.datToXMLBien(rPro);
                    uxs.datToXMLProduto(rPro);
                    break;
                case 2:
                    uxs.mostrarXML(rPro, CPro);
                    uxs.mostrarXMLBien(rPro);
                    uxs.mostrarXMLProdutos(rPro);
                    break;
                case 3://2 primeros escribir y leer con XStream pedidos.dat
                    uxs.datToXML(rPed, CPed);
                    uxs.datToXMLBien(rPed);
                    uxs.datToXMLPedido(rPed);
                    break;                
                case 4:
                    uxs.mostrarXML(rPed, CPed);
                    uxs.mostrarXMLBien(rPed);
                    uxs.mostrarXMLPedidos(rPed);
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
    
    //Menu de opciones de XStream
    private static final void menuXStream(){
        System.out.println("\n     XSTREAM");
        System.out.println(" 1.- Generar produtos.xml desde produtos.dat");
        System.out.println(" 2.- Leer produtos.xml con XStream");
        System.out.println(" 3.- Genera pedidos.xml desde pedidos.dat");
        System.out.println(" 4.- Leer pedidos.xml con XStream");   
        System.out.println(" 5.- FINAL");
        System.out.print("\nDame opcion: ");
    }//
    
}
