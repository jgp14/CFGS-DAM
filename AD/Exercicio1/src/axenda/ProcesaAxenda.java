package axenda;

import serializaproducto.LeerMejor;
import org.w3c.dom.Document;


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
        System.out.println(" 7.- FINAL");  
    }   
    
    public static void main(String[] args){        
        int n = 0;
        String ruta = "axenda";
        UtilidadesXML utilidadesXML = new UtilidadesXML();
        CreaAxenda creaAxenda = new CreaAxenda();
        Document doc = null;
        //Generar DOM pasarlo a axenda.xml sino da exepciones E/S y NullPointer
        creaAxenda.xeraXMLContactos(ruta);
        do{
            menuAxenda();
            System.out.print("\nDame opcion: ");
            n = LeerMejor.datoShort();
            switch(n){
                case 1:
                    System.out.println("\nCargado en memoria de axenda.xml");
                    creaAxenda.setDoc(utilidadesXML.XMLaDOM(ruta+".xml"));
                    break;
                case 2:
                    System.out.println("\nMostrado elemento raiz");
                    utilidadesXML.mostraElementoRaiz(creaAxenda.getDoc());                     
                    break;
                case 3: 
                    System.out.println("\nMostrado todos los elementos");
                    try{
                        utilidadesXML.mostraContidoElemento
                        (creaAxenda.getDoc().getDocumentElement()); 
                    }catch(NullPointerException ex){
                        System.out.println("Error: excecion por ser nulo el doc DOM");
                    }                         
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
                case 6: //Dos metods
                    System.out.println("\nAñadidos elementos tipo correo");
                    String[] correos = 
                        {"c0@correo.com", "c1@correo.com", "c2@correo.com",
                        "c3@correo.com", "c4@correo.com", "c5@correo.com"};
                    //doc = creaAxenda.xeraXMLContactos(ruta+"3");
                    utilidadesXML.DOMaXML(utilidadesXML.ponerElementosEtiqueta
                    ("correos", "contacto", correos, 
                            creaAxenda.getDoc()), ruta+"3.xml");                                             
                    break;
                case 7:
                    System.out.println("\nFINAL");
                    break;
                default:
                    System.out.println("\nOpcion erronea ");
                    break;                
            }
        }while(n != 7);
    }
}
