package practica4_masEventos;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ManejadorColor implements ActionListener, 
    KeyListener, AdjustmentListener{    
    VentanaColor ventana; //Atributos de ManejadorColor
    JButton btnCall = new JButton();
    String redString, greenString, blueString ;
    int red, green, blue;
    Color colorFondo;

    public ManejadorColor(){
        this.ventana = new VentanaColor();            
    }        
    
    public ManejadorColor(VentanaColor ventana){
        this.ventana = ventana;
    }

    //Evitar introducir los caracteres no numericos
    private int stringToInt(String s){
        int i = 0;
        try{            
            i = Integer.parseInt(s);
        } catch(NumberFormatException ex) {
            //i = 0;
            ventana.tfs[1].setText("");
            ventana.tfs[3].setText("");
            ventana.tfs[5].setText("");
            ventana.sbs[0].setValue(i);
            ventana.sbs[1].setValue(i);
            ventana.sbs[2].setValue(i);
        }
        return i;
    }
    //Escuchador de los JScroll
    public void adjustmentValueChanged (AdjustmentEvent e){
        colorFondo = new Color(ventana.sbs[0].getValue(), 
        ventana.sbs[1].getValue(), ventana.sbs[2].getValue());
        ventana.p2.setBackground(colorFondo);
    }
    //Escuchador de los botones
    public void actionPerformed (ActionEvent e) {
        btnCall = (JButton) e.getSource();            
        for(int i = 0; i < ventana.X; i++){
            if(String.valueOf
            (btnCall.getText()).equals(ventana.colorNames[i])){
                ventana.p2.setBackground(ventana.colores[i]);
                ventana.sbs[0].setValue(ventana.colores[i].getRed());
                ventana.sbs[1].setValue(ventana.colores[i].getGreen());
                ventana.sbs[2].setValue(ventana.colores[i].getBlue());
            }
        }
    }    
    //Escuchador de los JTextFields
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_ENTER){
            redString = String.valueOf(ventana.tfs[1].getText());
            greenString = String.valueOf(ventana.tfs[3].getText());
            blueString = String.valueOf(ventana.tfs[5].getText());
            red = stringToInt(redString);            
            green = stringToInt(greenString);            
            blue = stringToInt(blueString);            
            if(red < 0 || red > 255)
                ventana.tfs[1].setText("0");
            else if(green < 0 || green > 255)
                ventana.tfs[3].setText("0");
            else if(blue < 0 || blue > 255)
                ventana.tfs[5].setText("0");
            ventana.p2.setBackground(new Color(red, green, blue)); 
            ventana.sbs[0].setValue(red);           
            ventana.sbs[1].setValue(green);   
            ventana.sbs[0].setValue(blue);   
        }    		
	}
    //Obligarorio poner todos los metodos de la interface
    public void keyReleased(KeyEvent e){}
    public void keyTyped(KeyEvent e) {}
}
