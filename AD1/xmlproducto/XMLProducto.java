package xmlproducto;

import java.util.InputMismatchException;
import java.util.Scanner;


/**
 *
 * @author user
 */
public class XMLProducto {

    //Menu desplegable con opciones de pedidos
    public static void menuPedidos() {
	System.out.println();
        System.out.println("     PEDIDOS");
	System.out.println(" 1.- Crear elementos");
	System.out.println(" 2.- Guardar elementos");
        System.out.println(" 3.- Leer elementos");
        System.out.println(" 4.- Mostrar elementos");
        System.out.println(" 5.- Genera xml elementos");
        System.out.println(" 6.- Leyendo xml elementos");
        System.out.println(" 7.- Mostrar xml elementos");
        System.out.println(" 8.- FINAL");        
    }
    
    //Para recibir solo numeros entero valido como opciones
    public static int numeroValido(){
        int i;
        Scanner s;
        do{
            i = 0;
            s = new Scanner(System.in);
            try{
                i = s.nextInt();
            } catch(NumberFormatException | InputMismatchException ex) {
                i = Integer.MIN_VALUE;
                System.out.println("Error: el input no es un entero valido");
            } 
        } while(i == Integer.MIN_VALUE);        
        return i;
    }
    
    public static void main(String[] args) {
        //Programa para elegir entre metodos de la clase CrearXmlPedidos        
        int n = 0;
        String xmlString, arquivo = "pedidos";        
        Scanner s = new Scanner(System.in);
        CrearXmlPedidos crearXmlPedidos = new CrearXmlPedidos();
        crearXmlPedidos.setRuta(arquivo);
        do{
            menuPedidos();
            System.out.print("\nDame opcion: ");
            n = numeroValido();
            switch(n){
                case 1:
                    System.out.println("\nCreada lista elementos");
                    crearXmlPedidos.xeraListaPedidos();
                    break;
                case 2:
                    System.out.println("\nGuardada lista elementos");
                    crearXmlPedidos.gardaListaPedidos();
                    break;
                case 3:
                    System.out.println("\nLeida lista elementos: ");
                    crearXmlPedidos.lePedidos();
                    break;
                case 4:
                    System.out.println("\nMostrada lista elementos: ");
                    crearXmlPedidos.mostraPedidos();
                    break;
                case 5:
                    System.out.println("\nGenerado xml de elementos: ");
                    crearXmlPedidos.xeraXmlPedidos();
                    break;                
                case 6:
                    System.out.println("\nLeyendo xml de elementos: ");
                    crearXmlPedidos.leXmlPedidos();            
                    break;
                case 7:
                    System.out.println("\nManeras de mostrar documento xml: ");
                    System.out.println("\nOpcion1 mostrar xml como un String");
                    xmlString = crearXmlPedidos.convertXMLDocumentToString
                    (crearXmlPedidos.leXmlPedidos());
                    System.out.println(xmlString);
                    System.out.println("\nOpcion2 mostrar xml como etiquetas");
                    crearXmlPedidos.mostraXML(xmlString);
                    System.out.println("\nOpcion3 mostrar xml como un loop");
                    crearXmlPedidos.loopNodeXml
                    (crearXmlPedidos.leXmlPedidos().getDocumentElement());
                    System.out.println();
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
