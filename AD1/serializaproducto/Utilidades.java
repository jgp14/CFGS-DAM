package serializaproducto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author dam205
 */
public class Utilidades {
    
    //Atributos declarados de Utilidades
    private DatosProdutos datos;
    private ArrayList<Produto> produtos;
    private File fichero; 

    //Crear los objetos de los atributos
    public Utilidades(){
        datos = new DatosProdutos();
        produtos = new ArrayList<Produto>();
        fichero = new File("produtos.dat");
    }
    
    //Crear los produtos llamando al metodo xeraProdutos
    public void crearProdutos(){
        produtos.removeAll(produtos);
        produtos = datos.xeraProdutos();
    }
    
    //Guardar produtos en el fichero
    public void guardarProdutos() {
        try {
            FileOutputStream fos = new FileOutputStream(fichero);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for(Produto producto : produtos)
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
    public void leerProdutos(){
        Produto produto = null;
        try{
            FileInputStream fis = new FileInputStream(fichero);
            ObjectInputStream ois = new ObjectInputStream(fis); 
            while(fis.available() > 0){
                produto = (Produto) ois.readObject();
                produtos.add(produto);
            }
            ois.close();
            fis.close(); 
        } catch (FileNotFoundException fnfe) {
            System.out.println("Error: El fichero no existe. ");
        } catch (IOException ioe) {
            System.out.println("Error: Fallo en la lectura del fichero. ");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: Clase no encontrada. ");
        }
    }
    
    //Mostrar la lista de produtos por pantalla
    public void mostrarProdutos(){
        for(Produto produto : produtos)
            System.out.println(produto.toString());
        System.out.println();
    }
    
    public ArrayList<Produto> getProdutos(){
        return produtos;
    }   
    
}
