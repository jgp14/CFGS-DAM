package p4_masEventosFuente;

import javax.swing.JFrame;

public class VistaFuente {
    
    public static void main(String[] args){
        //Creacion de manejador Fuente, hacer visible y poner cierre.
        ManejadorFuente manejador = new ManejadorFuente();
        manejador.ventana.setVisible(true);
        manejador.ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
    }
}
