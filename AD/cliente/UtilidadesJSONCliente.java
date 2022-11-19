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
 * @author dam205
 */
public class UtilidadesJSONCliente {
    
    public List<Cliente> createClientes(){
        List<Cliente> clientes = new ArrayList<>();
        clientes = datosClientes(clientes);
        clientes = datosEnderezos(clientes);
        return clientes;
    }
    
    private List<Cliente> datosClientes(List<Cliente> clientes){
        clientes.add(new Cliente
        ("11122233B", "Marco", "Magan Sanz"));
        clientes.add(new Cliente
        ("22233344C", "Beatriz", "Martinez Garcia"));
        clientes.add(new Cliente
        ("33344455D", "Rocio", "Torres Fungueiro")); 
        return clientes;
    }
    
    private List<Cliente> datosEnderezos(List<Cliente> clientes){
        clientes.get(0).getEnderezos().add
        (new Enderezo("Nova", 1, 15910));
        clientes.get(0).getEnderezos().add
        (new Enderezo("Vella", 2, 15920));
        clientes.get(1).getEnderezos().add
        (new Enderezo("Montero Rios", 3, 15930));
        clientes.get(1).getEnderezos().add
        (new Enderezo("Horreo", 4, 15940));       
        clientes.get(2).getEnderezos().add
        (new Enderezo("General", 5, 15950));
        clientes.get(2).getEnderezos().add
        (new Enderezo("Europa", 6, 15960));    
        return clientes;
    }
    
    public void writeJSONObject(JSONObject obj, String ruta){
        try {
            FileWriter fichero = new FileWriter(ruta);
            fichero.write(obj.toJSONString());
            fichero.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
    public void writeJSONArray (JSONArray jArray, String ruta){
        try {
            FileWriter fichero = new FileWriter(ruta);
            fichero.write(jArray.toJSONString());
            fichero.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
    private JSONArray writeEnderezos(Cliente cli){
        //Para las listas, almacenamos los valores en un JSONArray
        JSONArray jArray = new JSONArray();
        for (Enderezo enderezo : cli.getEnderezos()) {                                                     
            JSONObject subobj = new JSONObject();
            subobj.put("rua", enderezo.getRua());
            subobj.put("numero", enderezo.getNumero());
            subobj.put("codigoPostal", enderezo.getCodigoPostal());            
            jArray.add(subobj);             
        }
        return jArray;
    }
    
    private JSONObject writeCliente(Cliente cli) {
        //Creación de OBJETO JSON
        JSONObject obj = new JSONObject();
        //Se le añaden datos en formato clave-valor
        obj.put("dni", cli.getDni());
        obj.put("nome", cli.getNome());
        obj.put("apelidos", cli.getApelidos());        
        JSONArray jArray = writeEnderezos(cli);
        obj.put("enderezos", jArray);        
        return obj;
    }
    
    public void writeClientes(List<Cliente> clientes, String ruta){
        JSONArray jArray = new JSONArray();
        for(Cliente cliente: clientes)
            jArray.add(writeCliente(cliente));        
        writeJSONArray(jArray, ruta);
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
    
    public JSONArray readJSONArray(String ruta){
        JSONArray jArray = new JSONArray();
        JSONParser parser = new JSONParser();
        try{
            FileReader fichero = new FileReader(ruta);
            jArray = (JSONArray) parser.parse(fichero);
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException | ParseException ex) {
            System.out.println(ex);
        }       
        return jArray;
    }    
    
    public List<Cliente> readClientes(String ruta){
        JSONArray jArray = readJSONArray(ruta);
        List<Cliente> clientes = (List<Cliente>) jArray;
        return clientes;
    }
    
    public void mostraClientes(String ruta){
        List<Cliente> clientes = readClientes(ruta+".json");
        for(int i = 0; i<clientes.size(); i++)
            System.out.println(clientes.get(i));  
    }
            
    public static final void menuClientes() {
	System.out.println();
        System.out.println("     CLIENTES");
	System.out.println(" 1.- Escribir clientes json");
        System.out.println(" 2.- Escribir clientes xml");
	System.out.println(" 3.- Leer y mostrar clientes json");
        System.out.println(" 4.- FINAL");
    }   
    
}
