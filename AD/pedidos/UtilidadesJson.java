package pedidos;

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
public class UtilidadesJson {
    
    public UtilidadesJson(){}
    
    public List<Pedido> xeraPedidos(){
        List<Pedido> pedidos = new ArrayList<>();
        pedidos.add(pedido1());
        pedidos.add(pedido2());
        pedidos.add(pedido3());
        return pedidos;
    }
    
    private Pedido pedido1(){
        List<LineaPedido> linea1 = new ArrayList<>();
        linea1.add(new LineaPedido(new Produto
        (1, "USB", "Pendrive", "foto1.png", 5), 4));
        linea1.add(new LineaPedido(new Produto
        (2, "DVD", "Unidad Optica", "foto2.png", 6), 2));
        return new Pedido(1,new Cliente
        ("12345678A", "Jose", "Garcia"), linea1, false);
    }
    
    private Pedido pedido2(){
        List<LineaPedido> linea2 = new ArrayList<>();
        linea2.add(new LineaPedido(new Produto
        (3, "Auricular", "Grandes", "foto3.png", 2), 2));
        linea2.add(new LineaPedido(new Produto
        (4, "Raton", "Gaming", "foto4.png", 10), 1));
        return new Pedido(2,new Cliente
        ("23456789B", "Pedro", "Gomez"), linea2, true);  
    }
    
    private Pedido pedido3(){
        List<LineaPedido> linea3 = new ArrayList<>();
        linea3.add(new LineaPedido(new Produto
        (5, "Teclado", "Numerico", "foto5.png", 12), 1));
        linea3.add(new LineaPedido(new Produto
        (6, "Cables", "Informatica", "foto6.png", 2), 5));
        return new Pedido(3,new Cliente
        ("34567891C", "Maria", "Perez"), linea3, true);  
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
    
    public JSONObject writePedido(Pedido ped) {
        //Creación de OBJETO JSON
        JSONObject obj = new JSONObject();
        //Se le añaden datos en formato clave-valor
        obj.put("id", ped.getId());
        JSONObject cliObj = new JSONObject();
        cliObj.put("dni", ped.getCliente().getDNI());
        cliObj.put("nome", ped.getCliente().getNome());
        cliObj.put("apelidos", ped.getCliente().getApelidos());             
        obj.put("cliente", cliObj);                
        obj.put("lineasPedido", writeLineasPedido(ped));              
        obj.put("importe", ped.getImporte());
        obj.put("entregado", ped.isEntregado());              
        return obj;
    }
    
    private JSONArray writeLineasPedido(Pedido ped){
        JSONArray jArray = new JSONArray();
        int i = 0;
        for (LineaPedido linea : ped.getLineasPedido()) {                                                     
            JSONObject subobj = new JSONObject();
            subobj.put("produto", writeProdutos(ped, i));
            subobj.put("cantidade", linea.getCantidade());
            subobj.put("prezoTotal", linea.getPrezoTotal());            
            jArray.add(subobj);             
            i++;
        }
        return jArray;
    }
    
    private JSONObject writeProdutos(Pedido ped, int i){
        JSONObject proObj = new JSONObject();
        proObj.put("idPro", ped.getLineasPedido().get(i).getProduto().getId());
        proObj.put("nomeProduto", 
                ped.getLineasPedido().get(i).getProduto().getNomeProduto());
        proObj.put("descricion", 
                ped.getLineasPedido().get(i).getProduto().getDescricion());
        proObj.put("foto", 
                ped.getLineasPedido().get(i).getProduto().getFoto());
        proObj.put("prezo", 
                ped.getLineasPedido().get(i).getProduto().getPrezo());
        return proObj;
    }
    
    public void creaJsonPedidos(String ruta){
        List<Pedido> pedidos = xeraPedidos();
        JSONArray jArray = new JSONArray();
        JSONObject obj = new JSONObject();
        for(Pedido pedido: pedidos)
            jArray.add(writePedido(pedido));
        obj.put("pedidos", jArray);
        writeJSONObject(obj, ruta);
    }
    
    public List<Pedido> leJsonPedidos(String ruta){
        JSONObject obj = readJSONObject(ruta);
        JSONArray jArray = (JSONArray) obj.get("pedidos");
        List<Pedido> pedidos = (List<Pedido>) jArray;
        return pedidos;
    }
    
    public void MostraJsonPedidos(String ruta){
        List<Pedido> pedidos = leJsonPedidos(ruta);
        for(int i = 0; i < pedidos.size(); i++)            
            System.out.println(pedidos.get(i));  
        System.out.println();
        System.out.println(readJSONObject(ruta).toJSONString());
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
    
    public static final void menuPedidos() {
	System.out.println();
        System.out.println("     PEDIDOS");
	System.out.println(" 1.- Escribir pedidos json");
        System.out.println(" 2.- Escribir peiddos xml");
	System.out.println(" 3.- Leer y mostrar pedidos json");
        System.out.println(" 4.- FINAL");
    } 
}
