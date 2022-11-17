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
            Object object = null;    
            while(fis.available() > 0){
                object = Clase.cast(ois.readObject());
                list.add(object);
            } 
            XStream xs = new XStream();
            xs .setMode(XStream.NO_REFERENCES);
            xs.alias(nameSubItem, SubClase);
            xs.alias(nameItem, Clase);
            xs.alias(raiz, List.class);            
            xs.toXML(list, new FileOutputStream(new File(raiz+"ListaMal.xml")));
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
    
    public Lista datToXMLMal(String raiz,
        String nameItem, String nameSubItem, Class Clase, Class SubClase){
        Lista lista = new Lista();      
        try{
            List<Object> list = new ArrayList<>();                  
            FileInputStream fis = new FileInputStream(raiz+".dat");
            ObjectInputStream ois = new ObjectInputStream(fis);                               
            Object object = null;    
            while(fis.available() > 0){
                object = Clase.cast(ois.readObject());
                list.add(object);
            } 
            lista.setLista(list);
            XStream xs = new XStream();
            xs .setMode(XStream.NO_REFERENCES);
            xs.alias(nameSubItem, SubClase);
            xs.alias(nameItem, Clase);
            xs.alias(raiz, Lista.class);            
            xs.toXML(lista, new FileOutputStream(new File(raiz+".xml")));
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
    
    //convertir de la memoria a archivo xml mal
    public void memDatToXMLMal(String raiz, String nameItem,
            String nameSubItem, Class Clase, Class SubClase, List list){
        try {            
            XStream xs = new XStream();
            xs .setMode(XStream.NO_REFERENCES);
            xs .alias(nameSubItem, SubClase);
            xs .alias(nameItem, Clase);
            xs .alias(raiz, List.class);
            xs .toXML(list, new FileOutputStream(raiz+"ListaMal.xml"));
        } catch (FileNotFoundException ex) {
            System.out.println("Error: excepcion archivo no encontrado");
        }
    }
     
    //convertir de la memoria archivo xml bien
    public void memDatToXML(String raiz, String nameItem, String nameSubItem, 
            Class Clase, Class SubClase, List list){
        try {
            Lista listaNueva = new Lista();
            for(int i = 0; i < list.size(); i++)
                listaNueva.getLista().add(list.get(i));

            //Instanciar objeto de XStream
            XStream xstream = new XStream();
            xstream.setMode(XStream.NO_REFERENCES);
            xstream.alias(nameSubItem, SubClase);
            xstream.alias(nameItem, Clase);
            xstream.alias(raiz, Lista.class);
            xstream.toXML(listaNueva, new FileOutputStream(raiz+".xml"));
        } catch (FileNotFoundException ex) {
            System.out.println("Error: excepcion archivo no encontrado");
        }
    } 
    
    public void verXMLMal(String raiz, String nameItem, String nameSubItem,
            Class Clase, Class SubClase, List list){
        XStream xs = new XStream(new DomDriver());
        xs.setMode(XStream.NO_REFERENCES);
        xs.alias(nameSubItem, SubClase);
        xs.alias(nameItem, Clase);
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
    
    //Visualizar lista
    public void verXML(String raiz, String nameItem, String nameSubItem,
            Class Clase, Class SubClase, List list){
        Lista lista = new Lista();
        lista.setLista(list);
        XStream xs = new XStream(new DomDriver());
        xs.setMode(XStream.NO_REFERENCES);
        xs.alias(nameSubItem, SubClase);
        xs.alias(nameItem, Clase);
        xs.alias(raiz, Lista.class);
        xs.addPermission(AnyTypePermission.ANY);
        try {
            xs.fromXML(new FileInputStream(raiz+".xml"),lista);
            System.out.println("\nLista de "+raiz+": \n" + lista);
        } catch (FileNotFoundException ex) {
            System.out.println("Error: excepcion archivo no encontrado");
        }
    }
    
}
