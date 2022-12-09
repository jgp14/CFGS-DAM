package es.leliadoura.ad.eva1parcial1.ejercicio4;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import es.leliadoura.ad.eva1parcial1.data.Alumno;
import es.leliadoura.ad.eva1parcial1.data.Ciclo;
import es.leliadoura.ad.eva1parcial1.data.Direccion;
import es.leliadoura.ad.eva1parcial1.data.Modulo;
import es.leliadoura.ad.eva1parcial1.data.Unidad;
import es.leliadoura.ad.eva1parcial1.ejercicio3.ListaCiclos;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author dam205
 */
public class UtilJson {
    
    public void gardaListaCiclos(List<Ciclo> ciclos, String ruta){
        JSONArray jArrayModulos = new JSONArray();
        for(Ciclo ciclo: ciclos){
            jArrayModulos.add(creaJsonCiclo(ciclo));
        }
        writeJSONArray(jArrayModulos, ruta);        
    }
    
    private void writeJSONArray(JSONArray jArray, String ruta){
        try{
            FileWriter fw = new FileWriter(ruta);
            fw.write(jArray.toJSONString());
            fw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    private JSONObject creaJsonCiclo(Ciclo ciclo){
        JSONObject objCiclo = new JSONObject();
        objCiclo.put("nombre", ciclo.getNombre());
        
        objCiclo.put("direccion", creaJsonDireccion
        (ciclo.getDireccion()));
        
        JSONArray jArrayModulos = new JSONArray();
        for(Modulo modulo: ciclo.getModulos())
            jArrayModulos.add(creaJsonModulo(modulo));
        objCiclo.put("modulos", jArrayModulos);
        
        return objCiclo;
    }
    
    private JSONObject creaJsonDireccion(Direccion direccion){
        JSONObject objDireccion = new JSONObject();
        objDireccion.put("calle", direccion.getCalle());
        objDireccion.put("localidad", direccion.getLocalidad());
        objDireccion.put("numero", direccion.getCodigoPostal());
        objDireccion.put("codigoPostal", direccion.getCodigoPostal());
        return objDireccion;
    }
    
    private JSONObject creaJsonModulo(Modulo modulo){
        JSONObject objModulo = new JSONObject();
        objModulo.put("curso", modulo.getCurso());
        objModulo.put("descripcion", modulo.getDescripcion());
        
        JSONArray jArrayAlumnos = new JSONArray();
        for(Alumno alumno: modulo.getAlumnos())
            jArrayAlumnos.add(creaJsonAlumno(alumno));
        objModulo.put("alumnos", jArrayAlumnos);
        
        JSONArray jArrayUnidades = new JSONArray();
        for(Unidad unidad: modulo.getUnidades())
            jArrayUnidades.add(creaJsonUnidad(unidad));
        objModulo.put("unidades", jArrayUnidades);
        
        return objModulo;
    }
    
    private JSONObject creaJsonAlumno(Alumno alumno){
        JSONObject objAlumno = new JSONObject();
        objAlumno.put("nombre", alumno.getNombre());
        objAlumno.put("dni", alumno.getDni());        
        return objAlumno;
    }
    
    private JSONObject creaJsonUnidad(Unidad unidad){
        JSONObject objUnidad = new JSONObject();
        objUnidad.put("titulo", unidad.getTitulo());
        objUnidad.put("descripcion", unidad.getDescripcion());        
        return objUnidad;
    }
    
    public List<Ciclo> leeListaCiclos(String ruta){
        List<Ciclo> ciclos = new ArrayList<>();
        JSONArray jArrayCiclos = readJSONArray(ruta);
        for(Object o: jArrayCiclos){
            JSONObject objCiclo = (JSONObject) o;
            ciclos.add(recuperaCiclo(objCiclo));
        }
        return ciclos;        
    }
    
    private JSONArray readJSONArray(String ruta){
        JSONParser parser = new JSONParser();
        JSONArray jArray = new JSONArray();
        try{
            FileReader fr = new FileReader(ruta);
            jArray = (JSONArray) parser.parse(fr);
            fr.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException | ParseException e){
            e.printStackTrace();
        }
        return jArray;
    }
    
    private Ciclo recuperaCiclo(JSONObject objCiclo){
        Ciclo ciclo = new Ciclo();
        ciclo.setNombre((String) objCiclo.get("nombre"));
        
        JSONObject objDireccion = (JSONObject) objCiclo.get("direccion");
        ciclo.setDireccion(recuperaDireccion(objDireccion));
        
        
        JSONArray jArrayModulos = (JSONArray) objCiclo.get("modulos");
        for(Object o: jArrayModulos){
            JSONObject objModulo = (JSONObject)o;
            ciclo.getModulos().add(recuperaModulo(objModulo));
        }
                
        return ciclo;
    }
    
    private Direccion recuperaDireccion(JSONObject objDireccion){
        Direccion direccion = new Direccion();
        direccion.setCalle((String) objDireccion.get("calle"));
        direccion.setLocalidad((String) objDireccion.get("localidad"));
        direccion.setNumero((long) objDireccion.get("numero"));
        direccion.setCodigoPostal((long)objDireccion.get("codigoPostal"));
        return direccion;
    }
    
    private Modulo recuperaModulo(JSONObject objModulo){
        Modulo modulo = new Modulo();
        modulo.setCurso((long) objModulo.get("curso"));
        modulo.setDescripcion((String) objModulo.get("descripcion"));
        
        JSONArray jArrayAlumnos = (JSONArray) objModulo.get("alumnos");
        for(Object o: jArrayAlumnos){
            JSONObject objAlumno = (JSONObject)o;
            modulo.getAlumnos().add(recuperaAlumno(objAlumno));
        }
        
        JSONArray jArrayUnidades = (JSONArray) objModulo.get("unidades");
        for(Object o: jArrayUnidades){
            JSONObject objUnidad = (JSONObject)o;
            modulo.getUnidades().add(recuperaUnidad(objUnidad));
        }
        
        return modulo;
    }
    
    private Alumno recuperaAlumno(JSONObject objAlumno){
        Alumno alumno = new Alumno();
        alumno.setNombre((String) objAlumno.get("nombre"));
        alumno.setDni((String) objAlumno.get("dni"));
        return alumno;
    }
    
    private Unidad recuperaUnidad(JSONObject objUnidad){
        Unidad unidad = new Unidad();
        unidad.setTitulo((String) objUnidad.get("titulo"));
        unidad.setDescripcion((String) objUnidad.get("descripcion"));
        return unidad;
    }
    
    public void mostrarListaCiclos(List<Ciclo> ciclos){
        System.out.println();
        for(Ciclo ciclo: ciclos)
            System.out.println(ciclo);
        System.out.println();
    }
    
    public void crearXMLCiclos(String ruta){
        ListaCiclos lista = new ListaCiclos();
        lista.setCiclos(leeListaCiclos(ruta+".json"));
        
        XStream xs = new XStream();
        xs = alias(xs);
        try {
            xs.toXML(lista, new FileOutputStream(new File(ruta+"XS.xml")));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    public void mostrarXMLCiclos(String ruta){
        XStream xs = new XStream(new DomDriver());
        xs = alias(xs);
        xs.addPermission(AnyTypePermission.ANY);
        ListaCiclos lista = new ListaCiclos();
        try {
            xs.fromXML(new FileInputStream(ruta), lista);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        System.out.println("\nLista de ciclosXS: ");
        for(Ciclo ciclo: lista.getCiclos())
            System.out.println(ciclo);
        System.out.println();
    }
    
    private XStream alias(XStream xs){
        xs.setMode(XStream.NO_REFERENCES);
        xs.alias("alumno", Alumno.class);
        xs.alias("alumnos", List.class);
        xs.alias("unidad", Unidad.class);
        xs.alias("unidades", List.class);
        xs.alias("modulo", Modulo.class);
        xs.alias("modulos", List.class); 
        xs.alias("direccion",Direccion.class);
        xs.alias("ciclo", Ciclo.class);
        xs.alias("ciclos", ListaCiclos.class);
        return xs;
    }
    
}
