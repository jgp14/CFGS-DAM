package p5_menus;

import javax.swing.JFrame;

public class VistaMenu {
    public static void main(String[] args){
        //Creacion de manejador Fuente, hacer visible y poner cierre.
        ManejadorMenu manejador = new ManejadorMenu();
        manejador.ventana.setVisible(true);
        manejador.ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
