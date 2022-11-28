package pruebasax;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author marco
 */
public class GestorContenido extends DefaultHandler{
    
    public GestorContenido() {
        super();
    }
    
    @Override
    public void startDocument() {
        System.out.println("Inicio del documento XML");
    }
    
    @Override
    public void endDocument() {
        System.out.println("Final del documento XML");
    }
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        System.out.println("<" + localName + ">" );
    }
    
    @Override
    public void endElement(String uri, String localName, String qName){
        System.out.println("</" + localName + ">" );
    }
    
    @Override
    public void characters(char[] ch, int start, int length){
        String chars = new String (ch, start, length);
        System.out.println(chars);
    }
    
}
