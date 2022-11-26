package es.leliadoura.ad.eva1parcial1.ejercicio3;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.StreamException;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import es.leliadoura.ad.eva1parcial1.data.Alumno;
import es.leliadoura.ad.eva1parcial1.data.Modulo;
import es.leliadoura.ad.eva1parcial1.data.Unidad;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 *
 * @author marco
 */
public class UtilXstream {
    
    private void e(Exception ex){ex.printStackTrace();}
    
    //Ejercicios XStream
    public void creaXmlXsMem(String ruta, List<Modulo> listModulos){
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
            xs.toXML(listaLeida, new FileOutputStream(new File(ruta+"XSMem.xml")));
        } catch (FileNotFoundException ex) {e(ex);}
    }
    
    public ListaModulos leeXmlXsMem(String ruta){
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
            xs.fromXML(new FileInputStream(ruta+"XSMem.xml"), listaLeida);
            System.out.println("\nLista de modulos: \n" + listaLeida);
        } catch (FileNotFoundException e) {e(e);}
        catch(StreamException e){e(e);}
        return listaLeida;
    }
    
    public void creaXmlXs(String ruta, List<Modulo> listModulos){
        try {
            File file = new File(ruta+".dat");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for(int i = 0; i<listModulos.size(); i++)
                oos.writeObject(listModulos.get(i));
            oos.close(); 
            fos.close();
        } catch (FileNotFoundException ex) {e(ex);} 
        catch (IOException ex) {e(ex);}
        
        ListaModulos listaModulos = new ListaModulos();
        try {      
            FileInputStream fis = new FileInputStream(ruta+".dat");
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
            xs.toXML(listaModulos, new FileOutputStream(new File(ruta+"XS.xml")));
        } catch (FileNotFoundException ex) {e(ex);} 
        catch (IOException ex) {e(ex);} 
        catch (ClassNotFoundException ex) {e(ex);} 
    }
    
    public ListaModulos leeXmlXS(String ruta){
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
        } catch (FileNotFoundException e) {e(e);}
        catch(StreamException e){e(e);}
        return listaLeida;
    }
    
}
