package ejemploserializacion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author marco
 */
public class Almacen {

    public void guardarAlumnos() {
        //Crear objetos
        Alumno a1 = new Alumno("11111111A", "Luis");
        Alumno a2 = new Alumno("22222222B", "Marta");
        Alumno a3 = new Alumno("33333333C", "Andrea");
        
        try {
            //Preparar el flujo de salida para escribir
            FileOutputStream ficheroSalida = new FileOutputStream("alumnos.dat");
            ObjectOutputStream salida = new ObjectOutputStream(ficheroSalida);
            
            //Guardar objetos
            salida.writeObject(a1);
            salida.writeObject(a2);
            salida.writeObject(a3);
            
            //Cerrar fichero
            salida.close();
            ficheroSalida.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void leerAlumnos() {
        FileInputStream ficheroEntrada = null;
        ObjectInputStream entrada = null;
        try {
            //Preparar el flujo de entrada de los datos
            ficheroEntrada = new FileInputStream("alumnos.dat");
            entrada = new ObjectInputStream(ficheroEntrada);
            
            //Leer objetos
            Alumno alumno = null;
            while (ficheroEntrada.available() > 0) {
                alumno = (Alumno) entrada.readObject();
                System.out.println(alumno);
            }
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
                //Cerrar ficheiro
                if (entrada != null) entrada.close();
                if (ficheroEntrada != null) ficheroEntrada.close();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }
        
    }

    public void guardarModulos(){
        //Crear objetos
        Modulo m1 = new Modulo("MP1", 9, "AD");
        Modulo m2 = new Modulo("MP2", 6, "DI");
        Modulo m3 = new Modulo("MP3", 4, "PSP");
        
        try {
            //Preparar el flujo de salida para escribir
            FileOutputStream ficheroSalida = new FileOutputStream("modulos.dat");
            ObjectOutputStream salida = new ObjectOutputStream(ficheroSalida);
            
            //Guardar objetos
            salida.writeObject(m1);
            salida.writeObject(m2);
            salida.writeObject(m3);
            
            //Cerrar fichero
            salida.close();
            ficheroSalida.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void leerModulos() {
        try {
            //Preparar el flujo de entrada de los datos
            FileInputStream ficheroEntrada = new FileInputStream("modulos.dat");
            ObjectInputStream entrada = new ObjectInputStream(ficheroEntrada);
            
            //Leer objetos
            Modulo mod = null;
            while (ficheroEntrada.available() > 0) {
                mod = (Modulo) entrada.readObject();
                System.out.println(mod);
            }
            
            //Cerrar ficheiro
            entrada.close();
            ficheroEntrada.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
    }

}
