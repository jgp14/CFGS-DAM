package ud3_boletin4_ejer1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.time.Duration;
import java.time.LocalTime;

public class ClienteHoraPing {

    public static void main(String[] args) {
        try {
            // Creamos un socket UDP
            DatagramSocket socket = new DatagramSocket();

            // Configuramos la IP y puerto del servidor
            InetAddress address = InetAddress.getByName("127.0.0.1");
            int port = 3000;

            // Creamos buffer para envio de peticiones al servidor
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, port);

            // Enviamos al servidor
            socket.send(packet);

            // Configuramos el tiempo de espera
            socket.setSoTimeout(5000);

            // Creamos el buffer para recibir la respuesta del servidor
            buffer = new byte[1024];
            packet = new DatagramPacket(buffer, buffer.length);

            try {
                // Esperamos a recibir la respuesta del servidor
                socket.receive(packet);

                // Convertimos los bytes recibidos en una cadena de texto
                String mensaje = new String(packet.getData(), 0, packet.getLength());

                // Obtenemos la hora local y la hora remota
                LocalTime horaLocal = LocalTime.now();
                LocalTime horaRemota = LocalTime.parse(mensaje.split(" ")[1]);

                // Calculamos la diferencia entre las horas y la imprimimos
                Duration diferencia = Duration.between(horaLocal, horaRemota);

                Double segundos = Double.valueOf(diferencia.abs().getNano())/1000000000.0F;
                System.out.println("La hora remota es " + segundos + " segundos " + 
                (diferencia.isNegative() ? "antes" : "después") + " que la hora local.");
            } catch (SocketTimeoutException e) {
                // Imprimimos un mensaje de error si no recibimos la respuesta a tiempo
                System.out.println("No se recibió respuesta del servidor.");
            }

            // Cerramos el socket
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
