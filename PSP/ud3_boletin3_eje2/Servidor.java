package ud3_boletin3_eje2;

import java.io.*;
import java.net.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class Servidor{  
    public static void main(String args[]) throws Exception{  
        ServerSocket ss=new ServerSocket(3333);  
        Socket s=ss.accept();  
        DataInputStream din=new DataInputStream(s.getInputStream());  
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());  

        String mensaje="", mensajeEnvio;
        //CAMBIAR LA RUTA PARA PRUEBAS
        String name = "J:\\DAM\\PSP\\PSP2\\src\\ud3_boletin3_eje2\\ficheroOrigen.txt";

        mensaje = mensajeServidor();

        guardarFichero(name, mensaje);
        
        mensajeEnvio = leerFichero(name);
        
        System.out.println("client message: " + 
            "\nDATOS FECHA ACTUAL: " + 
            "Dia, Mes, Año, Hora");  
        dout.writeUTF(mensajeEnvio);  
        dout.flush(); 

        din.close();  
        s.close();  
        ss.close();  
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

    private static String mensajeServidor(){
        LocalDate localDate = LocalDate.now();
        LocalTime LocalTime = java.time.LocalTime.now();
        String msg = "";
        msg = "\nDATOS FECHA ACTUAL"
            + "\nDia: "+localDate.getDayOfMonth()
            + "\nMes: "+localDate.getMonthValue()
            + "\nAnho: "+localDate.getYear()
            + "\nHora: "+ LocalTime.getHour();        
        return msg;
    }//MENSAJDE DE EJEMPLO DE FECHAS

}
