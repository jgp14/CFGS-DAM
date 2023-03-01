package ud3_boletin2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestURL {    
    public static void main(String[] args){
        ConexionURL conexionURL = new ConexionURL();
        String url, ruta;
        url = conexionURL.menu();
        ruta = "url.txt";        
        escribirFichero(url, ruta);
        String urlRecuperada = leerFichero(ruta);
        System.out.println(urlRecuperada);
    }

    private static void escribirFichero(String url, String ruta){
        try {
            File file = new File(ruta);
            FileWriter fw = new FileWriter(file);
            fw.write(url);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String leerFichero(String ruta){
        String url = "";
        int ch; 
        try{
            FileReader fr = new FileReader(ruta);
            while((ch = fr.read()) != -1)
                url = url + (char) ch;
            fr.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }  return url;
    }    

}
