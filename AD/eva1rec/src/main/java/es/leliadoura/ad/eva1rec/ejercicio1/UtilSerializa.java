package es.leliadoura.ad.eva1rec.ejercicio1;

import es.leliadoura.ad.eva1rec.data.Ciclo;
import es.leliadoura.ad.eva1rec.data.Modulo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marco
 */
public class UtilSerializa {
    
    // METODO LEER ARCHIVO DAT 
    public List<Modulo> leer(String ruta){
        List<Modulo> modulos = new ArrayList<>();
        try {        
            FileInputStream fis = new FileInputStream(ruta);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(fis.available() > 0){
                Modulo modulo = (Modulo) ois.readObject();
                modulos.add(modulo);
            }
            ois.close();
            fis.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UtilSerializa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
                Logger.getLogger(UtilSerializa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UtilSerializa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modulos;        
    }
    
    // METODO ESCRIBIR UN CICLO EN UN ARCHIVO DAT 
    public void escribir(String ruta, Ciclo ciclo){
        try {
            FileOutputStream fos = new FileOutputStream(ruta);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ciclo);
            oos.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UtilSerializa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UtilSerializa.class.getName()).log(Level.SEVERE, null, ex);
        }                
    }
}
