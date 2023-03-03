package es.leliadoura.ad.eva1rec.ejercicio3;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;
import es.leliadoura.ad.eva1rec.data.Alumno;
import es.leliadoura.ad.eva1rec.data.Ciclo;
import es.leliadoura.ad.eva1rec.data.Direccion;
import es.leliadoura.ad.eva1rec.data.Modulo;
import es.leliadoura.ad.eva1rec.data.Unidad;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marco
 */
public class UtilXstream {
    
   public List<Modulo> leer(String ruta){
        List<Modulo> modulos = new ArrayList<>();
        try {
            XStream xs = new XStream();
            xs.setMode(XStream.NO_REFERENCES);
            xs.alias("raiz", ListaModulos.class);
            xs.alias("modulo", Modulo.class);
            xs.alias("alumno", Alumno.class);
            xs.alias("unidad", Unidad.class);
            xs.addPermission(AnyTypePermission.ANY);
            ListaModulos listaModulos = new ListaModulos();           
            xs.fromXML(new FileInputStream(ruta), listaModulos);
            modulos = listaModulos.getModulos();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UtilXstream.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modulos;
   }
   
   public void escribir(Ciclo ciclo, String ruta){
       try {
           XStream xs = new XStream();
           xs.setMode(XStream.NO_REFERENCES);
           xs.alias("raiz", ListaModulos.class);
           xs.alias("ciclo", Ciclo.class);
           xs.alias("direccion", Direccion.class);
           xs.alias("modulo", Modulo.class);
           xs.alias("alumno", Alumno.class);
           xs.alias("unidad", Unidad.class);
           xs.toXML(ciclo, new FileOutputStream(new File(ruta)));
       } catch (FileNotFoundException ex) {
           Logger.getLogger(UtilXstream.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
}
