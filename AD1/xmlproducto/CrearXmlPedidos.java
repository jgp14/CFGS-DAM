package xmlproducto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

/**
 *
 * @author user
 */
public class CrearXmlPedidos {
    
    //Atributos de clase CrearXmlPedidos
    private DatosPedidos datosPedidos;
    private ArrayList<Pedido> pedidos;
    private String ruta; 
    private File fileDat;
    private File fileXml;
    private Document doc;
    private FileOutputStream fos;
    private ObjectOutputStream oos;  
    private FileInputStream fis;
    private ObjectInputStream ois;
    private Boolean aleatorio;
    
    //Constructor de generar los objetos 
    public CrearXmlPedidos(){
        pedidos = new ArrayList<Pedido>();
        datosPedidos = new DatosPedidos();
        ruta = "pedidos";     
        fileDat = new File(ruta+".dat");
        fileXml = new File(ruta+".xml");        
        aleatorio = false;
    }

    //Intoducir el nombre de los ficheros
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    
    //Generar lista de pedidos con las dos opciones
    public ArrayList<Pedido> xeraListaPedidos(){
        if(aleatorio)
            pedidos = datosPedidos.xeraPedidosAzar();
        else 
            pedidos = datosPedidos.xeraPedidos();
        return pedidos;
    }
   
    //Guardar la lista de pedidos en un fichero dat
    public void gardaListaPedidos() {
        if(pedidos.isEmpty()) //Si esta vacio la lista la genera
            xeraListaPedidos();
        try {
            fos = new FileOutputStream(fileDat);
            oos = new ObjectOutputStream(fos);
            for(Pedido pedido : pedidos)
                oos.writeObject(pedido);
            oos.close();
            fos.close();                 
        } catch (IOException ioe) {
            System.out.println("Error: Fallo en escritura del fichero.");
        }  //Al terminar se elimina la lista en memoria
           pedidos.removeAll(pedidos);  
    }
  
    //Leer los pedidos del fichero dat al arraylist pedidos que devuelve
    public ArrayList<Pedido> lePedidos(){
        Pedido pedido = null;     
        if(pedidos.isEmpty() == false) 
            pedidos.removeAll(pedidos);
        try{
            fis = new FileInputStream(fileDat);
            ois = new ObjectInputStream(fis); 
            while(fis.available() > 0){
                pedido = (Pedido) ois.readObject();
                pedidos.add(pedido);
            }
            ois.close();
            fis.close(); 
        } catch (FileNotFoundException fnfe) {
            System.out.println("Error: El fichero no existe. ");
        } catch (IOException ioe) {
            System.out.println("Error: Fallo en la lectura del fichero. ");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: Clase no encontrada. ");
        }
        return pedidos;
    }
    
    //mostrar por pantalla los pedidos desde el arraylist
    public void mostraPedidos(){
        if(pedidos == null)
            pedidos = lePedidos();
        for(Pedido pedido : pedidos)
            System.out.println(pedido.toString());
        System.out.println();
    }
    
    //Generar el documento Xml con todos los elementos y nodos
    public void xeraXmlPedidos(){
        //Crear el documento nuevo
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            DOMImplementation implementation = db.getDOMImplementation();
            doc = implementation.createDocument
            (null, ruta, null);
            doc.setXmlVersion("1.0");
            
        } catch (ParserConfigurationException ex) {
            System.out.println("Error: excepcion configuracion");
        }
        
        //Crear nodos en el documento creado y guardar los datos
        int i = 0;
        for(Pedido ped: pedidos){
            Element idPedido = doc.createElement("idPedido");
            Text textoIdPedido = doc.createTextNode
            (String.valueOf(ped.getIdPedido()));
            idPedido.appendChild(textoIdPedido);

            Element nomeCliente = doc.createElement("nomeCliente");
            Text textoNomeCliente = doc.createTextNode
            (String.valueOf(ped.getNomeCliente()));
            nomeCliente.appendChild(textoNomeCliente);

            Element produtos = doc.createElement("produtos");
            ArrayList<Produto> lProdutos = new ArrayList<Produto>();
            lProdutos = pedidos.get(i).getProdutos();
            int j = 0;
            for(Produto pro: lProdutos){
                Element idProduto = doc.createElement("idProduto");
                Text textoIdProduto = doc.createTextNode
                (String.valueOf(lProdutos.get(j).getIdProduto()));
                idProduto.appendChild(textoIdProduto);

                Element descricion = doc.createElement("descricion");
                Text textoDescricion = doc.createTextNode
                (String.valueOf(lProdutos.get(j).getDescricion()));
                descricion.appendChild(textoDescricion);

                Element prezo = doc.createElement("prezo");
                Text textoPrezo = doc.createTextNode(
                String.valueOf(lProdutos.get(j).getPrezo()));
                prezo.appendChild(textoPrezo);

                Element produto = doc.createElement("produto");
                produto.appendChild(idProduto);
                produto.appendChild(descricion);
                produto.appendChild(prezo);

                produtos.appendChild(produto);
                j++;
            }
            i++;
            
            Element pedido = doc.createElement("pedido");
            pedido.appendChild(idPedido);
            pedido.appendChild(nomeCliente);
            pedido.appendChild(produtos);

            Element raiz = doc.getDocumentElement();
            raiz.appendChild(pedido);
        }  
        
        //Escribir los datos guardados en un fichero nuevo con mismo nombre
        try{
            //File file = new File("pedidos.xml");
            Transformer transformer = 
                    TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            StreamResult sr = new StreamResult(fileXml);
            DOMSource source = new DOMSource(doc);
            transformer.transform(source, sr);
        } catch (TransformerConfigurationException ex) {
            System.out.println("Error: excepion configuracion transformacion");
        } catch (TransformerException ex) {
            System.out.println("Error: excepion transformacion");
        }     
        //Eliminar los datos de los pedidos
        if(pedidos.isEmpty() == false)
            pedidos.removeAll(pedidos);
        doc = null;
    }

    //Leer el fichero Xml, devolver y guardar en memoria el documento
    public Document leXmlPedidos(){
        Document doc = null;    
        try {
            DocumentBuilderFactory docFactory = 
                    DocumentBuilderFactory.newDefaultInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            doc = docBuilder.parse(fileXml);
            return doc;
        } catch (IOException | ParserConfigurationException | SAXException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    //Opcion1 Mostrar por pantalla los elementos del xml en filas recursivamente
    public void loopNodeXml(Node n) {
        // Mostramos el nombre del nodo
        System.out.print("\n"+n.getNodeName());//Opcion1
        //System.out.println(n.getNodeName());//Opcion2
        // Obtenemos sus hijos
        NodeList hijos = n.getChildNodes();
        for (int i = 0; i < hijos.getLength(); i++) {
            // Obtenemos el hijo i
            Node hijo = hijos.item(i);
            // Si es un nodo
            if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                // Recorremos el hijo recursivamente
                loopNodeXml(hijo);
                // Atributos 
                if (hijo.getAttributes() != null 
                        && hijo.getAttributes().getLength() > 0) {
                    NamedNodeMap atributos = hijo.getAttributes();
                    for (int j = 0; j < atributos.getLength(); j++) {
                        Node attr = atributos.item(j);
                        // Recorremos el atributo recursivamente
                        loopNodeXml(attr);
                    }
                }
                // si el nodo es un texto y no esta vacio
            } else if (hijo.getNodeType() == Node.TEXT_NODE 
                    && !hijo.getTextContent().trim().isEmpty()) {
                // Mostramos el contenido
                System.out.print(" = "+hijo.getTextContent());//Opcion1
                //System.out.println("Valor: " + hijo.getTextContent());//Opcion2
            }
        }
    }
    
    //Opcion2 Convertir el XML en un solo String mostrable en consola
    //https://myskillpoint.com/convert-string-to-xml-and-xml-to-string-in-java/
    public String convertXMLDocumentToString(Document xmlDoc) {
    	//Create a new object of TransformerFactory
    	TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer;       
        try {
            transformer = transformerFactory.newTransformer();
            //Creating object of the Source document that is xml doc
            DOMSource source = new DOMSource(xmlDoc);
            StringWriter strWriter = new StringWriter();
            StreamResult stResult = new StreamResult(strWriter);
            transformer.transform(source, stResult);
            String xmlString = strWriter.getBuffer().toString();
            return xmlString;
        } catch (TransformerConfigurationException ex) {
            System.out.println("Error: excepion configuracion transformacion");
        } catch (TransformerException e) {
            System.out.println("Error: excepion transformacion");
        } 
        return null;
    }
    
    //Opcion3 Mostrar el String unico del documento xml separado por etiquetas
    public void mostraXML(String xmlString) {
        for(int i = 0; i < xmlString.length(); i++){
            System.out.print(xmlString.charAt(i));
        if(xmlString.charAt(i) == '>')                        
            System.out.println();
        else if(xmlString.charAt(i+1) == '<')
            System.out.println();
        } 
    }
}


