package es.leliadoura.ad.eva1parcial1.ejercicio5;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import es.leliadoura.ad.eva1parcial1.data.Ciclo;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;

/**
 *
 * @author dam205
 */
public class UtilGson {
    
    public void creaGsonCiclos(List<Ciclo> ciclos, String ruta){
        Gson gson = new Gson();
        String json = gson.toJson(ciclos);
        try{
            FileWriter fw = new FileWriter(ruta);
            fw.write(json);
            fw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public List<Ciclo> leeGsonCiclos(String ruta){
        List<Ciclo> ciclos = new ArrayList<>();
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Ciclo>>(){}.getType();
        try{
            FileReader fr = new FileReader(ruta);
            ciclos = gson.fromJson(fr, listType);
            fr.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        return ciclos;
    }
    
    
}
