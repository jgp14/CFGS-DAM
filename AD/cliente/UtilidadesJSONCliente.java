package cliente;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.StreamException;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import java.io.*;
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
        clientes.add(new Cliente
        ("44455566F", "Rosa Maria", "Busto Regueira"));
        clientes.add(new Cliente
        ("55566677G", "Cesar", "Rodriguez Dorado"));
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
        clientes.get(3).getEnderezos().add
        (new Enderezo("Gasset", 13, 15970));
        clientes.get(3).getEnderezos().add
        (new Enderezo("Venecia", 4, 15980));       
        clientes.get(4).getEnderezos().add
        (new Enderezo("Plaza Mayor", 5, 15990));
        clientes.get(4).getEnderezos().add
        (new Enderezo("Plaza Menor", 6, 15900)); 
        return clientes;
    }
    
    public void guardarClientes(String ruta, List<Cliente> clientes){
        JSONArray arrayClientes = new JSONArray();
        for(Cliente c: clientes)
            arrayClientes.add(creaJsonCliente(c));        
        writeJSONArray(arrayClientes, ruta);
    }
    
    private JSONObject creaJsonCliente(Cliente c){
        JSONObject objC = new JSONObject();
        objC.put("dni", c.getDni());
        objC.put("nome", c.getNome());
        objC.put("apelidos", c.getApelidos());
        
        JSONArray arrayEnderezos = new JSONArray();
        for (Enderezo e : c.getEnderezos()) 
            arrayEnderezos.add(creaJsonEnderezo(e));  
        objC.put("enderezos", arrayEnderezos);
        return objC;
    }
    
    private JSONObject creaJsonEnderezo(Enderezo e){
        JSONObject objE = new JSONObject();
        objE.put("rua", e.getRua());
        objE.put("numero", e.getNumero());
        objE.put("codigoPostal", e.getCodigoPostal());
        return objE;
    }
    
    private void writeJSONArray(JSONArray jArray, String ruta){
        try {
            FileWriter fichero = new FileWriter(ruta);
            fichero.write(jArray.toJSONString());
            fichero.close();
        } catch (IOException ex) {e(ex);}
    }
    
    private void e(Exception ex){ex.printStackTrace();}
    
    public List<Cliente> leerClientes(String ruta){
        List<Cliente> clientes = new ArrayList<>();
        JSONArray arrayClientes = readJSONArray(ruta);
        for(Object o: arrayClientes){
            JSONObject objC = (JSONObject) o;
            clientes.add(recuperaCliente(objC));
        }
        return clientes;
    }
    
    private Cliente recuperaCliente(JSONObject objC){
        Cliente c = new Cliente();
        c.setDni((String) objC.get("dni"));
        c.setNome((String) objC.get("nome"));
        c.setApelidos((String) objC.get("apelidos"));
        
        List<Enderezo> enderezos = new ArrayList<>();
        JSONArray arrayEnderezos = (JSONArray) objC.get("enderezos");
        for(Object o: arrayEnderezos){
            JSONObject objE = (JSONObject) o;
            enderezos.add((recuperaEnderezo(objE))); 
        }
        c.setEnderezos(enderezos);
        return c;
    }
        
    private Enderezo recuperaEnderezo(JSONObject objE) {
        Enderezo e = new Enderezo();
        e.setRua((String) objE.get("rua"));
        e.setNumero((int)(long) objE.get("numero"));
        e.setCodigoPostal((int)(long) objE.get("codigoPostal"));
        return e;
    }
    
    private JSONArray readJSONArray(String ruta){
        JSONArray jArray = new JSONArray();
        JSONParser parser = new JSONParser();
        try{
            FileReader fichero = new FileReader(ruta);
            jArray = (JSONArray) parser.parse(fichero);
        } catch (FileNotFoundException ex) {e(ex);} 
        catch (IOException | ParseException ex) {e(ex); }       
        return jArray;
    } 
    
    public void MostraJsonClientes(List<Cliente> list){
        for(Cliente c: list)
            System.out.println(c);
    }

    public void crearXMLClientes(String ruta){
        ListaClientes lista = new ListaClientes();
        try{            
            lista.setClientes((List<Cliente>)leerClientes(ruta+".json"));
            XStream xs = new XStream();
            xs.setMode(XStream.NO_REFERENCES);
            xs.alias("enderezo", Enderezo.class);
            xs.alias("enderezos", List.class);
            xs.alias("cliente", Cliente.class);
            xs.alias("clientes", ListaClientes.class); 
            xs.toXML(lista, new FileOutputStream(new File(ruta+".xml")));
        } catch(FileNotFoundException ex){e(ex);};
    } 
        
    public void mostrarXMLClientes(String ruta){
        XStream xs = new XStream(new DomDriver());
        xs.setMode(XStream.NO_REFERENCES);
        xs.alias("enderezo", Enderezo.class);
        xs.alias("enderezos", List.class);
        xs.alias("cliente", Cliente.class);
        xs.alias("clientes", ListaClientes.class); 
        xs.addPermission(AnyTypePermission.ANY);
        ListaClientes lista = new ListaClientes();
        try {
            xs.fromXML(new FileInputStream(ruta), lista);
            System.out.println("\nLista de clientes: "+ruta);
            MostraJsonClientes(lista.getClientes());
        } catch (FileNotFoundException | StreamException ex) {e(ex);}
    }
   
}
