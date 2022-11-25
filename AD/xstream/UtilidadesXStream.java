package xstream;

import java.io.*;
import java.util.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.StreamException;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import java.util.logging.Level;
import java.util.logging.Logger;
import serializaproducto.Produto;
import xmlproducto.Pedido;

/**
 *
 * @author dam205
 */
public class UtilidadesXStream {
    
    //Convertir un fichero .dat a .xml
    public void datToXML(String raiz,
        String nameItem, String nameSubItem, Class Clase, Class SubClase){
        List<Object> list = new ArrayList<>();
        try{            
            FileInputStream fis = new FileInputStream(raiz+".dat");
            ObjectInputStream ois = new ObjectInputStream(fis);                                 
            while(fis.available() > 0)
                list.add(Clase.cast(ois.readObject()));
            XStream xs = new XStream();
            xs = aliasXML(xs, nameItem, nameSubItem, Clase, SubClase);
            xs.alias(raiz, List.class);   
            xs.toXML(list, new FileOutputStream(new File(raiz+".xml")));
            ois.close();
            fis.close();
        }catch(FileNotFoundException e){System.out.println(e);} 
        catch (IOException e) {System.out.println(e);} 
        catch (ClassNotFoundException e) {System.out.println(e);}
    }   
    
    //Convertir un fichero .dat a .xml mal
    public void datToXMLBien(String raiz,
        String nameItem, String nameSubItem, Class Clase, Class SubClase){
        Lista lista = new Lista();
        List<Object> list = new ArrayList<>();
        try{                              
            FileInputStream fis = new FileInputStream(raiz+".dat");
            ObjectInputStream ois = new ObjectInputStream(fis);                                 
            while(fis.available() > 0)
                list.add(Clase.cast(ois.readObject()));            
            lista.setLista(list);    
            XStream xs = new XStream();
            xs = aliasXML(xs, nameItem, nameSubItem, Clase, SubClase);
            xs.alias(raiz, Lista.class);
            xs.toXML(lista, new FileOutputStream(new File(raiz+"B.xml")));
            ois.close();
            fis.close();
        }catch(FileNotFoundException e){System.err.println(e); } 
        catch (IOException e) {System.err.println(e);} 
        catch (ClassNotFoundException e) {System.err.println(e);}
    }
    
    //convertir de lista en memoria a archivo xml
    public void listToXML(String raiz, String nameItem,
            String nameSubItem, Class Clase, Class SubClase, List list){
        try {            
            XStream xs = new XStream();
            xs = aliasXML(xs, nameItem, nameSubItem, Clase, SubClase);
            xs.alias(raiz, List.class);   
            xs.toXML(list, new FileOutputStream(new File(raiz+".xml")));
        } catch (FileNotFoundException e) {System.err.println(e);}
    }
     
    //convertir de lista en memoria a archivo xml mal
    public void listToXMLBien(String raiz, String nameItem, 
            String nameSubItem, Class Clase, Class SubClase, List list){
        try {
            Lista listaNueva = new Lista();
            for(int i = 0; i < list.size(); i++)
                listaNueva.getLista().add(list.get(i));
            XStream xs = new XStream();
            xs = aliasXML(xs, nameItem, nameSubItem, Clase, SubClase);
            xs.alias(raiz, Lista.class);  
            xs.toXML(listaNueva, new FileOutputStream(new File(raiz+"B.xml")));
        } catch (FileNotFoundException e) {System.err.println(e);}
    } 
    
    //Visualizar lista
    public void verXML(String raiz, String nameItem, String nameSubItem,
            Class Clase, Class SubClase){
        XStream xs = new XStream(new DomDriver());
        xs = aliasXML(xs, nameItem, nameSubItem, Clase, SubClase);
        xs.alias(raiz, List.class);
        xs.addPermission(AnyTypePermission.ANY);
        List list = new ArrayList<>();
        try {
            xs.fromXML(new FileInputStream(raiz+".xml"), list);
            System.out.println("\nLista de "+raiz+": \n");
            for(int i = 0; i < list.size(); i++)
                System.out.println(list.get(i));
        } catch (FileNotFoundException e) {System.err.println(e);}
    }
    
    //Visualizar lista mal
    public void verXMLBien(String raiz, String nameItem, String nameSubItem,
            Class Clase, Class SubClase, List list){
        Lista lista = new Lista();
        lista.setLista(list);
        XStream xs = new XStream(new DomDriver());
        xs = aliasXML(xs, nameItem, nameSubItem, Clase, SubClase);
        xs.alias(raiz, Lista.class);
        xs.addPermission(AnyTypePermission.ANY);
        try {
            xs.fromXML(new FileInputStream(raiz+"B.xml"),lista);
            System.out.println("\nLista de "+raiz+": \n" + lista);
        } catch (FileNotFoundException e) {System.err.println(e);}
    }
    
    //Metodo privado para asociar los alias
    private XStream aliasXML(XStream xs, String nameItem, 
            String nameSubItem, Class Clase, Class SubClase){
        xs.setMode(XStream.NO_REFERENCES);
        xs.alias(nameSubItem, SubClase);
        xs.alias(nameItem, Clase);
        return xs;
    }
    
    //METODOS FUNCIONALES
    //===================
    
    
    //Escribir y leer-mostrar pedidos con clase Lista y etiqueta sobrante
    public List datToXML(String raiz, Class clase){
        List<Object> list = new ArrayList<>();
        try{            
            FileInputStream fis = new FileInputStream(raiz+".dat");
            ObjectInputStream ois = new ObjectInputStream(fis);                                 
            while(fis.available() > 0)
                list.add((clase).cast(ois.readObject()));
            XStream xs = new XStream();
            xs.setMode(XStream.NO_REFERENCES);
            xs.alias("produto", Produto.class);
            xs.alias("pedido", Pedido.class);
            xs.alias(raiz, List.class); 
            xs.toXML(list, new FileOutputStream(new File(raiz+".xml")));
            ois.close();
            fis.close();
        }catch(FileNotFoundException e){System.err.println(e);} 
        catch (IOException e) {System.err.println(e);} 
        catch (ClassNotFoundException e){System.err.println(e);}
        return list;
    }   
    
    public void mostrarXML(String raiz, Class clase){
        XStream xs = new XStream(new DomDriver());
        xs.setMode(XStream.NO_REFERENCES);
        xs.alias("produto", Produto.class);
        xs.alias("pedido", Pedido.class);
        xs.alias(raiz, List.class); 
        xs.addPermission(AnyTypePermission.ANY);
        Lista listaLeida = new Lista();
        listaLeida.setLista(datToXML(raiz, clase));
        try {
            xs.fromXML(new FileInputStream(raiz+".xml"), listaLeida);
            System.out.println("\nLista de "+raiz+": \n" + listaLeida);
        } catch (FileNotFoundException e) {System.err.println(e);} 
        catch(StreamException e){System.err.println(e);}
    }
    
    
    //Escribir y leer-mostrar pedidos con clase Lista
    public void datToXMLBien(String raiz){
        Lista lista = new Lista();
        try{            
            FileInputStream fis = new FileInputStream(raiz+".dat");
            ObjectInputStream ois = new ObjectInputStream(fis);                                 
            while(fis.available() > 0)
                lista.getLista().add((Object)(ois.readObject()));
            XStream xs = new XStream();
            xs.setMode(XStream.NO_REFERENCES);
            xs.alias("produto", Produto.class);
            xs.alias("pedido", Pedido.class);
            xs.alias(raiz, Lista.class); 
            xs.toXML(lista, new FileOutputStream(new File(raiz+"B.xml")));
            ois.close();
            fis.close();
        } catch(FileNotFoundException e){System.err.println(e);} 
        catch (IOException e){System.err.println(e);} 
        catch (ClassNotFoundException e){System.err.println(e);}
    }   
    
    public void mostrarXMLBien(String raiz){
        XStream xs = new XStream(new DomDriver());
        xs.setMode(XStream.NO_REFERENCES);
        xs.alias("produto", Produto.class);
        xs.alias("pedido", Pedido.class);
        xs.alias(raiz, ListaPedidos.class); 
        xs.addPermission(AnyTypePermission.ANY);
        Lista listaLeida = new Lista();
        try {
            xs.fromXML(new FileInputStream(raiz+"B.xml"), listaLeida);
            System.out.println("\nLista de "+raiz+": \n" + listaLeida);
        } catch (FileNotFoundException e) {System.err.println(e);} 
        catch(StreamException e){System.err.println(e);}
    }
    
    
    //Escribir y leer-mostrar pedidos con clases especificas ListaPedidos
    public void datToXMLPedido(String raiz){
        ListaPedidos listaPedidos = new ListaPedidos();
        try{            
            FileInputStream fis = new FileInputStream(raiz+".dat");
            ObjectInputStream ois = new ObjectInputStream(fis);                                 
            while(fis.available() > 0)
                listaPedidos.getPedidos().add((Pedido)(ois.readObject()));
            XStream xs = new XStream();
            xs.setMode(XStream.NO_REFERENCES);
            xs.alias("produto", Produto.class);
            xs.alias("produtos", ListaProdutos.class);
            xs.alias("pedido", Pedido.class);
            xs.alias("pedidos", ListaPedidos.class); 
            xs.toXML(listaPedidos, new FileOutputStream(new File(raiz+".xml")));
            ois.close();
            fis.close();
        } catch(FileNotFoundException e){System.err.println(e);} 
        catch (IOException e){System.err.println(e);} 
        catch (ClassNotFoundException e){System.err.println(e);}
    } 
        
    public void mostrarXMLPedidos(String ruta){
        XStream xs = new XStream(new DomDriver());
        xs.setMode(XStream.NO_REFERENCES);
        xs.alias("produto", Produto.class);
        xs.alias("produtos", ListaProdutos.class);
        xs.alias("pedido", Pedido.class);
        xs.alias("pedidos", ListaPedidos.class);
        xs.addImplicitCollection(ListaPedidos.class, "pedidos");
        xs.addPermission(AnyTypePermission.ANY);
        ListaPedidos listaPedidos = new ListaPedidos();
        try {
            xs.fromXML(new FileInputStream(ruta+".xml"), listaPedidos);
            System.out.println("\nLista de pedidos: \n"+listaPedidos);
        } catch (FileNotFoundException e) {System.err.println(e);}
        catch(StreamException e){System.err.println(e);}
    }
    
    public void datToXMLProduto(String raiz){
        ListaProdutos listaProdutos = new ListaProdutos();
        try{            
            FileInputStream fis = new FileInputStream(raiz+".dat");
            ObjectInputStream ois = new ObjectInputStream(fis);                                 
            while(fis.available() > 0)
                listaProdutos.getProdutos().add((Produto)(ois.readObject()));
            XStream xs = new XStream();
            xs.setMode(XStream.NO_REFERENCES);
            xs.alias("produto", Produto.class);
            xs.alias("produtos", ListaProdutos.class); 
            xs.toXML(listaProdutos, new FileOutputStream(new File(raiz+".xml")));
            ois.close();
            fis.close();
        } catch(FileNotFoundException e){System.err.println(e);} 
        catch (IOException e){System.err.println(e);} 
        catch (ClassNotFoundException e){System.err.println(e);}
    } 
    
    public void mostrarXMLProdutos(String ruta){
    XStream xs = new XStream(new DomDriver());
        xs.setMode(XStream.NO_REFERENCES);
        xs.alias("produto", Produto.class);
        xs.alias("produtos", ListaProdutos.class);
        xs.addImplicitCollection(ListaProdutos.class, "produtos");
        xs.addPermission(AnyTypePermission.ANY);
        ListaProdutos listaLeida = new ListaProdutos();
        try {
            xs.fromXML(new FileInputStream(ruta+".xml"), listaLeida);
            System.out.println("\nLista de "+ruta+": \n" + listaLeida);
        } catch (FileNotFoundException e) {System.err.println(e);}
    }

}
