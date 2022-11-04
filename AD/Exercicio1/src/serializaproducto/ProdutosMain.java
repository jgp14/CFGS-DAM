package serializaproducto;

/**
 *
 * @author dam205
 */
public class ProdutosMain {           
    
    public static void main(String[] args){
        //Programa para elegir entre metodos de la clase Utilidades
        int n = 0;
        Utilidades utilidades = new Utilidades();
        utilidades.setSimple(false); //Simple activar o no  
        do{
            utilidades.menuProdutos();
            System.out.print("\nDame opcion: ");
            n = LeerMejor.datoShort();
            switch(n){
                case 1:
                    System.out.println("\nCreada lista de produtos");
                    utilidades.crearProdutos();
                    break;
                case 2:
                    System.out.println("\nGuardada lista de produtos");
                    utilidades.guardarProdutos();
                    break;
                case 3:
                    System.out.println("\nCargada lista de produtos");
                    utilidades.leerProdutos();
                    break;
                case 4:
                    System.out.println("\nMostrar produtos en memoria: ");
                    utilidades.mostrarProdutos();
                    break;
                case 5:
                    System.out.println("\nFINAL");
                    break;
                default:
                    System.out.println("\nOpcion erronea ");
                    n = 0;
                    break;
            }
        } while (n != 5);
    }
}
