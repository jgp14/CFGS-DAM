package xestionclientes;

import java.util.ArrayList;
import java.util.List;
import pedidos.Cliente;
import serializaproducto.LeerMejor;

/**
 *
 * @author dam205
 */
public class XestionClientesMain {
    
    public static final void menuXestionClientes() {
	System.out.println();
        System.out.println("     XESTION CLIENTES");
	System.out.println(" 1.- Escribir clientes json");
	System.out.println(" 2.- Leer y mostrar clientes json");
        System.out.println(" 3.- Escribir contactos json");
	System.out.println(" 4.- Leer y mostrar contactos json");
        System.out.println(" 5.- Escribir contactos en xml");
	System.out.println(" 6.- Escribir contactos en dat");
        System.out.println(" 7.- Leer, mostrar contactos dat");
	System.out.println(" 8.- Leer, mostrar contactos xml");
        System.out.println(" 9.- FINAL");
    } 
    
    public static void main(String[] args){
        XestionClientes xc = new XestionClientes();
        int n = 0;
        String rutaClientes = "clientes";  
        List<Cliente> clientes = new ArrayList<>();
        String rutaContactos = "contactos";
        List<Contacto> contactos = new ArrayList<>();
        
        do{ 
            menuXestionClientes();
            System.out.print("\nDame opcion: ");
            n = LeerMejor.datoShort();
            switch(n){
                case 1:
                    System.out.println("\nEscrita lista de clientes en json");
                    clientes = xc.xeraListaClientes();
                    xc.gardaJsonClientes(rutaClientes+".json");    
                    break;
               case 2:
                    System.out.println("\nLeida y mostrada lista de clientes");
                    clientes = xc.leJsonClientes(rutaClientes+".json");
                    for(int i = 0; i < clientes.size(); i++)
                        System.out.println(clientes.get(i));
                    break;
               case 3:
                    System.out.println("\nEscrita lista de contactos en json");
                    contactos = xc.xeraListaContactos();
                    xc.gardaJsonContactos(rutaContactos+".json");    
                    break;
               case 4:
                    System.out.println("\nLeida y mostrada lista de contactos");
                    contactos = xc.leJsonContactos(rutaContactos+".json");
                    xc.mostraJsonContactos(contactos, rutaContactos);
                    break;                       
               case 5:
                    System.out.println("\nEscrita lista de contactos en xml");
                    contactos = xc.xeraListaContactos();
                    xc.gardaXmlJsonContactos(contactos, rutaContactos);    
                    contactos.removeAll(contactos);
                    break;
               case 6:
                    System.out.println("\nEscrita lista de contactos en dat");
                    xc.gardaDatJsonContactos(rutaContactos);
                    break;                       
                case 7:
                    System.out.println("\nLeeida, mostrada lista contactos dat");
                    xc.leMostraDatContactos(rutaContactos);
                    break;   
                case 8:
                    System.out.println("\nLeeida, mostrada lista contactos xml");
                    xc.leMostraXmlContactos(rutaContactos);
                    break;   
                case 9:                    
                    System.out.println("\nFINAL");
                    break;
                default:
                    System.out.println("\nOpcion erronea ");
                    break;                
            }
            clientes.removeAll(clientes);
            contactos.removeAll(contactos);
        } while(n != 9);    
    }
    
}
