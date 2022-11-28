package es.iesleliadoura.xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Alumno unAlumno = new Alumno("Laura", "11111111A");
        Alumno otroAlumno = new Alumno("Pepe", "22222222B");
        
        try {
            List<Alumno> listaAlumnos = new ArrayList<>();
            listaAlumnos.add(unAlumno);
            listaAlumnos.add(otroAlumno);

            //Instanciar objeto de XStream
            XStream xstream = new XStream();
            //Configurar XStream
            //Modo NO_REFERENCES para forzar a que ponga todos los elementos
            //aunque no existan referencias
            xstream.setMode(XStream.NO_REFERENCES);
            //Se indican los alias para renombrar las clases a la etiqueta
            xstream.alias("alumno", Alumno.class);
            xstream.alias("alumnos", List.class);
            //Guardamos el objeto en un fichero XML
            xstream.toXML(listaAlumnos, new FileOutputStream("alumnosListaMal.xml"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            ListaAlumnos listaAlumnos = new ListaAlumnos();
            listaAlumnos.getLista().add(unAlumno);
            listaAlumnos.getLista().add(otroAlumno);

            //Instanciar objeto de XStream
            XStream xstream = new XStream();
            xstream.setMode(XStream.NO_REFERENCES);
            xstream.alias("alumno", Alumno.class);
            xstream.alias("alumnos", ListaAlumnos.class);
            xstream.toXML(listaAlumnos, new FileOutputStream("alumnos.xml"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        XStream xs = new XStream(new DomDriver());
        xs.setMode(XStream.NO_REFERENCES);
        xs.alias("alumno", Alumno.class);
        xs.alias("alumnos", ListaAlumnos.class);
        xs.addPermission(AnyTypePermission.ANY);
        ListaAlumnos listaLeida = new ListaAlumnos();
        try {
            xs.fromXML(new FileInputStream("alumnos.xml"), listaLeida);
            System.out.println("\nLista de alumnos: \n" + listaLeida);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
