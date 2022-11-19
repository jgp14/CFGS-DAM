package utilidades;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
import org.xml.sax.SAXException;


/**
 *
 * @author dam205
 */
public class UtilidadesXML {
        
    //Crear documento vacio
    public Document creaDOMBaleiro(String raiz){
        Document doc = null;        
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            DOMImplementation implementation = db.getDOMImplementation();
            doc = implementation.createDocument
            (null, raiz, null);
            doc.setXmlVersion("1.0");            
        } catch (ParserConfigurationException ex) {
            System.out.println("Error: en configuracion parser");
        }
        return doc;
    }
    
    //Crear elemento con texto
    public Element creaElementoTexto
    (String etiqueta, String texto, Document doc){
        Element element = null;
        element = doc.createElement(etiqueta);
        element.appendChild(doc.createTextNode(texto));
        return element;
    }    
    
    //Metodo imporvisado para añadir un elemento hijo con texto en cada uno de 
    //los elementos con nombre de etiqueta padre dada, y en un doc DOM dado.
    public Document ponerElementosEtiqueta(String etiqueta, 
        String etiquetaPadre, String[] elementosTextos, Document doc){        
        try{
            NodeList nodes = doc.getElementsByTagName(etiquetaPadre);                    
            Element correo;
            for(int i = 0; i < nodes.getLength(); i++){
                correo = creaElementoTexto
                (etiqueta, elementosTextos[i], doc);
                nodes.item(i).appendChild(correo);
            }              
        }catch(NullPointerException ex){
            System.out.println("Error: excecion por ser nulo el doc DOM");
        }catch(ArrayIndexOutOfBoundsException ex){
            System.out.println("Error: excecion faltan textos en elementos");
        }
        return doc;
    }
    
    //Pasar de XML a Document DOM
    public Document XMLaDOM(String nomeXML){
        Document doc = null;
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(nomeXML);
        } catch (ParserConfigurationException ex) {
            System.out.println("Error: en configuracion parser");
        } catch (SAXException ex) {
            System.out.println("Error: en SAX");
        } catch (IOException ex) {
            System.out.println("Error: en entrada salida");
        }
        return doc;
    }
    
    //Mostrar solo el elemento raiz
    public void mostraElementoRaiz(Document doc){
        try{
            Element raiz = doc.getDocumentElement();
            System.out.println("Elemento raiz: " + raiz.getTagName());
        }catch(NullPointerException ex){
            System.out.println("Error: excecion por ser nulo el doc DOM");
        }       
    }
    
    //Mostrar todos los elementos, textos y atributos del archivo XML
    public void mostraContidoElemento(Element element){
        NodeList nodos = element.getChildNodes();
        for (int i = 0; i < nodos.getLength(); i++) {
            Node n = nodos.item(i);
            switch(n.getNodeType()){
                case Node.ELEMENT_NODE:
                    Element e = (Element) n;
                    System.out.println("Etiqueta:" + e.getTagName());
                    mostraContidoElemento(e);
                    break;
                case Node.TEXT_NODE:
                    Text t = (Text) n;
                    if(!t.getWholeText().isBlank())
                        System.out.println("Texto:" + t.getWholeText());
                    break;
                case Node.ATTRIBUTE_NODE:
                    Attr a = (Attr) n;
                    System.out.println
                    ("Atributo:" + a.getName() + "=" + a.getValue());
                    break;
                case Node.COMMENT_NODE:
                    Comment c = (Comment) n;
                    break;
            }
        }
    }
    
    //Borrar un elemento dado de un documento DOM dado
    public Document borraElementosEtiqueta(String etiqueta, Document doc){        
        try{
            NodeList nodos = doc.getElementsByTagName(etiqueta);
            for (int i = 0; i < nodos.getLength(); i++) {
                Node n = nodos.item(i);
                Element e = (Element) n;
                e.getParentNode().removeChild(e);
                borraElementosEtiqueta(etiqueta, doc);
            }
        }catch(NullPointerException ex){
            System.out.println("Error: excecion por ser nulo el doc DOM");
        } 
        return doc;
    }
    
    //Paso de contenido del DOM a fichero XML
    public Document DOMaXML(Document doc, String nomeXML){
        try{
            File f = new File(nomeXML);
            Transformer transformer = 
                    TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            StreamResult result = new StreamResult(f);
            DOMSource source = new DOMSource(doc);
            transformer.transform(source, result);
        }catch(TransformerConfigurationException ex){
            System.out.println
        ("Error: excepcion de configuracion de transformacion");
        }catch(TransformerException ex) {
            System.out.println("Error: excepcion de transformacion");
        }
        return doc;
    }
}