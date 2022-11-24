package serializaproducto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dam205
 */
public class Utilidades {
    
    public Utilidades() {}
    
    //Crear los produtos
    public List<Produto> crear(){
        List<Produto> list = (new DatosProdutos()).xeraProdutos();
        return list;
    }   
    
    //Guardar en el fichero dat
    public void guardar(String ruta, List<Produto> list) {
        if(list.isEmpty())
            list = crear();
        try {
            File file = new File(ruta+".dat");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for(int i = 0; i < list.size(); i++)
                oos.writeObject(list.get(i));
            oos.close(); 
            fos.close();
        } catch (FileNotFoundException e) {System.err.println(e);} 
        catch (IOException e) {System.err.println(e);}
    }
    
    //Leer el fichero dat
    public List<Produto> leer(String ruta){        
        List<Produto> list = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(ruta+".dat");
            ObjectInputStream ois = new ObjectInputStream(fis); 
            while(fis.available() > 0)
                list.add((Produto) ois.readObject());
            ois.close();
            fis.close(); 
        } catch (FileNotFoundException e) {System.err.println(e);} 
        catch (IOException e) {System.err.println(e);}
        catch (ClassNotFoundException e){System.err.println(e);}
        return list;
    }
    
    //Mostrar la lista por pantalla
    public void mostrar (List<Produto> list){
        for(int i = 0; i < list.size(); i++ )
            System.out.println(list.get(i).toString());
    }
    
}
