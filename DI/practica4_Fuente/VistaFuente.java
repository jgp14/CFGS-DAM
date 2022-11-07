package practica4_Fuente;

import javax.swing.JFrame;

public class VistaFuente {
    
    public static void main(String[] args){
        //Creacion de manejador, ponerlo visible y establecer cierre.
        ManejadorFuente manejador = new ManejadorFuente();
        //manejador.ventana.setResizable(false);
        manejador.ventana.setVisible(true);
        manejador.ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
    }
}
