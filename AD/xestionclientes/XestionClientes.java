package xestionclientes;

import utilidades.UtilidadesXML;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.w3c.dom.Document;
import pedidos.Cliente;
import pedidos.UtilidadesJson;
import utilidades.UtilidadesXStream;

/**
 *
 * @author dam205
 */
public class XestionClientes {
    
    public List<Cliente> xeraListaClientes(){
        List<Cliente> clientes = new ArrayList<>();      
        clientes.add(new Cliente("11122233B", "Marco", "Magan Sanz"));
        clientes.add(new Cliente("22233344C", "Beatriz", "Martinez Garcia"));
        clientes.add(new Cliente("33344455D", "Rocio", "Torres Fungueiro"));
        clientes.add(new Cliente("44556677F", "Graciela", "Redondo Arguelles"));
        clientes.add(new Cliente("55667788G", "Rosa Maria", "Busto Regueira"));
        return clientes;
    }
    
    public void gardaJsonClientes(String ruta){
        List<Cliente> clientes = xeraListaClientes();
        JSONObject obj = new JSONObject();
        JSONArray jArray = new JSONArray();
        for(Cliente cliente: clientes)
            jArray.add(writeCliente(cliente));
        obj.put("clientes", jArray);
        (new UtilidadesJson()).writeJSONObject(obj, ruta);
    }
    
    private JSONObject writeCliente(Cliente cli){
        JSONObject obj = new JSONObject();
        JSONObject cliObj = new JSONObject();
        cliObj.put("dni", cli.getDNI());
        cliObj.put("nome", cli.getNome());
        cliObj.put("apelidos", cli.getApelidos());             
        obj.put("cliente", cliObj);   
        return obj;
    }
    
    public List<Cliente> leJsonClientes(String ruta){
        List<Cliente> pedidos = new ArrayList<>();
        JSONObject obj = (new UtilidadesJson()).readJSONObject(ruta);
        JSONArray jArray = new JSONArray();
        jArray = (JSONArray) obj.get("clientes");
        pedidos = (List<Cliente>) jArray;
        return pedidos;
    }
    
    public List<Contacto> xeraListaContactos(){
        List<Contacto> contactos = new ArrayList<>();
        List<Cliente> c = xeraListaClientes();
        List<Enderezo> e = xeraEnderezos();
        for(int i = 0; i < c.size(); i++)
            contactos.add(i, new Contacto
            (c.get(i).getDNI(),c.get(i).getNome(), 
                    c.get(i).getApelidos(), e.get(i)));
        return contactos;
    }
    
    private List<Enderezo> xeraEnderezos(){
        List<Enderezo> e = new ArrayList<>();
        e.add(0, new Enderezo("Ribeira", "Alcalde", 2));
        e.add(1, new Enderezo("Pobra", "Gasset", 10));
        e.add(2, new Enderezo("Boiro", "Principal", 13));
        e.add(3, new Enderezo("Rianxo", "Vella", 23));
        e.add(4, new Enderezo("PortoSon", "Nova", 7));   
        return e;
    }    
    
    public void gardaJsonContactos(String ruta){
        List<Contacto> contactos = xeraListaContactos();
        JSONObject obj = new JSONObject();
        JSONArray jArray = new JSONArray();
        for(Contacto contacto: contactos)
            jArray.add(writeContacto(contacto));
        obj.put("contactos", jArray);
        (new UtilidadesJson()).writeJSONObject(obj, ruta);
    }
    
    private JSONObject writeContacto(Contacto con){
        JSONObject obj = new JSONObject();
        JSONObject cliObj = new JSONObject();
        cliObj.put("dni", con.getDNI());
        cliObj.put("nome", con.getNome());
        cliObj.put("apelidos", con.getApelidos());  
        cliObj.put("enderezo", writeEnderezos(con));
        obj.put("contacto", cliObj);   
        return obj;
    }
    
    private JSONObject writeEnderezos(Contacto con){ 
        JSONObject subobj = new JSONObject();
        subobj.put("localidade", con.getEnderezo().getLocalidade());
        subobj.put("rua", con.getEnderezo().getRua());
        subobj.put("numero", con.getEnderezo().getNumero());
        return subobj;
    }
    
    public List<Contacto> leJsonContactos(String ruta){
        JSONObject obj = (new UtilidadesJson()).readJSONObject(ruta);
        JSONArray jArray = (JSONArray) obj.get("contactos");
        List<Contacto> contactos = (List<Contacto>) jArray;
        return contactos;
    }
    
    public void mostraJsonContactos(List<Contacto> contactos, String ruta){
        for(int i = 0; i < contactos.size(); i++)
            System.out.println(contactos.get(i));
        System.out.println();
        System.out.println((new UtilidadesJson()).
                readJSONObject(ruta+".json").toJSONString());
    }
    
    public void gardaXmlJsonContactos(List list, String ruta){
        UtilidadesXStream uxs = new UtilidadesXStream();
        uxs.listToXML(ruta, "contacto", "cliente", 
                Contacto.class, Cliente.class, list);
    }
    
    public void gardaDatJsonContactos(String ruta){
        List<Contacto> contactos = xeraListaContactos();
        try {
            File fichero = new File(ruta+".dat");
            FileOutputStream fos = new FileOutputStream(fichero);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for(Contacto contacto : contactos)
                oos.writeObject(contacto);
            oos.close(); 
            fos.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println("Error: El fichero no existe. ");
        } catch (IOException ioe) {
            System.out.println("Error: Fallo en escritura del fichero. ");
        }
    }
    
    public void leMostraDatContactos(String ruta){
        gardaDatJsonContactos(ruta); 
        List<Contacto> contactos = leDatContactos(ruta);
        for(Contacto contacto : contactos)
            System.out.println(contacto.toString());
    }
    
    private List<Contacto> leDatContactos(String ruta){
        List<Contacto> contactos = new ArrayList<>();          
        try{
            File fichero = new File(ruta+".dat");
            FileInputStream fis = new FileInputStream(fichero);
            ObjectInputStream ois = new ObjectInputStream(fis); 
            while(fis.available() > 0)
                contactos.add((Contacto) ois.readObject());
            ois.close();
            fis.close(); 
        } catch (FileNotFoundException fnfe) {
            System.out.println("Error: El fichero no existe. ");
        } catch (IOException ioe) {
            System.out.println("Error: Fallo en la lectura del fichero. ");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: Clase no encontrada. ");
        }
        return contactos;
    }
        
    public void leMostraXmlContactos(String ruta){
        UtilidadesXStream uxs = new UtilidadesXStream();
        UtilidadesXML uxml = new UtilidadesXML();
        Document doc = null;    
        doc = uxml.XMLaDOM(ruta+".xml");        
        uxml.mostraContidoElemento(doc.getDocumentElement());
    }
    
}
