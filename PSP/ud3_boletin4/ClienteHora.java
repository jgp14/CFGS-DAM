package ud3_boletin4_ejer1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.time.format.DateTimeFormatter;

public class ClienteHora {
    public static void main(String[] args) {
        try {
            // Creamos un socket UDP
            DatagramSocket dSocket = new DatagramSocket();

            // Configuramos la IP y puerto del servidor
            InetAddress ia = InetAddress.getByName("127.0.0.1");
            int port = 3000;

            // Creamos buffer para envio de peticiones al servidor
            byte[] buffer = new byte[1024];
            DatagramPacket dPacket = 
            new DatagramPacket(buffer, buffer.length, ia, port);

            // Enviamos al servidor
            dSocket.send(dPacket);

            // Configuramos el tiempo de espera
            int timeout = 5000;
            dSocket.setSoTimeout(timeout);

            // Creamos el buffer para recibir la respuesta
            int size = 1024;
            buffer = new byte[size];
            dPacket = new DatagramPacket(buffer, size);

            try {
                // Esperamos a recibir la respuesta del server
                dSocket.receive(dPacket);

                // Convertimos los bytes recibidos en String
                String mensaje = 
                new String(dPacket.getData(), 0, dPacket.getLength());

                String[] parts = mensaje.split(" ");
                String diaActual = parts[0]; 
                String horaCompleta = parts[1];
                String[] horaPartes = horaCompleta.split("\\.");
                String horaActual = horaPartes[0];

                // Imprimimos el día y la hora
                System.out.println(diaActual + " " + horaActual);

            } catch (SocketTimeoutException e) {
                // Imprimimos un mensaje de error si no hay respuesta
                System.out.println("No se recibio respuesta del servidor tras 5s.");
            }
            dSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
