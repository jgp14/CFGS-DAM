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
    public void datToXML(String raiz, String rutaDat, String rutaXML, 
        String nameItem, String nameSubItem, Class Clase, Class SubClase, List listado){
        try{
            FileInputStream fis = new FileInputStream(rutaDat);
            ObjectInputStream ois = new ObjectInputStream(fis);                               
            ois.close();
            fis.close(); 
            XStream xs = new XStream();
            xs.alias(nameSubItem, SubClase);
            xs.alias(nameItem, Clase);
            xs.alias(raiz, List.class);            
            xs.toXML(listado, new FileOutputStream(new File(rutaXML)));
        }catch(FileNotFoundException e){
            System.out.println("Error: excepcion archivo no encontrado");
        }catch(Exception e){
            System.out.println("Error: excepcion encontrada");
        }
    }   
    
    //convertir de la memoria a archivo xml mal
    public void memDatToXMLMal(String raiz, String nameItem,
            String nameSubItem, Class Clase, Class SubClase, List list){
        try {            
            //Instanciar objeto de XStream
            XStream xstream = new XStream();
            //Configurar XStream
            //Modo NO_REFERENCES para forzar a que ponga todos los elementos
            //aunque no existan referencias
            xstream.setMode(XStream.NO_REFERENCES);
            //Se indican los alias para renombrar las clases a la etiqueta
            xstream.alias(nameSubItem, SubClase);
            xstream.alias(nameItem, Clase);
            xstream.alias(raiz, List.class);
            //Guardamos el objeto en un fichero XML
            xstream.toXML(list, new FileOutputStream(raiz+"ListaMal.xml"));
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
            System.out.println("\nLista de "+raiz+": \n" + list);
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
