package p4_masEventosColor;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ManejadorColor implements ActionListener, 
    KeyListener, AdjustmentListener, FocusListener{    
    VentanaColor ventana; //Atributos de ManejadorColor
    JButton btnCall = new JButton();
    String redString, greenString, blueString ;
    int red, green, blue;

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
            i = ventana.colorF.getRed();
            ventana.tfs[0].setText
            (String.valueOf(ventana.colorF.getRed()));
            ventana.tfs[1].setText
            (String.valueOf(ventana.colorF.getRed()));
            ventana.tfs[2].setText
            (String.valueOf(ventana.colorF.getRed()));
            ventana.sbs[0].setValue(ventana.colorF.getRed());
            ventana.sbs[1].setValue(ventana.colorF.getGreen());
            ventana.sbs[2].setValue(ventana.colorF.getBlue());
        }
        return i;
    }
    //Escuchador de los JScroll
    public void adjustmentValueChanged (AdjustmentEvent e){
        ventana.p2.setBackground(new Color(ventana.sbs[0].getValue(), 
        ventana.sbs[1].getValue(), ventana.sbs[2].getValue()));
        for(int i = 0; i < ventana.Y; i++)
            ventana.tfs[i].setText(String.valueOf(ventana.sbs[i].getValue()));
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
                ventana.tfs[0].setText
                (String.valueOf(ventana.colores[i].getRed()));
                ventana.tfs[1].setText
                (String.valueOf(ventana.colores[i].getGreen()));
                ventana.tfs[2].setText
                (String.valueOf(ventana.colores[i].getBlue()));
            }
        }
    }    
    
    public void focusLost(FocusEvent e){
        redString = String.valueOf(ventana.tfs[0].getText());
        greenString = String.valueOf(ventana.tfs[1].getText());
        blueString = String.valueOf(ventana.tfs[2].getText());
        red = stringToInt(redString);            
        green = stringToInt(greenString);            
        blue = stringToInt(blueString);            
        if(red < 0 || red > 255)
            ventana.tfs[0].setText(String.valueOf(ventana.colorF.getRed()));
        else if(green < 0 || green > 255)
            ventana.tfs[1].setText(String.valueOf(ventana.colorF.getRed()));
        else if(blue < 0 || blue > 255)
            ventana.tfs[2].setText(String.valueOf(ventana.colorF.getRed()));
        ventana.p2.setBackground(new Color(red, green, blue)); 
        ventana.sbs[0].setValue(red);           
        ventana.sbs[1].setValue(green);   
        ventana.sbs[2].setValue(blue);   
    }
    public void focusGained(FocusEvent e){}

    //Escuchador de los JTextFields
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_ENTER){
            redString = String.valueOf(ventana.tfs[0].getText());
            greenString = String.valueOf(ventana.tfs[1].getText());
            blueString = String.valueOf(ventana.tfs[2].getText());
            red = stringToInt(redString);            
            green = stringToInt(greenString);            
            blue = stringToInt(blueString);            
            if(red < 0 || red > 255)
                ventana.tfs[0].setText("0");
            else if(green < 0 || green > 255)
                ventana.tfs[1].setText("0");
            else if(blue < 0 || blue > 255)
                ventana.tfs[2].setText("0");
            ventana.p2.setBackground(new Color(red, green, blue)); 
            ventana.sbs[0].setValue(red);           
            ventana.sbs[1].setValue(green);   
            ventana.sbs[2].setValue(blue);   
        }    		
	}
    //Obligarorio poner todos los metodos de la interface
    public void keyReleased(KeyEvent e){}
    public void keyTyped(KeyEvent e) {}
}
