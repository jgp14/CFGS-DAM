package jsonsimple;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author marco
 */
public class UtilidadesJsonSimple {
    
    public void write(Persona pers, String ruta) {
        //Creación de OBJETO JSON
        JSONObject obj = new JSONObject();
        //Se le añaden datos en formato clave-valor
        obj.put("nombre", pers.getNombre());
        obj.put("edad", pers.getEdad());
        obj.put("salario", pers.getSalario());
        
        //Para las listas, almacenamos los valores en un JSONArray
        JSONArray jArray = new JSONArray();
        for (String s : pers.getAficiones()) {
            jArray.add(s);
        }
        obj.put("aficiones", jArray);
        
        //Se guarda escribiendo en el fichero en la ruta
        try {
            FileWriter fichero = new FileWriter(ruta);
            fichero.write(obj.toJSONString());
            fichero.close();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
    
    public Persona read(String ruta) {
        Persona persona = new Persona();
        
        JSONParser parser = new JSONParser();
        
        //LER FICHEIRO de la ruta
        try (FileReader fichero = new FileReader(ruta)) {
            //Se parsea el contenido a un objeto JSON
            JSONObject obj = (JSONObject) parser.parse(fichero);
            
            //Se recuperan los valores del objeto JSON y se castean
            persona.setNombre((String)obj.get("nombre"));
            persona.setSalario((Double)obj.get("salario"));
            persona.setEdad((Long)obj.get("edad"));
            
            //Los arrays y listas se recuperan a un JSONArray
            JSONArray jarray = (JSONArray) obj.get("aficiones");
            for (Object o : jarray) {
                persona.getAficiones().add((String)o);
            }
            
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
        } catch (IOException | ParseException ex) {
            System.err.println(ex);
        }
        
        return persona;
    }
}
