package cliente;

import java.util.ArrayList;
import java.util.List;
import serializaproducto.LeerMejor;
import xstream.UtilidadesXStream;

/**
 *
 * @author marco
 */
public class ClienteJSON {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {                
        int n = 0;
        String ruta = "clientes";        
        UtilidadesJSONCliente json = new UtilidadesJSONCliente();        
        UtilidadesXStream uxs = new UtilidadesXStream();
        List<Cliente> clientes = new ArrayList<>();
        do{ 
            json.menuClientes();
            System.out.print("\nDame opcion: ");
            n = LeerMejor.datoShort();
            switch(n){
                case 1:
                    System.out.println("\nEscrita lista de clientes en json");
                    clientes = json.createClientes();
                    json.writeClientes(clientes, ruta+".json");    
                    clientes.removeAll(clientes);
                    break;
                case 2:
                    System.out.println("\nLeida lista de clientes desde json");
                    clientes = json.readClientes(ruta+".json");
                    System.out.println(clientes);  
                    System.out.println(json.JSONtoString(ruta+".json"));
                    break;                    
                case 3:                    
                    System.out.println("\nEscrito xml desde json con XStream");
                    clientes = json.readClientes(ruta+".json");
                    //uxs.datToXML(ruta, ruta+".json", ruta+".xml", "cliente", 
                      //      "enderezo", Cliente.class, 
                        //    Enderezo.class, clientes);
                    uxs.memDatToXML(ruta, "cliente", 
                            "enderezo", Cliente.class, 
                            Enderezo.class, clientes);
                    break;
                case 4:                    
                    System.out.println("\nFINAL");
                    break;
                default:
                    System.out.println("\nOpcion erronea ");
                    break;                
            }
        } while(n !=4);        
    }

}
