package es.leliadoura.ad.eva1parcial1.ejercicio3;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.StreamException;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import es.leliadoura.ad.eva1parcial1.data.Alumno;
import es.leliadoura.ad.eva1parcial1.data.Ciclo;
import es.leliadoura.ad.eva1parcial1.data.Modulo;
import es.leliadoura.ad.eva1parcial1.data.Unidad;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marco
 */
public class UtilXstream {
    
    /*
    public void listToXMLModulosMal(String raiz, List<Modulo> listModulos){
        try {            
            XStream xs = new XStream();
            xs.setMode(XStream.NO_REFERENCES);
            xs.alias("alumno", Alumno.class);
            xs.alias("alumnos", ListaAlumnos.class);
            xs.alias("unidad", Unidad.class);
            xs.alias("unidades", ListaUnidades.class);
            xs.alias("modulo", Modulo.class);
            xs.alias("modulos", List.class);  
            xs.toXML(listModulos, new FileOutputStream(new File(raiz+"XS2Mal.xml")));
        } catch (FileNotFoundException ex) {System.out.println(ex);}
    }
    
    
    public List<Ciclo> datToXMLCiclosMal(String raiz){
        List<Ciclo> listCiclos = new ArrayList<>();
        try{            
            FileInputStream fis = new FileInputStream(raiz+".dat");
            ObjectInputStream ois = new ObjectInputStream(fis);                                 
            while(fis.available() > 0)
                listCiclos.add(Ciclo.class.cast(ois.readObject()));
            XStream xs = new XStream();
            xs.alias("alumno", Alumno.class);
            xs.alias("alumnos", ListaAlumnos.class);
            xs.alias("unidad", Unidad.class);
            xs.alias("unidades", ListaUnidades.class);
            xs.alias("modulo", Modulo.class);
            xs.alias("modulos", ListaModulos.class);  
            xs.alias("ciclo", Ciclo.class);  
            xs.alias(raiz, List.class);  
            xs.toXML(listCiclos, new FileOutputStream(new File(raiz+"XSMal.xml")));
            ois.close();
            fis.close();
        }catch(FileNotFoundException ex){System.out.println(ex);} 
        catch (IOException ex) {System.out.println(ex);} 
        catch (ClassNotFoundException ex) {System.out.println(ex);}
        return listCiclos;
    }   
    
    public void mostrarXMLCiclosMal(String raiz){
        XStream xs = new XStream(new DomDriver());
        xs.setMode(XStream.NO_REFERENCES);
        xs.alias("alumno", Alumno.class);
        xs.alias("alumnos", ListaAlumnos.class);
        xs.alias("unidad", Unidad.class);
        xs.alias("unidades", ListaUnidades.class);
        xs.alias("modulo", Modulo.class);
        xs.alias("modulos", List.class);  
        xs.alias("ciclo", Modulo.class);
        xs.alias("ciclos", List.class); 
        xs.addPermission(AnyTypePermission.ANY);
        ListaCiclos listaCiclos = new ListaCiclos();
        listaCiclos.setCiclos(datToXMLCiclosMal(raiz));
        try {
            xs.fromXML(new FileInputStream(raiz+"XSMal.xml"), listaCiclos);
            System.out.println("\nLista de ciclos: \n");
            for(int i = 0; i < listaCiclos.getCiclos().size(); i++)
                System.out.println(listaCiclos.getCiclos().get(i));
        } catch (FileNotFoundException ex) {System.out.println(ex);}
        catch(StreamException ex){System.out.println(ex);}
    }*/
       
    public void listToXMLModulos(String raiz, List<Modulo> listModulos){
        ListaModulos listaLeida = new ListaModulos();
        listaLeida.setModulos(listModulos);
        try {            
            XStream xs = new XStream();
            xs.setMode(XStream.NO_REFERENCES);
            xs.alias("alumno", Alumno.class);
            xs.alias("alumnos", ListaAlumnos.class);
            xs.alias("unidad", Unidad.class);
            xs.alias("unidades", ListaUnidades.class);
            xs.alias("modulo", Modulo.class);
            xs.alias("modulos", ListaModulos.class);  
            xs.toXML(listaLeida, new FileOutputStream(new File(raiz+"XS2.xml")));
        } catch (FileNotFoundException ex) {System.out.println(ex);}
    }
    
    //METODOS A UTILIZAR
    
    public void guardaLista(String ruta, List list){
        try {
            File file = new File(ruta+".dat");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for(int i = 0; i<list.size(); i++)
                oos.writeObject(list.get(i));
            oos.close(); 
            fos.close();
        } catch (FileNotFoundException ex) {System.err.println(ex);} 
        catch (IOException ex) {System.err.println(ex);}
    }
    
    public void datToXMLModulos(String raiz){
        ListaModulos listaModulos = new ListaModulos();
        try {      
            FileInputStream fis = new FileInputStream(raiz+".dat");
            ObjectInputStream ois = new ObjectInputStream(fis);                                 
            while(fis.available() > 0)
                listaModulos.getModulos().add((Modulo)(ois.readObject()));
            XStream xs = new XStream();
            xs.setMode(XStream.NO_REFERENCES);
            xs.alias("alumno", Alumno.class);
            xs.alias("alumnos", ListaAlumnos.class);
            xs.alias("unidad", Unidad.class);
            xs.alias("unidades", ListaUnidades.class);
            xs.alias("modulo", Modulo.class);
            xs.alias("modulos", ListaModulos.class);   
            xs.toXML(listaModulos, new FileOutputStream(new File(raiz+"XS.xml")));
        } catch (FileNotFoundException ex) {System.out.println(ex);} 
        catch (IOException ex) {System.out.println(ex);} 
        catch (ClassNotFoundException ex) {System.out.println(ex);} 
    }
    
    public void mostrarXMLModulos(String ruta){
        XStream xs = new XStream(new DomDriver());
        xs.setMode(XStream.NO_REFERENCES);
        xs.alias("alumno", Alumno.class);
        xs.alias("alumnos", ListaAlumnos.class);
        xs.alias("unidad", Unidad.class);
        xs.alias("unidades", ListaUnidades.class);
        xs.alias("modulo", Modulo.class);
        xs.alias("modulos", ListaModulos.class); 
        xs.addImplicitCollection(ListaModulos.class, "modulos");
        xs.addPermission(AnyTypePermission.ANY);
        ListaModulos listaLeida = new ListaModulos();
        try {
            xs.fromXML(new FileInputStream(ruta+"XS.xml"), listaLeida);
            System.out.println("\nLista de modulos: \n" + listaLeida);
        } catch (FileNotFoundException e) {System.out.println(e);}
        catch(StreamException e){System.out.println(e);}
    }
    
    public void datToXMLCiclos(String raiz){
        ListaCiclos listaCiclos = new ListaCiclos();
        try {      
            FileInputStream fis = new FileInputStream(raiz+".dat");
            ObjectInputStream ois = new ObjectInputStream(fis);                                 
            while(fis.available() > 0)
                listaCiclos.getCiclos().add((Ciclo)(ois.readObject()));
            XStream xs = new XStream();
            xs.setMode(XStream.NO_REFERENCES);
            xs.alias("alumno", Alumno.class);
            xs.alias("alumnos", ListaAlumnos.class);
            xs.alias("unidad", Unidad.class);
            xs.alias("unidades", ListaUnidades.class);
            xs.alias("modulo", Modulo.class);
            xs.alias("modulos", ListaModulos.class);  
            xs.alias("ciclo", Ciclo.class);
            xs.alias("ciclos", ListaCiclos.class);  
            xs.toXML(listaCiclos, new FileOutputStream(new File(raiz+"XS.xml")));
        } catch (FileNotFoundException ex) {System.out.println(ex);} 
        catch (IOException ex) {System.out.println(ex);} 
        catch (ClassNotFoundException ex) {System.out.println(ex);} 
    }
    
    public void mostrarXMLCiclos(String ruta){
        XStream xs = new XStream(new DomDriver());
        xs.setMode(XStream.NO_REFERENCES);
        xs.alias("alumno", Alumno.class);
        xs.alias("alumnos", ListaAlumnos.class);
        xs.alias("unidad", Unidad.class);
        xs.alias("unidades", ListaUnidades.class);
        xs.alias("modulo", Modulo.class);
        xs.alias("modulos", ListaModulos.class); 
        xs.alias("ciclo", Ciclo.class);
        xs.alias("ciclos", ListaCiclos.class);
        xs.addImplicitCollection(ListaCiclos.class, "ciclos");
        xs.addPermission(AnyTypePermission.ANY);
        ListaCiclos listaLeida = new ListaCiclos();
        try {
            xs.fromXML(new FileInputStream(ruta+"XS.xml"), listaLeida);
            System.out.println("\nLista de ciclos: \n" + listaLeida);
        } catch (FileNotFoundException e) {System.out.println(e);}
        catch(StreamException e){System.out.println(e);}
    }

}
