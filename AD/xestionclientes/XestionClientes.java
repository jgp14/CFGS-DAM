package xestionclientes;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.StreamException;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import pedidos.Cliente;
import pedidos.UtilidadesJson;

/**
 *
 * @author dam205
 */
public class XestionClientes {
    
    private UtilidadesJson utilJson = new UtilidadesJson();
    
    public List<Cliente> xeraListaClientes(){
        List<Cliente> clientes = new ArrayList<>();      
        clientes.add(new Cliente
        ("11122233B", "Marco", "Magan Sanz"));
        clientes.add(new Cliente
        ("22233344C", "Beatriz", "Martinez Garcia"));
        clientes.add(new Cliente
        ("33344455D", "Rocio", "Torres Fungueiro"));
        clientes.add(new Cliente
        ("44556677F", "Graciela", "Redondo Arguelles"));
        clientes.add(new Cliente
        ("55667788G", "Rosa Maria", "Busto Regueira"));
        return clientes;
    }
    
    public void gardaJsonClientes(String ruta, List<Cliente> clientes){
        JSONArray jArray = new JSONArray();
        for(Cliente c: clientes)
            jArray.add(creaJsonCliente(c));
        utilJson.writeJSONArray(jArray, ruta);
    }
    
    private JSONObject creaJsonCliente(Cliente c){
        JSONObject objC = new JSONObject();
        objC.put("DNI", c.getDNI());
        objC.put("nome", c.getNome());
        objC.put("apelidos", c.getApelidos());             
        return objC;
    }
    
    private List<Cliente> leJsonClientes(String ruta){
        List<Cliente> clientes = new ArrayList<>();
        JSONArray jArray = utilJson.readJSONArray(ruta);
        for(Object o: jArray){
            JSONObject objC = (JSONObject) o;
            clientes.add(recuperaCliente(objC));
        }
        return clientes;
    }
    
    private Cliente recuperaCliente(JSONObject objC){
        Cliente c = new Cliente();
        c.setDNI((String)objC.get("DNI"));
        c.setNome((String)objC.get("nome"));
        c.setApelidos((String)objC.get("apelidos"));
        return c;
    }
    
    public List<Contacto> xeraListaContactos(String ruta, List<Enderezo> e){
        List<Cliente> clientes = leJsonClientes(ruta);
        List<Contacto> contactos = new ArrayList<>();
        for(int i = 0; i < clientes.size(); i++){
            Cliente c = clientes.get(i);
            Contacto con = new Contacto(c.getDNI(), c.getNome(),
                    c.getApelidos(), e.get(i));
            contactos.add(i,con);
        }
        return contactos;
    }
    
    public List<Enderezo> xeraEnderezos(){
        List<Enderezo> e = new ArrayList<>();
        e.add(0, new Enderezo("Ribeira", "Alcalde", 2));
        e.add(1, new Enderezo("Pobra", "Gasset", 10));
        e.add(2, new Enderezo("Boiro", "Principal", 13));
        e.add(3, new Enderezo("Rianxo", "Vella", 23));
        e.add(4, new Enderezo("PortoSon", "Nova", 7));   
        return e;
    }    
    
    public void gardaJsonContactos(String ruta, List<Contacto> contactos){
        JSONArray arrayContactos = new JSONArray();
        for(Contacto con: contactos)
            arrayContactos.add(creaJsonContacto(con));
        utilJson.writeJSONArray(arrayContactos, ruta);
    }
    
    private JSONObject creaJsonContacto(Contacto c){
        JSONObject objC = new JSONObject();
        objC.put("DNI", c.getDNI());
        objC.put("nome", c.getNome());
        objC.put("apelidos", c.getApelidos());  
        objC.put("enderezo", creaJsonEnderezo(c.getEnderezo()));
        return objC;
    }
    
    private JSONObject creaJsonEnderezo(Enderezo e){ 
        JSONObject objE = new JSONObject();
        objE.put("localidade", e.getLocalidade());
        objE.put("rua", e.getRua());
        objE.put("numero", e.getNumero());
        return objE;
    }
    
    public List<Contacto> leJsonContactos(String ruta){
        List<Contacto> contactos = new ArrayList<>();
        JSONArray arrayContactos = utilJson.readJSONArray(ruta);
        for(Object o: arrayContactos){
            JSONObject objC = (JSONObject) o;
            contactos.add(recuperaContacto(objC));
        }
        return contactos;
    }
    
    private Contacto recuperaContacto(JSONObject objC){
        Contacto c = new Contacto();
        c.setDNI((String) objC.get("DNI"));
        c.setNome((String) objC.get("nome"));
        c.setApelidos((String) objC.get("apelidos"));
        
        JSONObject objE = (JSONObject) objC.get("enderezo");
        c.setEnderezo(recuperaEnderezo(objE));
        return c;
    }
    
    private Enderezo recuperaEnderezo(JSONObject objE){
        Enderezo e = new Enderezo();
        e.setLocalidade((String) objE.get("localidade"));
        e.setRua((String) objE.get("rua"));
        e.setNumero((int)(long)objE.get("numero"));
        return e;
    }
    
    public void mostraJsonContactos(String ruta){
        System.out.println("\nLista de contactos: "+ruta);
        for(Contacto c: leJsonContactos(ruta))
            System.out.println(c);
    }
    
    private void e(Exception ex){ex.printStackTrace();}
    
    public void gardaXmlJsonContactos(String ruta){
        ListaContactos lista = new ListaContactos();
        try{            
            lista.setContactos((List<Contacto>)leJsonContactos(ruta+".json"));
            XStream xs = new XStream();
            xs.setMode(XStream.NO_REFERENCES);
            xs.alias("cliente", Cliente.class);
            xs.alias("enderezo", Enderezo.class);
            xs.alias("contacto", Contacto.class);
            xs.alias("contactos", ListaContactos.class); 
            xs.toXML(lista, new FileOutputStream(new File(ruta+".xml")));
        } catch(FileNotFoundException ex){e(ex);};
    }
    
    public void gardaDatJsonContactos(String ruta){
        List<Contacto> contactos = leJsonContactos(ruta+".json");
        try {
            File fichero = new File(ruta+".dat");
            FileOutputStream fos = new FileOutputStream(fichero);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for(Contacto contacto : contactos)
                oos.writeObject(contacto);
            oos.close(); 
            fos.close();
        } catch (FileNotFoundException ex) {e(ex);} 
        catch (IOException ex) {e(ex);}
    }
    
    public void leMostraDatContactos(String ruta){
        List<Contacto> contactos = new ArrayList<>();          
        try{
            FileInputStream fis = new FileInputStream(ruta+".dat");
            ObjectInputStream ois = new ObjectInputStream(fis); 
            while(fis.available() > 0)
                contactos.add((Contacto) ois.readObject());
            ois.close();
            fis.close(); 
        } catch (FileNotFoundException ex) {e(ex);} 
        catch (IOException | ClassNotFoundException ex) {e(ex);}
        
        System.out.println("\nLista de contactos: "+ruta+".dat");
        for(Contacto c : contactos)
            System.out.println(c.toString());
    }
        
    public void leMostraXmlContactos(String ruta){
        XStream xs = new XStream(new DomDriver());
        xs.setMode(XStream.NO_REFERENCES);
        xs.alias("cliente", Cliente.class);
        xs.alias("enderezo", Enderezo.class);
        xs.alias("contacto", Contacto.class);
        xs.alias("contactos", ListaContactos.class); 
        xs.addPermission(AnyTypePermission.ANY);
        ListaContactos lista = new ListaContactos();
        try {
            xs.fromXML(new FileInputStream(ruta), lista);
            System.out.println("\nLista de contactos: "+ruta);
            for(Contacto c: lista.getContactos())
            System.out.println(c);
        } catch (FileNotFoundException | StreamException ex) {e(ex);}
    }
    
}
