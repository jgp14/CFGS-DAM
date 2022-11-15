package xestionclientes;

import axenda.UtilidadesXML;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.w3c.dom.Document;
import pedidos.Cliente;
import pedidos.UtilidadesJson;
import xstream.UtilidadesXStream;

/**
 *
 * @author dam205
 */
public class XestionClientes {
    
    public List<Cliente> xeraListaClientes(){
        List<Cliente> clientes = new ArrayList<>();
        Cliente cliente0 = new Cliente("11122233B", "Marco", "Magan Sanz");
        Cliente cliente1 = new Cliente("22233344C", "Beatriz", "Martinez Garcia");
        Cliente cliente2 = new Cliente("33344455D", "Rocio", "Torres Fungueiro");
        Cliente cliente3 = new Cliente("44556677F", "Graciela", "Redondo Arguelles");       
        Cliente cliente4 = new Cliente("55667788G", "Rosa Maria", "Busto Regueira");       
        clientes.add(cliente0);
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);
        clientes.add(cliente4);
        return clientes;
    }
    
    public JSONObject writeCliente(Cliente cli){
        JSONObject obj = new JSONObject();
        JSONObject cliObj = new JSONObject();
        cliObj.put("dni", cli.getDNI());
        cliObj.put("nome", cli.getNome());
        cliObj.put("apelidos", cli.getApelidos());             
        obj.put("cliente", cliObj);   
        return obj;
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
        List<Enderezo> e = new ArrayList<>();
        e.add(0, new Enderezo("Ribeira", "Alcalde", 2));
        e.add(1, new Enderezo("Pobra", "Gasset", 10));
        e.add(2, new Enderezo("Boiro", "Principal", 13));
        e.add(3, new Enderezo("Rianxo", "Vella", 23));
        e.add(4, new Enderezo("PortoSon", "Nova", 7));        
        Contacto contacto;
        for(int i = 0; i < c.size(); i++){
            contacto = new Contacto(c.get(i).getDNI(), 
                    c.get(i).getNome(), c.get(i).getApelidos(), e.get(i));
            contactos.add(i, contacto);
        }
        return contactos;
    }
    
    public JSONObject writeContacto(Contacto con){
        JSONObject obj = new JSONObject();
        JSONObject cliObj = new JSONObject();
        cliObj.put("dni", con.getDNI());
        cliObj.put("nome", con.getNome());
        cliObj.put("apelidos", con.getApelidos());  
        JSONObject subobj = new JSONObject();
        subobj.put("localidade", con.getEnderezo().getLocalidade());
        subobj.put("rua", con.getEnderezo().getRua());
        subobj.put("numero", con.getEnderezo().getNumero());                
        cliObj.put("enderezo", subobj);
        obj.put("contacto", cliObj);   
        return obj;
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
    
    public List<Contacto> leJsonContactos(String ruta){
        List<Contacto> contactos = new ArrayList<>();
        JSONObject obj = (new UtilidadesJson()).readJSONObject(ruta);
        JSONArray jArray = new JSONArray();
        jArray = (JSONArray) obj.get("contactos");
        contactos = (List<Contacto>) jArray;
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
        uxs.memDatToXML
        (ruta, "contacto", "cliente", Contacto.class, Cliente.class, list);
    }
    
    public void gardaDatJsonContactos(String ruta){
        List<Contacto> contactos = new ArrayList<>();
        if(contactos.isEmpty()) //Si esta vacio la lista la genera
            contactos = xeraListaContactos();
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
    
    public List<Contacto> leMostraDatContactos(String ruta){
        List<Contacto> contactos = new ArrayList<>();
        Contacto contacto = null;
        gardaDatJsonContactos(ruta);                
        try{
            File fichero = new File(ruta+".dat");
            FileInputStream fis = new FileInputStream(fichero);
            ObjectInputStream ois = new ObjectInputStream(fis); 
            while(fis.available() > 0){
                contacto = (Contacto) ois.readObject();
                contactos.add(contacto);
            }
            ois.close();
            fis.close(); 
        } catch (FileNotFoundException fnfe) {
            System.out.println("Error: El fichero no existe. ");
        } catch (IOException ioe) {
            System.out.println("Error: Fallo en la lectura del fichero. ");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: Clase no encontrada. ");
        }
        for(Contacto contactoMostra : contactos)
            System.out.println(contactoMostra.toString());
        System.out.println();
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
