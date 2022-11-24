package xmlproducto;

import axenda.UtilidadesXML;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.*;
import serializaproducto.Produto;

/**
 *
 * @author dam205
 */
public class CrearXmlPedidos {
    
    //Atributos de clase CrearXmlPedidos
    UtilidadesXML utilidadesXML = new UtilidadesXML();
    private List<Pedido> list = new ArrayList<>();
    private Document doc;
    
    public CrearXmlPedidos(){}
    
    //Generar lista de pedidos con las dos opciones
    public List<Pedido> xeraListaPedidos(){
        DatosPedidos datosPedidos = new DatosPedidos();
        list = new ArrayList<>();
        Boolean aleatorio = false;
        if(aleatorio)
            list = datosPedidos.xeraPedidosAzar();
        else list = datosPedidos.xeraPedidos();
        return list;
    }
   
    //Guardar la lista de pedidos en un fichero dat
    public void gardaListaPedidos(String ruta, List<Pedido> list) {
        if(list.isEmpty()) //Si esta vacio la lista la genera
            list = xeraListaPedidos();
        try {
            File file = new File(ruta+".dat");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for(int i = 0; i < list.size(); i++)
                oos.writeObject(list.get(i));
            oos.close();
            fos.close();                 
        } catch (FileNotFoundException e) {System.err.println(e);} 
        catch (IOException e) {System.err.println(e);} 
    }
  
    //Leer los pedidos del fichero dat al arraylist pedidos que devuelve
    public List<Pedido> lePedidos(String ruta){  
        list = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(ruta+".dat");
            ObjectInputStream ois = new ObjectInputStream(fis); 
            while(fis.available() > 0)
                list.add((Pedido) ois.readObject());
            ois.close();
            fis.close(); 
        } catch (FileNotFoundException e) {System.err.println(e);} 
        catch (IOException e) {System.err.println(e);} 
        catch (ClassNotFoundException e) {System.err.println(e);}
        return list;
    }
    
    //mostrar por pantalla los pedidos desde el arraylist
    public void mostraPedidos(List<Pedido> list){
        for(int i = 0; i < list.size(); i++)
            System.out.println(list.get(i).toString());
    }    
    
    //Generar el documento Xml con todos los elementos y nodos
    public void xeraXmlPedidos(String ruta){
        doc = utilidadesXML.creaDOMBaleiro(ruta);               
        //Crear nodos en el documento creado y guardar los datos
        doc = documentPedidos(doc);        
        //Escribir los datos guardados en un fichero nuevo con mismo nombre
        utilidadesXML.DOMaXML(doc, ruta+".xml");
        //Eliminar los datos de los pedidos
        if(!list.isEmpty())
            list.removeAll(list);
        doc = null;
    }
    
    //Metodo para generar los elementos del documento pedidos
    private Document documentPedidos(Document doc){
        int i = 0;
        for(Pedido ped: list){
            Element idPedido = doc.createElement("idPedido");
            idPedido.appendChild(doc.createTextNode
            (String.valueOf(ped.getIdPedido())));

            Element nomeCliente = doc.createElement("nomeCliente");
            nomeCliente.appendChild(doc.createTextNode
            (ped.getNomeCliente()));

            Element produtos = elementoProdutos(doc, i);
            i++;
            
            Element pedido = doc.createElement("pedido");
            pedido.appendChild(idPedido);
            pedido.appendChild(nomeCliente);
            pedido.appendChild(produtos);

            Element raiz = doc.getDocumentElement();
            raiz.appendChild(pedido);
        }  
        return doc;
    }
    
    //Metodo para generar los elementos del elemento produtos
    private Element elementoProdutos(Document doc, int i){
        Element produtos = doc.createElement("produtos");
        List<Produto> lProdutos = new ArrayList<Produto>();
        lProdutos = list.get(i).getProdutos();
        int j = 0;
        for(Produto pro: lProdutos){
            Element idProduto = doc.createElement("idProduto");
            idProduto.appendChild(doc.createTextNode
            (String.valueOf(lProdutos.get(j).getIdProduto())));

            Element descricion = doc.createElement("descricion");
            descricion.appendChild(doc.createTextNode
            (lProdutos.get(j).getDescricion()));

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
        return produtos;
    }
    
    //Leer el fichero Xml, devolver y guardar en memoria el documento
    public Document leXmlPedidos(String ruta){
        Document doc = null;    
        doc = utilidadesXML.XMLaDOM(ruta+".xml");        
        return doc;
    }
        
    public void mostraXmlPedidos(Element element){
        try{
            utilidadesXML.mostraContidoElemento(element);
        }catch(NullPointerException e){System.err.println(e);}
    }    
    
}