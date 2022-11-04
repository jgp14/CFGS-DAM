package practica4_Color;

import javax.swing.JFrame;

public class VistaColor {

    public static void main(String[] args){
        //Creacion de manejador, ponerlo visible y establecer cierre.
        ManejadorColor manejador = new ManejadorColor();
        manejador.ventana.setVisible(true);
        manejador.ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
    }
}
