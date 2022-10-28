package axenda;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Comment;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;


/**
 *
 * @author dam205
 */
public class UtilidadesXML {
        
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
    
    public Element creaElementoTexto(String etiqueta, String texto, Document doc){
        Element element = null;
        element = doc.createElement(etiqueta);
        Text text = doc.createTextNode(texto);   
        element.appendChild(text);
        return element;
    }    
    
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
    
    public void mostraElementoRaiz(Document doc){
        Element raiz = doc.getDocumentElement();
        System.out.println(raiz.getTagName());
    }
    
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
                    System.out.println("Texto:" + t.getWholeText());
                    break;
                case Node.ATTRIBUTE_NODE:
                    Attr a = (Attr) n;
                    break;
                case Node.COMMENT_NODE:
                    Comment c = (Comment) n;
                    break;
            }
        }
    }
    
    public Document borraElementosEtiqueta(String etiqueta, Document doc){        
        NodeList nodos = doc.getElementsByTagName(etiqueta);
        for (int i = 0; i < nodos.getLength(); i++) {
            Node n = nodos.item(i);
            Element e = (Element) n;
            e.getParentNode().removeChild(e);
            borraElementosEtiqueta(etiqueta, doc);
        }
        return doc;
    }
    
    public Document DOMaXML(Document doc, String nomeXML){
        try{
            File f = new File(nomeXML);
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            StreamResult result = new StreamResult(f);
            DOMSource source = new DOMSource(doc);
            transformer.transform(source, result);
        } catch(TransformerException ex) {
            System.out.println("Error: excepcion de transformacion");
        }
        return doc;
    }
}
