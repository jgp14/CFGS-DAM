package utilidades;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import serializaproducto.Produto;

/**
 *
 * @author dam205
 */
public class UtilidadesDat {
    
    private List list = new ArrayList<>();
    
    public UtilidadesDat(){}
    
    //Crear los objetos llamando al metodo xeraProdutos
    public void crearObjetos(Class clase){
        list.removeAll(list);
        Object o = new Object();
        list.add(clase.cast(o));
    } 
    
    //Guardar objetos en el fichero
    public void guardarDat(String ruta, Class clase) {
        if(list.isEmpty()) //Si esta vacio la lista la genera
            crearObjetos(clase);
        try {
            File fichero = new File(ruta+".dat");
            FileOutputStream fos = new FileOutputStream(fichero);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for(int i = 0; i < list.size(); i++)
                oos.writeObject(list.get(i));
            oos.close(); 
            fos.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println("Error: El fichero no existe. ");
        } catch (IOException ioe) {
            System.out.println("Error: Fallo en escritura del fichero. ");
        }
        list.removeAll(list);
    }
    
    //Leer produtos del fichero
    public List<Produto> leerObjetos(String ruta, Class clase){
        guardarDat(ruta, clase);                
        try{
            File fichero = new File(ruta+".dat");
            FileInputStream fis = new FileInputStream(fichero);
            ObjectInputStream ois = new ObjectInputStream(fis); 
            while(fis.available() > 0)
                list.add(clase.cast(ois.readObject()));
            ois.close();
            fis.close(); 
        } catch (FileNotFoundException fnfe) {
            System.out.println("Error: El fichero no existe. ");
        } catch (IOException ioe) {
            System.out.println("Error: Fallo en la lectura del fichero. ");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: Clase no encontrada. ");
        }
        return list;
    }
    
    //Mostrar la lista de objetos por pantalla
    public void mostrarProdutos(String ruta, Class clase){
        List list = leerObjetos(ruta, clase);
        for(int i = 0; i < list.size(); i++)
            System.out.println(list.get(i).toString());
    }
}
