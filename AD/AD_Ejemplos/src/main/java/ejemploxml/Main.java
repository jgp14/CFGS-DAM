/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploxml;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
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
 * @author marco
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String ruta = "instituto.xml";
        Document doc = null;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(ruta);
        }
        catch (IOException | ParserConfigurationException | SAXException ex) {
            System.err.println(ex);
        }
        
        Document documento = null;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            DOMImplementation implementation = db.getDOMImplementation();
            documento = implementation.createDocument(null, "instituto", null);
            documento.setXmlVersion("1.0");
        }
        catch (ParserConfigurationException ex) {
            System.err.println(ex);
        }
        
        Element raiz = doc.getDocumentElement();
        NodeList nl = doc.getElementsByTagName("aula");
        if (nl.getLength() > 0) {
            Element e = (Element) nl.item(0);
        }
        for (int i = 0; i < nl.getLength(); i++) {
            Element e = (Element) nl.item(i);
            System.out.println(e.getTextContent());
        }
        
        NodeList nodos = raiz.getChildNodes();
        for (int i = 0; i < nodos.getLength(); i++) {
            Node n = nodos.item(i);
            switch(n.getNodeType()){
                case Node.ELEMENT_NODE:
                    Element e = (Element) n;
                    System.out.println(e);
                    break;
                case Node.TEXT_NODE:
                    Text t = (Text) n;
                    break;
                case Node.ATTRIBUTE_NODE:
                    Attr a = (Attr) n;
                    break;
                case Node.COMMENT_NODE:
                    Comment c = (Comment) n;
                    break;
            }
        }
        
        Element modulos = (Element) doc.getElementsByTagName("modulos").item(0);
        Element modulo = doc.createElement("modulo");
        Text textoModulo = doc.createTextNode("EIE");
        modulo.appendChild(textoModulo);
        modulos.appendChild(modulo);
        
        Element padre = (Element) modulo.getParentNode();
        padre.removeChild(modulo);
        
        Element otroModulo = doc.createElement("modulo");
        otroModulo.setTextContent("PMDM");
        System.out.println(otroModulo.getTextContent());
        
        otroModulo.setAttribute("completo", "no");
        System.out.println(padre.getAttribute("completo"));
        
        
    }
    
}
