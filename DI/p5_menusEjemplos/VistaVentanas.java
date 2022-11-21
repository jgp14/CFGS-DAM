package p5_menusEjemplos;

import javax.swing.JFrame;

public class VistaVentanas {
    public static void main(String[] args){
        //Creacion de manejador Fuente, hacer visible y poner cierre.
        ManejadorVentanas manejador = new ManejadorVentanas();
        manejador.ventana.setVisible(true);
        manejador.ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
