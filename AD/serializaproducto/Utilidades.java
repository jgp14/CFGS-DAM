package serializaproducto;

import java.io.*;
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
    private boolean simple;
    
    //Crear los objetos de los atributos
    public Utilidades(){
        datos = new DatosProdutos();
        produtos = new ArrayList<Produto>();
        fichero = new File("produtos.dat");
        simple = false;
    }    

    public Utilidades(DatosProdutos datos, 
            ArrayList<Produto> produtos, File fichero, boolean simple) {
        this.datos = datos;
        this.produtos = produtos;
        this.fichero = fichero;
        this.simple = simple;
    }    
                
    public ArrayList<Produto> getProdutos(){
        return produtos;
    }       

    public void setSimple(boolean simple) {
        this.simple = simple;
    }        
    
    //Crear los produtos llamando al metodo xeraProdutos
    public void crearProdutos(){
        produtos.removeAll(produtos);
        if(simple)
            produtos = datos.xeraProdutosSimple();
        else 
            produtos = datos.xeraProdutos();
    }   
    
    //Guardar produtos en el fichero
    public void guardarProdutos() {
        if(produtos.isEmpty()) //Si esta vacio la lista la genera
            crearProdutos();
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
    public ArrayList<Produto> leerProdutos(){
        Produto produto = null;
        guardarProdutos();                
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
        return produtos;
    }
    
    //Mostrar la lista de produtos por pantalla
    public void mostrarProdutos(){
        ArrayList<Produto> produtos = new ArrayList<>();
        produtos = leerProdutos();
        for(Produto produto : produtos)
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
