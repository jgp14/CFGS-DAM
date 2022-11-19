package serializaproducto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dam205
 */
public class Utilidades {
    
    //Atributos declarados de Utilidades
    private List<Produto> produtos = new ArrayList<>();
    
    public Utilidades(){}    
    
    //Crear los produtos llamando al metodo xeraProdutos
    public void crearProdutos(){
        produtos.removeAll(produtos);
        produtos = (new DatosProdutos()).xeraProdutos();
    }   
    
    //Guardar produtos en el fichero
    public void guardarProdutos(String ruta) {
        if(produtos.isEmpty()) //Si esta vacio la lista la genera
            crearProdutos();
        try {
            File fichero = new File(ruta+".dat");
            FileOutputStream fos = new FileOutputStream(fichero);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for(Produto producto: produtos)
                oos.writeObject(producto);
            oos.close(); 
            fos.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println("Error: El fichero no existe. ");
        } catch (IOException ioe) {
            System.out.println("Error: Fallo en escritura del fichero. ");
        }
        produtos.removeAll(produtos);
    }
    
    //Leer produtos del fichero
    public List<Produto> leerProdutos(String ruta){
        guardarProdutos(ruta);                
        try{
            File fichero = new File(ruta+".dat");
            FileInputStream fis = new FileInputStream(fichero);
            ObjectInputStream ois = new ObjectInputStream(fis); 
            while(fis.available() > 0)
                produtos.add((Produto) ois.readObject());
            ois.close();
            fis.close(); 
        } catch (FileNotFoundException fnfe) {
            System.out.println("Error: El fichero no existe. ");
        } catch (IOException ioe) {
            System.out.println("Error: Fallo en la lectura del fichero. ");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: Clase no encontrada. ");
        }
        return produtos;
    }
    
    //Mostrar la lista de produtos por pantalla
    public void mostrarProdutos(String ruta){
        for(Produto produto: leerProdutos(ruta))
            System.out.println(produto.toString());
        System.out.println();
    }
    
    //Menu desplegable con opciones de produtos
    public static final void menuProdutos() {
	System.out.println();
        System.out.println("     PRODUTOS");
	System.out.println(" 1.- Crear produtos");
	System.out.println(" 2.- Guardar produtos");
	System.out.println(" 3.- Cargar produtos");
        System.out.println(" 4.- Mostrar produtos");
        System.out.println(" 5.- FINAL");
    }
    
}
