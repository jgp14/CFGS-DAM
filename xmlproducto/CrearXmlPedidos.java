package xmlproducto;

import axenda.UtilidadesXML;
import java.io.*;
import java.util.ArrayList;
import org.w3c.dom.*;
import serializaproducto.Produto;

/**
 *
 * @author user
 */
public class CrearXmlPedidos {
    
    //Atributos de clase CrearXmlPedidos
    private DatosPedidos datosPedidos;
    UtilidadesXML utilidadesXML;
    private ArrayList<Pedido> pedidos;
    private String ruta; 
    private File fileDat;
    private Document doc;
    private Boolean aleatorio;
    
    //Constructor de generar los objetos 
    public CrearXmlPedidos(){
        utilidadesXML = new UtilidadesXML();
        pedidos = new ArrayList<Pedido>();
        datosPedidos = new DatosPedidos();
        ruta = "pedidos";    
        fileDat = new File(ruta+".dat");
        aleatorio = false;
    }

    public CrearXmlPedidos(DatosPedidos datosPedidos, 
            UtilidadesXML utilidadesXML, ArrayList<Pedido> pedidos, 
            String ruta, File fileDat, Document doc, Boolean aleatorio) {
        this.datosPedidos = datosPedidos;
        this.utilidadesXML = utilidadesXML;
        this.pedidos = pedidos;
        this.ruta = ruta;
        this.fileDat = fileDat;
        this.doc = doc;
        this.aleatorio = aleatorio;
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
            FileOutputStream fos = new FileOutputStream(fileDat);
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
        gardaListaPedidos();
        try{
            FileInputStream fis = new FileInputStream(fileDat);
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
        ArrayList<Pedido> pedidos = new ArrayList<>();
        pedidos = lePedidos();
        for(Pedido pedido : pedidos)
            System.out.println(pedido.toString());
        System.out.println();
    }    
    
    //Generar el documento Xml con todos los elementos y nodos
    public void xeraXmlPedidos(){
        //Crear el documento nuevo
        doc = utilidadesXML.creaDOMBaleiro(ruta);               
        //Crear nodos en el documento creado y guardar los datos
        int i = 0;
        for(Pedido ped: pedidos){
            Element idPedido = doc.createElement("idPedido");
            idPedido.appendChild(doc.createTextNode
            (String.valueOf(ped.getIdPedido())));

            Element nomeCliente = doc.createElement("nomeCliente");
            nomeCliente.appendChild(doc.createTextNode
            (String.valueOf(ped.getNomeCliente())));

            Element produtos = doc.createElement("produtos");
            ArrayList<Produto> lProdutos = new ArrayList<Produto>();
            lProdutos = pedidos.get(i).getProdutos();
            int j = 0;
            for(Produto pro: lProdutos){
                Element idProduto = doc.createElement("idProduto");
                idProduto.appendChild(doc.createTextNode
                (String.valueOf(lProdutos.get(j).getIdProduto())));

                Element descricion = doc.createElement("descricion");
                descricion.appendChild(doc.createTextNode
                (String.valueOf(lProdutos.get(j).getDescricion())));

                Element prezo = doc.createElement("prezo");
                prezo.appendChild(doc.createTextNode(
                String.valueOf(lProdutos.get(j).getPrezo())));

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
        utilidadesXML.DOMaXML(doc, ruta+".xml");
        
        //Eliminar los datos de los pedidos
        if(pedidos.isEmpty() == false)
            pedidos.removeAll(pedidos);
        doc = null;
    }
    
    //Leer el fichero Xml, devolver y guardar en memoria el documento
    public Document leXmlPedidos(){
        Document doc = null;    
        doc = utilidadesXML.XMLaDOM(ruta+".xml");        
        return doc;
    }
        
    public void mostraXmlPedidos(Element element){
        utilidadesXML.mostraContidoElemento(element);
    }    
    
    //Menu desplegable con opciones de pedidos
    public static void menuPedidos() {
	System.out.println();
        System.out.println("     PEDIDOS");
	System.out.println(" 1.- Crear pedidos");
	System.out.println(" 2.- Guardar pedidos");
        System.out.println(" 3.- Leer pedidos");
        System.out.println(" 4.- Mostrar pedidos");
        System.out.println(" 5.- Genera xml pedidos");
        System.out.println(" 6.- Leyendo xml pedidos");
        System.out.println(" 7.- Mostrar xml pedidos");
        System.out.println(" 8.- FINAL");        
    }
    
}