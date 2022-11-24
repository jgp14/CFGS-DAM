package serializaproducto;

/**
 *
 * @author dam205
 */
public class ProdutosMain {           
    
    /*public static void main(String[] args){
        String ruta = "produtos";
        Utilidades util = new Utilidades();
        util.guardar(ruta, util.crear());
        util.leer(ruta);
        util.mostrar(ruta);//
    }*/
     
    //Programa para elegir entre metodos de Utilidades
    public static void main(String[] args){
        String ruta = "produtos";
        Utilidades util = new Utilidades();
        int n = 0;
        do{
            menuProdutos();
            n = LeerMejor.datoShort();
            switch(n){
                case 1:
                    util.guardar(ruta, util.crear());
                    break;
                case 2:
                    util.mostrar(util.leer(ruta));
                    break;
                case 3:
                    System.out.println("\nFINAL");
                    break;
                default:
                    System.out.println("\nOpcion erronea ");
                    break;
            }
        } while (n != 3);
    }
    
    private static final void menuProdutos() {
        String items = "produtos";
        System.out.println("\n     "+items.toUpperCase());
	System.out.println(" 1.- Crear y Guardar "+items);
	System.out.println(" 2.- Leer y Mostrar "+items);
        System.out.println(" 3.- FINAL");
        System.out.print("\nDame opcion: ");
    }//
     
}
