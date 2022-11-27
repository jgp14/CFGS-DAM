package xestionclientes;

import java.util.List;
import pedidos.Cliente;
import cliente.LeerMejor;

/**
 *
 * @author dam205
 */
public class XestionClientesMain {
    //
    public static void main(String[] args){
        XestionClientes xc = new XestionClientes();
        String rCli = "clientes";
        List<Cliente> clientes = xc.xeraListaClientes();
        xc.gardaJsonClientes(rCli+".json", clientes);
        
        String rCon = "contactos";
        List<Enderezo> ends = xc.xeraEnderezos();
        List<Contacto> contactos = xc.xeraListaContactos(rCli+".json",ends);
        xc.gardaJsonContactos(rCon+".json", contactos);
        xc.mostraJsonContactos(rCon+".json");
        xc.gardaXmlJsonContactos(rCon);
        xc.gardaDatJsonContactos(rCon);
        xc.leMostraDatContactos(rCon);
        xc.leMostraXmlContactos(rCon+".xml");
    }//
    
    /*
    public static void main(String[] args){
        XestionClientes xc = new XestionClientes();
        String rCli = "clientes";  
        List<Cliente> clientes;
        String rCon = "contactos";
        List<Contacto> contactos;
        int n = 0;
        do{ 
            menuXestionClientes();
            n = LeerMejor.datoShort();
            switch(n){
                case 1:
                    clientes = xc.xeraListaClientes();
                    xc.gardaJsonClientes(rCli+".json", clientes);   
                    break;
                case 2:
                    List<Enderezo> ends = xc.xeraEnderezos();
                    contactos = xc.xeraListaContactos(rCli+".json",ends);
                    xc.gardaJsonContactos(rCon+".json", contactos);
                    break;
                case 3:
                    xc.mostraJsonContactos(rCon+".json");
                    break;            
                case 4:
                    xc.gardaXmlJsonContactos(rCon);
                    break;
                case 5:
                    xc.gardaDatJsonContactos(rCon);
                    break;                       
                case 6:
                    xc.leMostraDatContactos(rCon);
                    break;   
                case 7:
                    xc.leMostraXmlContactos(rCon+".xml");
                    break;   
                case 8:                    
                    System.out.println("\nFINAL");
                    break;
                default:
                    System.out.println("\nOpcion erronea ");
                    break;                
            }
        } while(n != 8);    
    }
    
    private static final void menuXestionClientes() {
        System.out.println("\n     XESTION CLIENTES");
	System.out.println(" 1.- Escribir clientes.json");
        System.out.println(" 2.- Escribir contactos.json");
	System.out.println(" 3.- Leer y mostrar contactos.json");
        System.out.println(" 4.- Escribir contactos.xml");
	System.out.println(" 5.- Escribir contactos.dat");
        System.out.println(" 6.- Leer, mostrar contactos.dat");
	System.out.println(" 7.- Leer, mostrar contactos.xml");
        System.out.println(" 8.- FINAL");
        System.out.print("\nDame opcion: ");
    }*/
    
}
