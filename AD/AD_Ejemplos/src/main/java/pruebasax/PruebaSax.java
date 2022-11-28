package pruebasax;

import java.io.IOException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author marco
 */
public class PruebaSax {

    public static void main(String args[]) {
        XMLReader procesadorXML = null;
        try {
            procesadorXML = XMLReaderFactory.createXMLReader();
        } catch (SAXException ex) {
            System.out.println("" + ex);
        }
        GestorContenido gestor = new GestorContenido();
        procesadorXML.setContentHandler(gestor); // Asigna mi propio Handler al XMLReader

        InputSource archivoXML = new InputSource("axenda.xml");
        try {
            procesadorXML.parse(archivoXML);
        } catch (IOException | SAXException ex) {
            System.out.println(ex);
        }
    }
}


