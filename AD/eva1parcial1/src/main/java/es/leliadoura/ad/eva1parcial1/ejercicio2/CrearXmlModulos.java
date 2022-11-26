package es.leliadoura.ad.eva1parcial1.ejercicio2;

import es.leliadoura.ad.eva1parcial1.data.Alumno;
import es.leliadoura.ad.eva1parcial1.data.Modulo;
import es.leliadoura.ad.eva1parcial1.data.Unidad;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author dam2ad
 */
public class CrearXmlModulos {
    UtilXml utilXml = new UtilXml();
    private List<Modulo> modulos = new ArrayList<>();
    private Document doc; 

    public void setModulos(List<Modulo> modulos) {
        this.modulos = modulos;
    }

    public Document getDoc() {
        return doc;
    }

    public void xeraXmlModulos(String ruta){
        //Crear el documento nuevo
        doc = utilXml.creaDOM(ruta);               
        //Crear nodos en el documento creado y guardar los datos
        doc = documentModulos(doc);        
        //Escribir los datos guardados en un fichero nuevo con mismo nombre
        utilXml.guardaXML(doc, ruta+".xml");
    }

    //Metodo para generar los elementos del documento modulos
    private Document documentModulos(Document doc){
        int i = 0;
        for(Modulo mod: modulos){
            Element curso = doc.createElement("curso");
            curso.appendChild(doc.createTextNode
            (String.valueOf(mod.getCurso())));

            Element descripcion = doc.createElement("descripcion");
            descripcion.appendChild(doc.createTextNode
            (String.valueOf(mod.getDescripcion())));

            Element alumnos = elementoAlumnos(doc, i);
            
            Element unidades = elementoUnidades(doc, i);
            i++;
            
            Element modulo = doc.createElement("modulo");
            modulo.appendChild(curso);
            modulo.appendChild(descripcion);
            modulo.appendChild(alumnos);
            modulo.appendChild(unidades);

            Element raiz = doc.getDocumentElement();
            raiz.appendChild(modulo);
        }  
        return doc;
    }
    
    //Metodo para generar los elementos del elemento alumnos
    private Element elementoAlumnos(Document doc, int i){
        Element alumnos = doc.createElement("alumnos");
        List<Alumno> lAlumnos = new ArrayList<Alumno>();
        lAlumnos = modulos.get(i).getAlumnos();
        int j = 0;
        for(Alumno alu: lAlumnos){
            Element nombre = doc.createElement("nombre");
            nombre.appendChild(doc.createTextNode
            (String.valueOf(lAlumnos.get(j).getNombre())));

            Element descricion = doc.createElement("dni");
            descricion.appendChild(doc.createTextNode
            (String.valueOf(lAlumnos.get(j).getDni())));

            Element alumno = doc.createElement("alumno");
            alumno.appendChild(nombre);
            alumno.appendChild(descricion);

            alumnos.appendChild(alumno);
            j++;
        }
        return alumnos;
    }
    
    //Metodo para generar los elementos del elemento alumnos
    private Element elementoUnidades(Document doc, int i){
        Element unidades = doc.createElement("unidades");
        List<Unidad> lUnidades = new ArrayList<Unidad>();
        lUnidades = modulos.get(i).getUnidades();
        int j = 0;
        for(Unidad uni: lUnidades){
            Element titulo = doc.createElement("titulo");
            titulo.appendChild(doc.createTextNode
            (String.valueOf(lUnidades.get(j).getTitulo())));

            Element descricion = doc.createElement("descripcion");
            descricion.appendChild(doc.createTextNode
            (String.valueOf(lUnidades.get(j).getDescripcion())));

            Element unidad = doc.createElement("unidad");
            unidad.appendChild(titulo);
            unidad.appendChild(descricion);

            unidades.appendChild(unidad);
            j++;
        }
        return unidades;
    }
    
    public Document leXmlModulos(Document doc, String ruta){  
        utilXml.guardaXML(doc, ruta+".xml");        
        return doc;
    }
    
}



















/*
 //Atributos de clase CrearXmlPedidos
    UtilidadesXML utilidadesXML = new UtilidadesXML();
    private List<Pedido> pedidos = new ArrayList<Pedido>();
    private String ruta = "pedidos"; 
    private File fileDat = new File(ruta+".dat");
    private Document doc;
    private Boolean aleatorio = false;
    
    //Constructor de generar los objetos 
    public CrearXmlPedidos(){}

    public CrearXmlPedidos(ArrayList<Pedido> pedidos, 
            String ruta, Document doc) {        
        this.pedidos = pedidos;
        this.ruta = ruta;
        this.doc = doc;
    }        

    public void setAleatorio(Boolean aleatorio) {
        this.aleatorio = aleatorio;
    }        

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    
    //Generar lista de pedidos con las dos opciones
    public List<Pedido> xeraListaPedidos(){
        DatosPedidos datosPedidos = new DatosPedidos();
        if(aleatorio)
            pedidos = datosPedidos.xeraPedidosAzar();
        else pedidos = datosPedidos.xeraPedidos();
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
    public List<Pedido> lePedidos(){    
        gardaListaPedidos();
        try{
            FileInputStream fis = new FileInputStream(fileDat);
            ObjectInputStream ois = new ObjectInputStream(fis); 
            while(fis.available() > 0)
                pedidos.add((Pedido) ois.readObject());
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
        for(Pedido pedido : lePedidos())
            System.out.println(pedido.toString());
    }    
    
    //Generar el documento Xml con todos los elementos y nodos
    public void xeraXmlPedidos(){
        //Crear el documento nuevo
        doc = utilidadesXML.creaDOMBaleiro(ruta);               
        //Crear nodos en el documento creado y guardar los datos
        doc = documentPedidos(doc);        
        //Escribir los datos guardados en un fichero nuevo con mismo nombre
        utilidadesXML.DOMaXML(doc, ruta+".xml");
        
        //Eliminar los datos de los pedidos
        if(pedidos.isEmpty() == false)
            pedidos.removeAll(pedidos);
        doc = null;
    }
    
    //Metodo para generar los elementos del documento pedidos
    private Document documentPedidos(Document doc){
        int i = 0;
        for(Pedido ped: pedidos){
            Element idPedido = doc.createElement("idPedido");
            idPedido.appendChild(doc.createTextNode
            (String.valueOf(ped.getIdPedido())));

            Element nomeCliente = doc.createElement("nomeCliente");
            nomeCliente.appendChild(doc.createTextNode
            (String.valueOf(ped.getNomeCliente())));

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
        return produtos;
    }
    
    //Leer el fichero Xml, devolver y guardar en memoria el documento
    public Document leXmlPedidos(){
        Document doc = null;    
        doc = utilidadesXML.XMLaDOM(ruta+".xml");        
        return doc;
    }

*/