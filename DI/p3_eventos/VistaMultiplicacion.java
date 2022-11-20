package p3_eventos;

import javax.swing.JFrame;

public class VistaMultiplicacion {
    
    public static void main(String[] args){
        //Creacion de manejador, ponerlo visible y establecer cierre.
        ManejadorMultiplicacion manejador = new ManejadorMultiplicacion();
        manejador.ventana.setVisible(true);
        manejador.ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
