package libros;

import serializaproducto.LeerMejor;

/**
 *
 * @author user
 */
public class XestionLibro {
  
    public static void main(String[] args){
        int n = 0;        
        UtilidadesLibro utilidadesLibro = new UtilidadesLibro();        
        do{
            utilidadesLibro.menuLibros();
            System.out.print("\nDame opcion: ");            
            n = LeerMejor.datoShort();
            switch(n){ 
                case 1:
                    System.out.println("\nGenerados libros.dat con datos");
                    utilidadesLibro.xerarDatLibro();
                    break;
                case 2:
                    System.out.println("\nMostrado contenido de libros.dat");
                    utilidadesLibro.mostraLibros(); 
                    break;
                case 3://2 ultimos casos generar produtos y pedidos desde archivos dat                   
                    System.out.println("\nGenerados libros.xml usando DOM");
                    utilidadesLibro.xerarXmlLibroDom();
                    break;                
                case 4:
                    System.out.println("\nGenerados libros.xml usando XStream");
                    utilidadesLibro.xerarXmlLibroXStream();
                    break;
                case 5:
                    System.out.println("\nFINAL");
                    break;
                default:
                    System.out.println("\nOpcion erronea ");
                    break;                
            }            
        }while(n != 5);        
    }
}
