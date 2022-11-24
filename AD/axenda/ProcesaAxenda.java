package axenda;

import serializaproducto.LeerMejor;
import org.w3c.dom.Document;


/**
 *
 * @author dam205
 */
public class ProcesaAxenda {  
    
    /*public static void main(String[] args){        
        String ruta = "axenda";
        UtilidadesXML uxml = new UtilidadesXML();
        CreaAxenda ca = new CreaAxenda();
        ca.xeraXMLContactos(ruta);
        ca.setDoc(uxml.XMLaDOM(ruta+".xml"));
        uxml.mostraElementoRaiz(ca.getDoc()); 
        uxml.mostraContidoElemento(ca.getDoc().getDocumentElement());
        uxml.DOMaXML(uxml.borraElementosEtiqueta
                    ("enderezo", ca.getDoc()), ruta+"2.xml");   
        uxml.DOMaXML(uxml.ponerElementosEtiqueta("correos", 
                "contacto",ca.getDoc()), ruta+"3.xml");     
    }*/
    
    //Programa para elegir entre metodos de la clase CreaAxenda  
    public static void main(String[] args){
        
        String ruta = "axenda";
        UtilidadesXML uxml = new UtilidadesXML();
        CreaAxenda ca = new CreaAxenda();
        Document doc = null;
        //Generar DOM pasarlo a axenda.xml sino da exepciones E/S y NullPointer
        ca.xeraXMLContactos(ruta);
        int n = 0;
        do{
            menuAxenda();
            n = LeerMejor.datoShort();
            switch(n){
                case 1:
                    ca.setDoc(uxml.XMLaDOM(ruta+".xml"));
                    break;
                case 2:
                    uxml.mostraElementoRaiz(ca.getDoc());                     
                    break;
                case 3: 
                    try{
                        uxml.mostraContidoElemento
                        (ca.getDoc().getDocumentElement()); 
                    }catch(NullPointerException e){System.err.println(e);}                         
                    break;
                case 4:
                    uxml.DOMaXML(uxml.borraElementosEtiqueta
                    ("telefono", ca.getDoc()), ruta+"1.xml");
                    break;
                case 5:
                    uxml.DOMaXML(uxml.borraElementosEtiqueta
                    ("enderezo", ca.getDoc()), ruta+"2.xml");
                    break;                
                case 6: 
                     uxml.DOMaXML(uxml.ponerElementosEtiqueta
                    ("correos", "contacto",
                ca.getDoc()), ruta+"3.xml");                                          
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
    
    //Menu desplegable con opciones de axenda
    private static final void menuAxenda() {
        System.out.println("\n     AXENDA");
	System.out.println(" 1.- Cargar xml axenda a DOM");
	System.out.println(" 2.- Mostrar elemento raiz");
        System.out.println(" 3.- Mostrar contenido");
        System.out.println(" 4.- Borrar telefonos");
        System.out.println(" 5.- Borrar enderezos");
        System.out.println(" 6.- Añadir correos");       
        System.out.println(" 7.- FINAL");
        System.out.print("\nDame opcion: ");
    }//*/
    
}
