package es.leliadoura.ad.eva1parcial1.ejercicio2;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author marco
 */
public class UtilXml {
    
    /**
     * Crea un documento DOM vacío con la raíz indicada.
     * @param raiz etiqueta raíz del documento XML
     * @return devuelve el documento DOM o null si no se puede crear
     */
    public Document creaDOM (String raiz) {
        Document doc = null;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            DOMImplementation imp = db.getDOMImplementation();
            doc = imp.createDocument(null, raiz, null);
            doc.setXmlVersion("1.0");
        }
        catch (ParserConfigurationException ex) {
            System.err.println("Error al crear el DOM XML");
        }
        return doc;
    }
    
    /**
     * Lee un fichero XML almacenado en la ruta y lo devuelve como documento DOM
     * @param ruta nombre del fichero o ruta absoluta
     * @return devuelve el documento DOM o null si no se puede leer el fichero
     */
    public Document leeXML (String ruta) {
        Document doc = null;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(ruta);
        }
        catch (IOException | ParserConfigurationException | SAXException ex) {
            System.err.println("Error al leer fichero XML");
        }
        return doc;
    }
    
    /**
     * Guarda un documento DOM en un fichero XML en la ruta indicada
     * @param doc documento DOM con el contenido del XML
     * @param ruta nombre del fichero o ruta absulta donde guardar el fichero
     * @return devuelve true o false confirmando si se guardó o no
     */
    public boolean guardaXML (Document doc, String ruta) {
        try{
            File f = new File(ruta);
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            StreamResult result = new StreamResult(f);
            DOMSource source = new DOMSource(doc);
            transformer.transform(source, result);
        }
        catch (TransformerException ex) {
            System.err.println("No se pudo guardar el XML");
            return false;
        }
        return true;
    }
    
    private void e(Exception ex){ex.printStackTrace();}
    
    public Element creaElementoTexto(String etiqueta, String texto, Document doc){
        Element element = null;
        element = doc.createElement(etiqueta);
        element.appendChild(doc.createTextNode(texto));
        return element;
    }  
    
    public Document borraElementos(String etiqueta, Document doc){        
        try{
            NodeList nodos = doc.getElementsByTagName(etiqueta);
            for (int i = 0; i < nodos.getLength(); i++) {
                Node n = nodos.item(i);
                Element e = (Element) n;
                e.getParentNode().removeChild(e);
                borraElementos(etiqueta, doc);
            }
        }catch(NullPointerException ex){e(ex);}
        return doc;
    }
    
    public Document ponerElementosEtiqueta(String etiqueta, 
        String etiquetaPadre, List<String> elementosTextos, Document doc){        
        try{
            NodeList nodes = doc.getElementsByTagName(etiquetaPadre);                    
            Element element;
            for(int i = 0; i < nodes.getLength(); i++){
                element = creaElementoTexto
                (etiqueta, elementosTextos.get(i), doc);
                nodes.item(i).appendChild(element);
            }              
        }catch(NullPointerException | ArrayIndexOutOfBoundsException ex){e(ex);}
        return doc;
    }
    
   /* public List<String> ponerElementos(Element element, String buscado, List<String> list){
        NodeList nodos = element.getChildNodes();
        for (int i = 0; i < nodos.getLength(); i++) {
            Node n = nodos.item(i);
            switch(n.getNodeType()){
                case Node.ELEMENT_NODE:
                    Element e = (Element) n;
                     if(e.getTagName().equals(buscado))
                        list.add(e.getTextContent());
                    ponerElementos(e, buscado, list);
                    break;
                case Node.TEXT_NODE:
                    Text t = (Text) n;
                   
                    break;
            }
        }
        return list;
    }*/
    
}