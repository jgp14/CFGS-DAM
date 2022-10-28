package xmlproducto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
 * @author user
 */
public class CrearXmlPedidos {
    
    //Atributos de clase CrearXmlPedidos
    private DatosPedidos datosPedidos;
    private ArrayList<Pedido> pedidos;
    private String ruta; 
    private Document doc;
    private Boolean aleatorio;
    
    //Constructor de generar los objetos 
    public CrearXmlPedidos(){
        pedidos = new ArrayList<Pedido>();
        datosPedidos = new DatosPedidos();
        ruta = "pedidos";      
        aleatorio = false;
    }

    //Intoducir el nombre de los ficheros
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public void setAleatorio(Boolean aleatorio) {
        this.aleatorio = aleatorio;
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
            File f = new File(ruta+".dat");
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
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
            File f = new File(ruta+".dat");
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis); 
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
    
    private Document creaDOMBaleiro(String raiz){
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
    
    private void DOMaXML(Document doc, String nomeXML){
        try{
            File f = new File(nomeXML);
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            StreamResult result = new StreamResult(f);
            DOMSource source = new DOMSource(doc);
            transformer.transform(source, result);
        }catch (TransformerConfigurationException ex) {
            System.out.println("Error: excepion configuracion transformacion");
        }catch(TransformerException ex) {
            System.out.println("Error: excepcion de transformacion");
        }
    }
    
    //Generar el documento Xml con todos los elementos y nodos
    public void xeraXmlPedidos(){
        //Crear el documento nuevo
        doc = creaDOMBaleiro(ruta);               
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
        DOMaXML(doc, ruta+".xml");
        
        //Eliminar los datos de los pedidos
        if(pedidos.isEmpty() == false)
            pedidos.removeAll(pedidos);
        doc = null;
    }
    
    //Leer el fichero Xml, devolver y guardar en memoria el documento
    public Document leXmlPedidos(String nomeXML){
        Document doc = null;    
        try {
            DocumentBuilderFactory dbf = 
                    DocumentBuilderFactory.newDefaultInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(nomeXML);
        } catch (IOException | ParserConfigurationException | SAXException ex) {
            ex.printStackTrace();
        }
        return doc;
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
}


