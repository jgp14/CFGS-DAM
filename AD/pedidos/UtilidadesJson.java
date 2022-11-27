package pedidos;

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
public class UtilidadesJson {
    
    public UtilidadesJson(){}
    
    public List<Pedido> xeraPedidos(){
        List<Pedido> pedidos = new ArrayList<>();
        pedidos.add(pedido1());
        pedidos.add(pedido2());
        pedidos.add(pedido3());
        pedidos.add(pedido4());
        return pedidos;
    }
    
    private Pedido pedido1(){
        List<LineaPedido> linea1 = new ArrayList<>();
        linea1.add(new LineaPedido(new Produto(1, "USB", 
                "Pendrive 64GB", "foto1.png", 7.50f), 4));
        linea1.add(new LineaPedido(new Produto(2, "DVD", 
                "Unidad Optica", "foto2.png", 9.50f), 2));
        return new Pedido(1,new Cliente("12345678A", "Jose", 
                "Garcia"), linea1, false);
    }
    
    private Pedido pedido2(){
        List<LineaPedido> linea2 = new ArrayList<>();
        linea2.add(new LineaPedido(new Produto(3, "Auricular", 
                "Grandes", "foto3.png", 2.50f), 2));
        linea2.add(new LineaPedido(new Produto(4, "Raton", 
                "Gaming", "foto4.png", 10.50f), 1));
        return new Pedido(2,new Cliente("23456789B", "Pedro",
                "Gomez"), linea2, true);  
    }
    
    private Pedido pedido3(){
        List<LineaPedido> linea3 = new ArrayList<>();
        linea3.add(new LineaPedido(new Produto(5, "Teclado", 
                "Numerico", "foto5.png", 12.0f), 1));
        linea3.add(new LineaPedido(new Produto(6, "Cables", 
                "Informatica", "foto6.png", 2.0f), 5));
        return new Pedido(3,new Cliente("34567891C", "Maria", 
                "Perez"), linea3, true);  
    }
    
    private Pedido pedido4(){
        List<LineaPedido> linea4 = new ArrayList<>();
        linea4.add(new LineaPedido(new Produto(7, "USB", 
                "Pendrive 128GB", "foto7.png", 16.0f), 2));
        linea4.add(new LineaPedido(new Produto(8, "Disco Duro", 
                "SSD 1TB", "foto8.png", 90.0f), 1));
        return new Pedido(4,new Cliente("34567891C", "Cesar", 
                "Carballo Cardona"), linea4, false);  
    }
    
    public void creaJsonPedidos(String ruta, List<Pedido> pedidos){
        JSONArray arrayPedidos = new JSONArray();
        for(Pedido p: pedidos)
            arrayPedidos.add(creaJsonPedido(p));
        writeJSONArray(arrayPedidos, ruta);
    }
    
    private JSONObject creaJsonPedido(Pedido p){
        JSONObject objP = new JSONObject();
        objP.put("id", p.getId());    
        
        objP.put("cliente", creaJsonCliente(p.getCliente()));  
        
        JSONArray arrayLineasPedido = new JSONArray();
        for (LineaPedido lp: p.getLineasPedido()) 
            arrayLineasPedido.add(creaJsonLineaPedido(lp));
        
        objP.put("lineasPedido", arrayLineasPedido);
        objP.put("importe", p.getImporte());
        objP.put("entregado", p.isEntregado());
        return objP;
    }
    
    private JSONObject creaJsonCliente(Cliente c){
        JSONObject objC = new JSONObject();
        objC.put("DNI", c.getDNI());
        objC.put("nome", c.getNome());
        objC.put("apelidos", c.getApelidos());
        return objC;
    }
    
    private JSONObject creaJsonLineaPedido(LineaPedido lp){
        JSONObject objLP = new JSONObject();
        objLP.put("produto", creaJsonProduto(lp.getProduto()));
        objLP.put("cantidade", lp.getCantidade());
        objLP.put("prezoTotal", lp.getPrezoTotal());
        return objLP;
    }
    
    private JSONObject creaJsonProduto(Produto pro){
        JSONObject objP = new JSONObject();
        objP.put("id", pro.getId());
        objP.put("nomeProduto", pro.getNomeProduto());
        objP.put("descricion", pro.getDescricion());
        objP.put("foto", pro.getFoto());
        objP.put("prezo", pro.getPrezo());
        return objP;
    }
    
    public void writeJSONArray(JSONArray jArray, String ruta){
        try {
            FileWriter fichero = new FileWriter(ruta);
            fichero.write(jArray.toJSONString());
            fichero.close();
        } catch (IOException ex) {e(ex);}
    }
    
    private void e(Exception ex){ex.printStackTrace();}
    
    public List<Pedido> leJsonPedidos(String ruta){
        List<Pedido> pedidos = new ArrayList<>();
        JSONArray arrayPedidos = readJSONArray(ruta);
        for(Object o: arrayPedidos){
            JSONObject objP = (JSONObject) o;
            pedidos.add(recuperaPedido(objP));
        }
        return pedidos;
    }
    
    private Pedido recuperaPedido(JSONObject objP){
        Pedido p = new Pedido();
        p.setId((int)(long)objP.get("id"));
        
        JSONObject objC = (JSONObject) objP.get("cliente");
        p.setCliente(recuperaCliente(objC));
        
        List<LineaPedido> lineasPedido = new ArrayList<>();
        JSONArray arrayLineasPedido = (JSONArray) objP.get("lineasPedido");
        for(Object o: arrayLineasPedido){
            JSONObject objLP = (JSONObject) o;
            lineasPedido.add((recuperaLineaPedido(objLP))); 
        }
        p.setLineasPedido(lineasPedido);
        
        p.setImporte((float)(double)objP.get("importe"));
        p.setEntregado((boolean)objP.get("entregado"));
        return p;
    }
    
    private Cliente recuperaCliente(JSONObject objC){
        Cliente c = new Cliente();
        c.setDNI((String)objC.get("DNI"));
        c.setNome((String)objC.get("nome"));
        c.setApelidos((String)objC.get("apelidos"));
        return c;
    }
    
    private LineaPedido recuperaLineaPedido(JSONObject objLP){
        LineaPedido lp = new LineaPedido();
        
        JSONObject objP = (JSONObject) objLP.get("produto");
        lp.setProduto(recuperaProduto(objP));
        
        lp.setCantidade((int)(long)objLP.get("cantidade"));
        lp.setPrezoTotal((float)(double)objLP.get("prezoTotal"));
        return lp;
    }
    
    private Produto recuperaProduto(JSONObject objP){
        Produto p = new Produto();
        p.setId((int)(long)objP.get("id"));
        p.setNomeProduto((String) objP.get("nomeProduto"));
        p.setDescricion((String) objP.get("descripcion"));
        p.setFoto((String) objP.get("foto"));
        p.setPrezo((float)(double) objP.get("prezo"));
        return p;
    }
    
    public JSONArray readJSONArray(String ruta){
        JSONArray jArray = new JSONArray();
        JSONParser parser = new JSONParser();
        try{
            FileReader fichero = new FileReader(ruta);
            jArray = (JSONArray) parser.parse(fichero);
        } catch (FileNotFoundException ex) {e(ex);} 
        catch (IOException | ParseException ex) {e(ex); }       
        return jArray;
    } 
    
    public void MostraJsonPedidos(List<Pedido> list){
        for(Pedido p: list)            
            System.out.println(p);  
    }
    
    public void crearXMLPedidos(String ruta){
        ListaPedidos lista = new ListaPedidos();
        try{            
            lista.setPedidos((List<Pedido>)leJsonPedidos(ruta+".json"));
            XStream xs = new XStream();
            xs.setMode(XStream.NO_REFERENCES);
            xs.alias("produto", Produto.class);
            xs.alias("produtos", List.class);
            xs.alias("cliente", Cliente.class);
            xs.alias("clientes", List.class);
            xs.alias("lineaPedido", LineaPedido.class);
            xs.alias("lineasPedido", List.class);
            xs.alias("pedido", Pedido.class);
            xs.alias("pedidos", ListaPedidos.class); 
            xs.toXML(lista, new FileOutputStream(new File(ruta+".xml")));
        } catch(FileNotFoundException ex){e(ex);};
    } 
        
    public void mostrarXMLPedidos(String ruta){
        XStream xs = new XStream(new DomDriver());
        xs.setMode(XStream.NO_REFERENCES);
        xs.alias("produto", Produto.class);
        xs.alias("produtos", List.class);
        xs.alias("cliente", Cliente.class);
        xs.alias("clientes", List.class);
        xs.alias("lineaPedido", LineaPedido.class);
        xs.alias("lineasPedido", List.class);
        xs.alias("pedido", Pedido.class);
        xs.alias("pedidos", ListaPedidos.class); 
        xs.addPermission(AnyTypePermission.ANY);
        ListaPedidos lista = new ListaPedidos();
        try {
            xs.fromXML(new FileInputStream(ruta), lista);
            System.out.println("\nLista de pedidos: "+ruta);
            MostraJsonPedidos(lista.getPedidos());
        } catch (FileNotFoundException | StreamException ex) {e(ex);}
    }

}
