package cliente;

import java.util.List;

/**
 *
 * @author dam205
 */
public class ClienteJSON {
    //
    public static void main(String[] args){
        String ruta = "clientes";        
        UtilidadesJSONCliente json = new UtilidadesJSONCliente();        
        List<Cliente> clientes = json.createClientes();
        json.guardarClientes(ruta+".json", clientes);
        json.crearXMLClientes(ruta);
        json.mostrarXMLClientes(ruta+".xml");
        System.out.println("\nLista de clientes: "+ruta+".json");
        json.MostraJsonClientes(json.leerClientes(ruta+".json"));
    }//
    
    /*
    public static void main(String[] args) {                
        String ruta = "clientes";
        UtilidadesJSONCliente json = new UtilidadesJSONCliente();        
        List<Cliente> clientes = json.createClientes();
        int n = 0;
        do{ 
            menuClientes();
            n = LeerMejor.datoShort();
            switch(n){
                case 1:
                    json.guardarClientes(ruta+".json", clientes);
                    break;
                case 2:
                    json.crearXMLClientes(ruta);
                    json.mostrarXMLClientes(ruta+".xml");
                    break;
                case 3:
                    System.out.println("\nLista de clientes: "+ruta+".json");
                    json.MostraJsonClientes(json.leerClientes(ruta+".json"));
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
    
    private static final void menuClientes() {
        System.out.println("\n     CLIENTES");
	System.out.println(" 1.- Escribir clientes.json");
        System.out.println(" 2.- Escribir clientes.xml y Mostrar");
	System.out.println(" 3.- Leer y Mostrar clientes.json");
        System.out.println(" 4.- FINAL");
        System.out.print("\nDame opcion: ");
    }*/

}
