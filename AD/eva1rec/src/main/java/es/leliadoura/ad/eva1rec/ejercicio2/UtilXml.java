package es.leliadoura.ad.eva1rec.ejercicio2;

import es.leliadoura.ad.eva1rec.data.Alumno;
import es.leliadoura.ad.eva1rec.data.Modulo;
import es.leliadoura.ad.eva1rec.data.Unidad;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
import org.w3c.dom.Text;
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
    
    //METODO DEVUELVE UNA LISTA DE MODULOS
    public List<Modulo> leeModulos(Document doc){
        List<Modulo> modulos = new ArrayList<>();
        
        NodeList nModulos = doc.getElementsByTagName("modulo");
        for(int i = 0; i < nModulos.getLength(); i++){
            Node nModulo = nModulos.item(i);            
            Modulo modulo = new Modulo();
            
            NodeList moduloHijos = nModulo.getChildNodes();
            for(int j = 0; j < moduloHijos.getLength(); j++){
                Node nModuloAtributo = moduloHijos.item(j);
                
                if(nModuloAtributo.getNodeName().equals("curso")){
                    modulo.setCurso(Long.parseLong(nModuloAtributo.getTextContent()));
                }
                else if(nModuloAtributo.getNodeName().equals("descripcion")){
                    modulo.setDescripcion(nModuloAtributo.getTextContent());
                }
                else if(nModuloAtributo.getNodeName().equals("alumnos")){
                    List<Alumno> alumnos = new ArrayList<>();                    
                    NodeList alumnosHijos = nModuloAtributo.getChildNodes();                    
                    alumnos = leeAlumnos(alumnosHijos);
                    modulo.setAlumnos(alumnos);
                }                
                else if(nModuloAtributo.getNodeName().equals("unidades")){
                    NodeList unidadesHijos = nModuloAtributo.getChildNodes();
                    List<Unidad> unidades = new ArrayList<>();
                    unidades = leeUnidades(unidadesHijos);
                    modulo.setUnidades(unidades);
                }
            }
            modulos.add(modulo);
        }        
        return modulos;
    }
    
    //METODO PRIVADO PARA DEVOLVER UNA LISTA DE ALUMNOS DESDE UN NODELIST
    private List<Alumno> leeAlumnos(NodeList nlAlumnos){
        List<Alumno> alumnos = new ArrayList<>();
        for(int i = 0; i < nlAlumnos.getLength(); i++){
            Node nAlumno = nlAlumnos.item(i);            
            Alumno alumno = new Alumno();
            
            NodeList alumnosHijos = nAlumno.getChildNodes();
            for(int j = 0; j < alumnosHijos.getLength(); j++){
                Node nAlumnoAtributo = alumnosHijos.item(j);
                if(nAlumnoAtributo.getNodeName().equals("nombre")){
                    alumno.setNombre(nAlumnoAtributo.getTextContent());
                }
                else if(nAlumnoAtributo.getNodeName().equals("dni")){
                    alumno.setDni(nAlumnoAtributo.getTextContent());
                }
                
            }
            if(alumno.getNombre() != null && alumno.getDni() != null)
                alumnos.add(alumno);                        
        }
        return alumnos;
    }
    
    //METODO PRIVADO PARA DEVOLVER UNA LISTA DE UNIDADES DESDE UN NODELIST
    private List<Unidad> leeUnidades(NodeList nlUnidades){
        List<Unidad> unidades = new ArrayList<>();
        for(int i = 0; i < nlUnidades.getLength(); i++){
            Node nUnidad = nlUnidades.item(i);            
            Unidad unidad = new Unidad();
            
            NodeList alumnosHijos = nUnidad.getChildNodes();
            for(int j = 0; j < alumnosHijos.getLength(); j++){
                Node nUnidadAtributo = alumnosHijos.item(j);
                if(nUnidadAtributo.getNodeName().equals("titulo")){
                    unidad.setTitulo(nUnidadAtributo.getTextContent());
                }
                else if(nUnidadAtributo.getNodeName().equals("descripcion")){
                    unidad.setDescripcion(nUnidadAtributo.getTextContent());
                }
                
            }
            if(unidad.getTitulo()!= null && unidad.getDescripcion()!= null)
                unidades.add(unidad);                        
        }
        return unidades;
    }    
    
    //METODO OPCIONAL PARA COMPROBAR, TESTEAR Y LEER EL CONTENIDO
    public void mostraElementos(Node node){
        NodeList nl = node.getChildNodes();
        for(int i = 0; i < nl.getLength(); i++){
            Node n = nl.item(i);
            switch (n.getNodeType()) {
                case Node.ELEMENT_NODE:
                    Element elemento = (Element) n; 
                    System.out.println("Elemento: " + elemento.getNodeName());
                    mostraElementos(elemento);
                    break;
                case Node.TEXT_NODE:
                    if(!n.getTextContent().isEmpty() 
                            && !n.getTextContent().isBlank()){
                        Text t = (Text) n;
                        System.out.println("Texto: " + t.getTextContent());
                    }                        
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }

    //METODO PARA BORRAR LOS ELEMENTOS DEL DOCUMENT DOC   
    public void borraElementos(Document doc, String nombre){
        NodeList nl = doc.getElementsByTagName(nombre);
        while(nl.getLength() > 0){
            Node n = nl.item(0);
            Element elementoBorrar = (Element) n;
            elementoBorrar.getParentNode().removeChild(elementoBorrar);
        }
    }
    
}
