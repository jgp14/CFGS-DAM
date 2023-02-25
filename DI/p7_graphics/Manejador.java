package p7_graphics;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Manejador implements ActionListener, ItemListener{

    private String cx1s, cy1s, cx2s, cy2s;
    private Double cx1, cy1, cx2, cy2, distance, ancho, alto;
    private JComboBox cb;
    private int nColor = 0;
    Ventana v;

    public Manejador(){
        this.v = new Ventana();
    }

    public Manejador(Ventana v){
        this.v = v;
    }

    public void actionPerformed(ActionEvent e){
        JButton btnCall = (JButton) e.getSource();
        if(btnCall.getText().equals(v.calc.getText())){
            v.panelPunto.setVisible(false);
            getCoordenates();
            v.panelPunto.p1.asignarX(cx1);
            v.panelPunto.p1.asignarY(cy1);
            v.panelPunto.p2.asignarX(cx2);
            v.panelPunto.p2.asignarY(cy2);
            
            distance  = v.panelPunto.p1.calcularDistancia(v.panelPunto.p2);
            v.distanceS.setText("Distancia entre puntos: "+distance);
            
            alto = v.panelPunto.p2.obtenerX() - v.panelPunto.p1.obtenerX() ;
            ancho = v.panelPunto.p2.obtenerY() - v.panelPunto.p1.obtenerY();
            
            if(alto >= ancho)
                v.panelPunto.setSide((int) (long) Math.round(alto));
            else 
                v.panelPunto.setSide((int) (long) Math.round(ancho));
            v.panelPunto.setVisible(true);
            
        } else if(btnCall.getText().equals(v.clean.getText())) {            
            v.panelPunto.setVisible(false);                        
        }
        
    }

    private void getCoordenates(){ //valores de los campos
        cx1s = v.tx1.getText().toString();
        cy1s = v.ty1.getText().toString();
        cx2s = v.tx2.getText().toString();
        cy2s = v.ty2.getText().toString();
        cx1 = convertStringDouble(cx1s);
        cy1 = convertStringDouble(cy1s);
        cx2 = convertStringDouble(cx2s);
        cy2 = convertStringDouble(cy2s);
    }
     
    private double convertStringDouble(String s){
        double d = 0.0f;
        try{
            d = Double.parseDouble(s);
        } catch(NumberFormatException ex) {
            d = 0.0f; //Manejo de exepcion
            v.tx1.setText(String.valueOf(d));
            v.ty1.setText(String.valueOf(d));
            v.tx2.setText(String.valueOf(d));
            v.ty2.setText(String.valueOf(d));
        } return d;
    }//Metodo para convertir un String a un valor float

    @Override
    public void itemStateChanged(ItemEvent e) {
        cb = (JComboBox) e.getSource();
        v.panelPunto.setVisible(false);
        nColor = cb.getSelectedIndex();        
        v.panelPunto.setColor(v.colores[nColor]);    
        v.panelPunto.setVisible(true);
    }
    
}
