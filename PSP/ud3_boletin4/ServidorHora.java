package ud3_boletin4_ejer1;

import java.io.IOException;
import java.net.BindException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.time.LocalTime;
import java.time.LocalDate;

public class ServidorHora {
    
    public static void main(String[] args) {
        try {
            // Creamos un socket UDP en el puerto 3000
            DatagramSocket dSocket = new DatagramSocket(3000);
                
            while (true) {
                // Creamos el buffer para recibir los datos del cliente
                byte[] buffer = new byte[1024];
                DatagramPacket dPacket = new DatagramPacket(buffer, buffer.length);

                // Recibimos el paquete al socket.
                dSocket.receive(dPacket);

                // Conseguimos la direccion IP y puerto
                InetAddress address = dPacket.getAddress();
                int port = dPacket.getPort();

                // Obtenemos hora y día actuales
                String horaActual = LocalTime.now().toString();
                String diaActual = LocalDate.now().toString();
                String mensaje = diaActual + " " + horaActual;

                // Creamos el paquete de respuesta y lo enviamos al cliente
                buffer = mensaje.getBytes();
                dPacket = new DatagramPacket(buffer, buffer.length, address, port);
                dSocket.send(dPacket);  
            }         
        } catch(BindException e){            
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}