package practica4_Fuente;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ManejadorFuente implements ActionListener, ItemListener {
    VentanaFuente ventana;
    String text;
    Font fOrigen;

    //Constructores de manejador
    public ManejadorFuente(){
        this.ventana = new VentanaFuente();            
    }        
    
    public ManejadorFuente(VentanaFuente ventana){
        this.ventana = ventana;
    }

    //Escuchador para el checkbox
    public void itemStateChanged(ItemEvent e){
        int state = e.getStateChange();
        fOrigen = ventana.tf.getFont();
        if(state == 1)
            ventana.tf.setFont(fOrigen.deriveFont(2));  
        else if(state == 2)
            ventana.tf.setFont(fOrigen.deriveFont(0));
        else ventana.tf.setFont(fOrigen); 
    }

    //Escuchador para los radiobutton
    public void actionPerformed(ActionEvent e){ 
        JRadioButton btnCall = (JRadioButton) e.getSource();
        text = ventana.tf.getText(); 
        fOrigen = ventana.tf.getFont();
        if(btnCall.getText().equals(ventana.rb1.getText()))        
            ventana.tf.setFont(fOrigen.deriveFont(fOrigen.getStyle(), 12));
        else if(btnCall.getText().equals(ventana.rb2.getText()))
            ventana.tf.setFont(fOrigen.deriveFont(fOrigen.getStyle(), 18));
        else if(btnCall.getText().equals(ventana.rb3.getText()))
            ventana.tf.setFont(fOrigen.deriveFont(fOrigen.getStyle(), 24));
        else ventana.tf.setFont(fOrigen);
    }

}
