package ud3_boletin3_eje2;

import java.net.*;  
import java.io.*;

public class Cliente {
    
    public static void main(String args[])throws Exception{  
        Socket s=new Socket("localhost",3333);  
        DataInputStream din=new DataInputStream(s.getInputStream());  
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
        
        String mensajeLeido="", ficheroReceptor = ""; 
        mensajeLeido = din.readUTF();        
        
        //CAMBIAR LA RUTA PARA PRUEBAS
        ficheroReceptor = "J:\\DAM\\PSP\\PSP2\\src\\ud3_boletin3_eje2\\ficheroReciver.txt";        
        guardarFichero(ficheroReceptor, mensajeLeido);

        System.out.println(leerFichero(ficheroReceptor));

        dout.close();  
        s.close();  
    }

    public static void guardarFichero(String ruta, String mensaje){        
        try {
            File file = new File(ruta);
            FileWriter fw = new FileWriter(file);
            fw.write(mensaje);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String leerFichero(String ruta){
        String mensajeString = "";
        try {
            FileReader fr = new FileReader(ruta);
            int valor = fr.read();            
            while(valor != -1){
                mensajeString = mensajeString +(char) valor;
                valor = fr.read();
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mensajeString;
    }
}
