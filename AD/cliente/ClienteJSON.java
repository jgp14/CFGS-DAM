package cliente;

import java.util.List;
import utilidades.LeerMejor;
import utilidades.UtilidadesXStream;

/**
 *
 * @author dam205
 */
public class ClienteJSON {

    public static void main(String[] args) {                
        int n = 0;
        String ruta = "clientes";        
        UtilidadesJSONCliente json = new UtilidadesJSONCliente();        
        UtilidadesXStream uxs = new UtilidadesXStream();
        List<Cliente> clientes = json.createClientes();
        do{ 
            json.menuClientes();
            System.out.print("\nDame opcion: ");
            n = LeerMejor.datoShort();
            switch(n){
                case 1:
                    System.out.println("\nEscrita lista de clientes en json");
                    json.writeClientes(clientes, ruta+".json");
                    break;
                case 2:
                    System.out.println("\nEscrita lista de clientes en xml");
                    uxs.listToXML(ruta, "cliente", "enderezo", Cliente.class, 
                            Enderezo.class, clientes);
                    break;
                case 3:
                    System.out.println("\nLeida lista de clientes desde json");
                    json.mostraClientes(ruta);
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
