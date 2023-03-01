package ud3_boletin3_eje1;

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
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
        
        String op="",dato="",menu="";  
        menu = menuOpcionesServidor();
        dout.writeUTF(menu);  
        dout.flush(); 
        op=din.readUTF();              
        System.out.println("client choose: "+op);  
        dato = mensajeServidor(op);
        System.out.println("client message: "+dato);  
        dout.writeUTF(dato);  
        dout.flush(); 

        din.close();  
        s.close();  
        ss.close();  
    }

    private static String menuOpcionesServidor(){
        String menu = "\nELIGE DATO QUE SOLITAS" +
                        "\n\t1.- Dia" +
                        "\n\t2.- Mes" +
                        "\n\t3.- Año" +
                        "\n\t4.- Hora" +
                        "\n\tElige opcion";
        return menu;
    }

    private static String mensajeServidor(String op){
        LocalDate localDate = LocalDate.now();
        LocalTime LocalTime = java.time.LocalTime.now();
        String msg = "";
        if(op.equals("1") 
        || op.equals("dia")
        || op.equals("Dia"))
            msg = "Dia: "+localDate.getDayOfMonth();
            
        else if(op.equals("2") 
        || op.equals("mes")
        || op.equals("Mes"))
            msg = "Mes: "+localDate.getMonthValue();
        else if(op.equals("3") 
        || op.equals("año")
        || op.equals("Año"))
            msg = "Año: "+localDate.getYear();
        else if((op.equals("4") 
        || op.equals("año")
        || op.equals("Año"))){
            msg = "Hora: "+ LocalTime.getHour();
        }
        return msg;
    }

}
