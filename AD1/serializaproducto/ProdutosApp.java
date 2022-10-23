package serializaproducto;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author dam205
 */
public class ProdutosApp {
       
    //Menu desplegable con opciones de produtos
    public static void menuProdutos() {
	System.out.println();
        System.out.println("     PRODUTOS");
	System.out.println(" 1.- Crear produtos");
	System.out.println(" 2.- Guardar produtos");
	System.out.println(" 3.- Cargar produtos");
        System.out.println(" 4.- Mostrar produtos");
        System.out.println(" 5.- FINAL");
    }
    
    //Para recibir solo numeros entero valido como opciones
    public static int numeroValido(){
        int i;
        Scanner s;
        do{
            i = 0;
            s = new Scanner(System.in);
            try{
                i = s.nextInt();
            } catch(NumberFormatException | InputMismatchException ex) {
                i = Integer.MIN_VALUE;
                System.out.println("Pon entero valido");
            } 
        } while(i == Integer.MIN_VALUE);        
        return i;
    }
    
    
    public static void main(String[] args){
        //Programa para elegir entre metodos de la clase Utilidades
        int n = 0;
        Utilidades utilidades = new Utilidades();
        do{
            menuProdutos();
            System.out.print("\nDame opcion: ");
            n = numeroValido();            
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
