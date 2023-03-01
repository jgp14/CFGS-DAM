package ud3_boletin3_eje1;

import java.net.*;  
import java.io.*;

public class Cliente {
    
    public static void main(String args[])throws Exception{  
        Socket s=new Socket("localhost",3333);  
        DataInputStream din=new DataInputStream(s.getInputStream());  
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
        
        String menu="",op="",mensaje="";  
        menu=din.readUTF();  
        System.out.println("Server says: "+menu); 
        
        op=br.readLine();
        dout.writeUTF(op);  
        dout.flush();

        mensaje = din.readUTF();
        System.out.println(mensaje);
        
        dout.close();  
        s.close();  
    }
}
