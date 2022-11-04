package cliente;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author marco
 */
public class UtilidadesJSONCliente {
    
    public List<Cliente> createClientes(){
        List<Cliente> clientes = new ArrayList<>();        
        Cliente cliente0 = new Cliente("11122233B", "Marco", "Magan Sanz");
        cliente0.getEnderezos().add(new Enderezo("Nova", 1, 15910));
        cliente0.getEnderezos().add(new Enderezo("Vella", 2, 15920));
        Cliente cliente1 = new Cliente("22233344C", "Beatriz", "Martinez Garcia");
        cliente1.getEnderezos().add(new Enderezo("Montero Rios", 3, 15930));
        cliente1.getEnderezos().add(new Enderezo("Horreo", 4, 15940));        
        Cliente cliente2 = new Cliente("33344455D", "Rocio", "Torres Fungueiro");
        cliente2.getEnderezos().add(new Enderezo("General", 5, 15950));
        cliente2.getEnderezos().add(new Enderezo("Europa", 6, 15960));        
        clientes.add(cliente0);
        clientes.add(cliente1);
        clientes.add(cliente2);        
        return clientes;
    }
    
    public void writeJSONObject(JSONObject obj, String ruta){
        //Se guarda escribiendo en el fichero en la ruta
        try {
            FileWriter fichero = new FileWriter(ruta);
            fichero.write(obj.toJSONString());
            fichero.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
    public JSONObject writeCliente(Cliente cli) {
        //Creación de OBJETO JSON
        JSONObject obj = new JSONObject();
        JSONObject obj2 = new JSONObject();
        //Se le añaden datos en formato clave-valor
        obj.put("dni", cli.getDni());
        obj.put("nome", cli.getNome());
        obj.put("apelidos", cli.getApelidos());
        
        //Para las listas, almacenamos los valores en un JSONArray
        JSONArray jArray = new JSONArray();
        JSONObject objects = new JSONObject();
        int i = 0;
        for (Enderezo enderezo : cli.getEnderezos()) {                                                     
            JSONObject subobj = new JSONObject();
            subobj.put("rua", enderezo.getRua());
            subobj.put("numero", enderezo.getNumero());
            subobj.put("codigoPostal", enderezo.getCodigoPostal());            
            jArray.add(subobj);             
            objects.put("enderezo", jArray);
            i++;
        }
        obj.put("enderezos", objects);        
        return obj;
    }
    
    public void writeClientes(List<Cliente> clientes, String ruta){
        JSONArray jArray = new JSONArray();
        JSONObject obj = new JSONObject();
        for(Cliente cliente: clientes){   
            //JSONObject subobj = new JSONObject();
            //subobj.put("cliente", writeCliente(cliente));
            jArray.add(writeCliente(cliente));
        }
        obj.put("cliente", jArray);
        
        JSONObject objects = new JSONObject();
        objects.put("clientes", obj);
        writeJSONObject(objects, ruta);
    }
    
    public JSONObject readJSONObject(String ruta){
        JSONObject obj = new JSONObject();
        JSONParser parser = new JSONParser();
        try{
            FileReader fichero = new FileReader(ruta);
            obj = (JSONObject) parser.parse(fichero);
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException | ParseException ex) {
            System.out.println(ex);
        }       
        return obj;
    }    
    
    public String JSONtoString(String ruta){
        String xmlText = readJSONObject(ruta).toJSONString();
        return xmlText;
    }
    
    public List<Cliente> readClientes(String ruta){
        JSONObject obj = readJSONObject(ruta);
        JSONObject objRaiz = (JSONObject) obj.get("clientes");
        JSONArray jArray = new JSONArray();
        jArray = (JSONArray) objRaiz.get("cliente");
        List<Cliente> clientes = (List<Cliente>) jArray;
        return clientes;
    }
            
    public static void menuClientes() {
	System.out.println();
        System.out.println("     CLIENTES");
	System.out.println(" 1.- Escribir clientes json");
	System.out.println(" 2.- Leer y mostrar clientes json");
        System.out.println(" 3.- Escribir xml desde json");
        System.out.println(" 4.- FINAL");
    }   
    
}
