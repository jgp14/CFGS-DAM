package axenda;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 *
 * @author user
 */
public class ProcesaAxenda {
    
    //Menu desplegable con opciones de axenda
    public static void menuAxenda() {
	System.out.println();
        System.out.println("     AXENDA");
	System.out.println(" 1.- Cargar memoria axenda");
	System.out.println(" 2.- Mostrar elemento raiz");
        System.out.println(" 3.- Mostrar contenido");
        System.out.println(" 4.- Borrar telefonos");
        System.out.println(" 5.- Borrar enderezos");
        System.out.println(" 6.- Añadir correos");
        System.out.println(" 7.- Recrear axenda original");        
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
    
    public static void main(String[] args){        
        int n = 0;
        String ruta = "axenda";
        UtilidadesXML utilidadesXML = new UtilidadesXML();
        CreaAxenda creaAxenda = new CreaAxenda();
        Document doc = null;
        Scanner s = new Scanner(System.in);
        doc = creaAxenda.xeraXMLContactos(ruta);
        do{
            menuAxenda();
            System.out.print("\nDame opcion: ");
            n = numeroValido();
            switch(n){
                case 1:
                    System.out.println("\nCargado fichero axenda.xml");
                    doc = utilidadesXML.XMLaDOM(ruta+".xml");
                    break;
                case 2:
                    System.out.println("\nMostrado elemento raiz");
                    utilidadesXML.mostraElementoRaiz(creaAxenda.getDoc());
                    break;
                case 3:
                    System.out.println("\nMostrado todos los elementos");
                    utilidadesXML.mostraContidoElemento
                    (creaAxenda.getDoc().getDocumentElement());     
                    break;
                case 4:
                    System.out.println("\nBorrados elementos nome telefono");
                    utilidadesXML.DOMaXML(utilidadesXML.borraElementosEtiqueta
                    ("telefono", creaAxenda.getDoc()), ruta+"1.xml");
                    break;
                case 5:
                    System.out.println("\nBorrados elementos tipo enderezo");
                    utilidadesXML.DOMaXML(utilidadesXML.borraElementosEtiqueta
                    ("enderezo", creaAxenda.getDoc()), ruta+"2.xml");
                    break;                
                case 6:
                    System.out.println("\nAñadidos elementos tipo correo");
                    //doc = creaAxenda.xeraXMLContactos(ruta+"3");
                    NodeList nodes = creaAxenda.getDoc().getElementsByTagName("contacto");
                    String[] correos = 
                        {"c0@correo.com", "c1@correo.com", "c2@correo.com",
                        "c3@correo.com", "c4@correo.com", "c5@correo.com"};
                    Element correo;
                    for(int i = 0; i < nodes.getLength(); i++){
                        correo = utilidadesXML.creaElementoTexto
                        ("correo", correos[i], creaAxenda.getDoc());
                        nodes.item(i).appendChild(correo);
                    }        
                    utilidadesXML.DOMaXML(creaAxenda.getDoc(), ruta+"3.xml");        
                    break;
                case 7:
                    System.out.println("\nRecreada axenda con datos originales");
                    doc = creaAxenda.xeraXMLContactos(ruta);
                    break;
                case 8:
                    System.out.println("\nFINAL");
                    break;
                default:
                    System.out.println("\nOpcion erronea ");
                    break;                
            }
        }while(n != 8);
    }
}
