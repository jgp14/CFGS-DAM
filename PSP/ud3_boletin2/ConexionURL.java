package ud3_boletin2;

import java.net.*;
import java.net.MalformedURLException;
import java.util.Scanner;

public class ConexionURL {
    
    private static Scanner s = new Scanner(System.in);

    public static String menu(){
        URL url; 
        String urlString = "", protocol, host, file;
        int option = 0, port; 
        do{
            menuOpcionesURL();
            option = datoInt();
            try {
                if(option == 1){
                    System.out.println("Introduce una URL completa: ");
                    urlString = s.nextLine();
                    System.out.println("\nConstructor simple para una URL:");
                    url = new URL(urlString);
                    Visualizar(url);
                }
                else if(option == 2){
                    System.out.println("Introduce un protocolo: ");
                    protocol = s.nextLine();
                    System.out.println("Introduce un host: ");
                    host = s.nextLine();
                    System.out.println("Introduce un puerto: ");
                    port = datoInt();
                    System.out.println("Introduce una ruta de fichero: ");
                    file = s.nextLine();
                    System.out.println("\nConstructor para protocolo + URL + puerto + directorio:");
                    url = new URL(protocol, host, port, file);
                    Visualizar(url);
                    urlString = url.toString();
                }
                else if(option == 3) 
                    System.out.println("FIN");
                else
                    System.out.println("OPCION ERRONEA");
            }catch(MalformedURLException e){
                e.printStackTrace();
            }
        } while(option != 3);
        return urlString;
    }

    private static void menuOpcionesURL(){
        System.out.println("ELIGE OPCION DE INTRODUCION DE LA URL");
        System.out.println("\t1. - URL completa (Ej.: https://www.google.com/home)");
        System.out.println("\t2- - URL por partes (protoco, host, puerto y fichero)");
        System.out.println("\t3- - Salir de la seleccion y continuar");
    }

    public static int datoInt() { 
        int entero = 0;
        try {
            entero = Integer.parseInt(s.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error el input no es un entero");
            entero = Integer.MIN_VALUE;
        }
        return entero;
    }

    private static void Visualizar(URL url){
        System.out.println("\tURL completa: " + url.toString());
        System.out.println("\tgetProtocol(): " + url.getProtocol());
        System.out.println("\tgetHost(): " + url.getHost());
        System.out.println("\tgetPort(): " + url.getPort());
        System.out.println("\tgetFile(): " + url.getFile());
        System.out.println("\tgetUserInfo(): " + url.getUserInfo());
        System.out.println("\tgetPath(): " + url.getPath());
        System.out.println("\tgetAuthority(): " + url.getAuthority());
        System.out.println("\tgetQuery(): " + url.getQuery());
        System.out.println("======================================");
    }

    public static void main(String[] args){
        menu();
    }//main
   
}
