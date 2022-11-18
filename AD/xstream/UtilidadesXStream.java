package xstream;

import java.io.*;
import java.util.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

/**
 *
 * @author user
 */
public class UtilidadesXStream {
    
    //Convertir un fichero .dat a .xml
    public List datToXML(String raiz,
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
        }catch(FileNotFoundException e){
            System.out.println("Error: excepcion archivo no encontrado");
        } catch (IOException ex) {
            System.out.println("Error: excepcion de entrada o salida");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: excepcion clase no encontrada");
        }
        return list;
    }   
    
    //Convertir un fichero .dat a .xml mal
    public Lista datToXMLMal(String raiz,
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
            xs.toXML(lista, new FileOutputStream(new File(raiz+"ListaMal.xml")));
            ois.close();
            fis.close();
        }catch(FileNotFoundException e){
            System.out.println("Error: excepcion archivo no encontrado");
        } catch (IOException ex) {
            System.out.println("Error: excepcion de entrada o salida");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: excepcion clase no encontrada");
        }
        return lista;
    }
    
    //convertir de lista en memoria a archivo xml
    public void listToXML(String raiz, String nameItem,
            String nameSubItem, Class Clase, Class SubClase, List list){
        try {            
            XStream xs = new XStream();
            xs = aliasXML(xs, nameItem, nameSubItem, Clase, SubClase);
            xs.alias(raiz, List.class);   
            xs.toXML(list, new FileOutputStream(raiz+".xml"));
        } catch (FileNotFoundException ex) {
            System.out.println("Error: excepcion archivo no encontrado");
        }
    }
     
    //convertir de lista en memoria a archivo xml mal
    public void listToXMLMal(String raiz, String nameItem, 
            String nameSubItem, Class Clase, Class SubClase, List list){
        try {
            Lista listaNueva = new Lista();
            for(int i = 0; i < list.size(); i++)
                listaNueva.getLista().add(list.get(i));
            XStream xs = new XStream();
            xs = aliasXML(xs, nameItem, nameSubItem, Clase, SubClase);
            xs.alias(raiz, Lista.class);  
            xs.toXML(listaNueva, new FileOutputStream(raiz+"ListaMal.xml"));
        } catch (FileNotFoundException ex) {
            System.out.println("Error: excepcion archivo no encontrado");
        }
    } 
    
    //Visualizar lista
    public void verXML(String raiz, String nameItem, String nameSubItem,
            Class Clase, Class SubClase, List list){
        XStream xs = new XStream(new DomDriver());
        xs = aliasXML(xs, nameItem, nameSubItem, Clase, SubClase);
        xs.alias(raiz, List.class);
        xs.addPermission(AnyTypePermission.ANY);
        try {
            xs.fromXML(new FileInputStream(raiz+".xml"));
            System.out.println("\nLista de "+raiz+": \n");
            for(int i = 0; i < list.size(); i++)
                System.out.println(list.get(i));
        } catch (FileNotFoundException ex) {
            System.out.println("Error: excepcion archivo no encontrado");
        }
    }
    
    //Visualizar lista mal
    public void verXMLMal(String raiz, String nameItem, String nameSubItem,
            Class Clase, Class SubClase, List list){
        Lista lista = new Lista();
        lista.setLista(list);
        XStream xs = new XStream(new DomDriver());
        xs = aliasXML(xs, nameItem, nameSubItem, Clase, SubClase);
        xs.alias(raiz, Lista.class);
        xs.addPermission(AnyTypePermission.ANY);
        try {
            xs.fromXML(new FileInputStream(raiz+"ListaMal.xml"),lista);
            System.out.println("\nLista de "+raiz+": \n" + lista);
        } catch (FileNotFoundException ex) {
            System.out.println("Error: excepcion archivo no encontrado");
        }
    }
    
    //Metodo privado para asociar los alias
    private XStream aliasXML(XStream xs, String nameItem, 
            String nameSubItem, Class Clase, Class SubClase){
        xs.setMode(XStream.NO_REFERENCES);
        xs.alias(nameSubItem, SubClase);
        xs.alias(nameItem, Clase);
        return xs;
    }
    
}
