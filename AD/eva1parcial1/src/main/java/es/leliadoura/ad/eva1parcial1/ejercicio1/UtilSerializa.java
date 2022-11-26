package es.leliadoura.ad.eva1parcial1.ejercicio1;

import es.leliadoura.ad.eva1parcial1.data.Ciclo;
import es.leliadoura.ad.eva1parcial1.data.Modulo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


/**
 *
// * @author marco
 */
public class UtilSerializa {

    private void e(Exception ex){ex.printStackTrace();}
    
    public void guardaListModulos(String ruta, List<Modulo> list){
        try {
            File file = new File(ruta+".dat");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for(int i = 0; i<list.size(); i++)
                oos.writeObject(list.get(i));
            oos.close(); 
            fos.close();
        } catch (FileNotFoundException ex) {e(ex);} 
        catch (IOException ex) {e(ex);}
    }
    
    public List<Modulo> leeListaModulos(String ruta){
        List<Modulo> modulos = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(ruta+".dat");
            ObjectInputStream ois = new ObjectInputStream(fis); 
            while(ois.available() > 0)
                modulos.add((Modulo) ois.readObject());
            ois.close();
            fis.close(); 
        } catch (FileNotFoundException ex) {e(ex);} 
        catch (IOException | ClassNotFoundException ex) {e(ex);}
        return modulos;
    }
    
    public void guardaListaCiclos(String ruta, List<Ciclo> ciclos){
        try {
            File fichero = new File(ruta+".dat");
            FileOutputStream fos = new FileOutputStream(fichero);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for(Ciclo ciclo: ciclos){
                oos.writeObject(ciclo);
            }
            oos.close(); 
            fos.close();
        } catch (FileNotFoundException ex) {e(ex);} 
        catch (IOException ex) {e(ex);}
    }
    
    public List<Ciclo> leeListaCiclos(String ruta){
        List<Ciclo> ciclos = new ArrayList<>();
        try{
            File fichero = new File(ruta+".dat");
            FileInputStream fis = new FileInputStream(fichero);
            ObjectInputStream ois = new ObjectInputStream(fis); 
            while(fis.available() > 0)
                ciclos.add((Ciclo) ois.readObject());
            ois.close();
            fis.close(); 
        } catch (FileNotFoundException ex) {e(ex);} 
        catch (IOException | ClassNotFoundException ex) {e(ex);}
        return ciclos;
    }
    
    public void mostraListaCiclos(String ruta){
        for(Ciclo ciclo: leeListaCiclos(ruta))
            System.out.println(ciclo);
    }
    
    public Ciclo encuentraCiclo(String ruta, String nombre){
       List<Ciclo> ciclos = new ArrayList<>();
       Ciclo cicloX = new Ciclo();
       ciclos = leeListaCiclos(ruta);
       for(Ciclo ciclo: ciclos)
           if(ciclo.getNombre().equals(nombre)){
               cicloX = ciclo;
               break;
           }
       return cicloX; 
    }
   
}
