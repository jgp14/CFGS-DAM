package p6_repasoEsquinas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;

public class fraManejador implements ActionListener, ItemListener{
    //Atributos del manejador
    fraVentana v;
    JButton btn;
    int ancho, alto;
    
    public fraManejador(){
        this.v = new fraVentana();
    }//Constructores Manejador sin parametros

    public fraManejador(fraVentana v){
        this.v = v;
    }//Constructores Manejador con parametros

    public void actionPerformed(ActionEvent e){ 
        btn = (JButton) e.getSource();
        v.btnName = btn.getText();
        setLocationButtons(v.btnName);
    }//Escuchador actionPerformed
    
    private void setLocationButtons(String name){
        alto = v.d.height - v.getHeight();
        ancho = v.d.width - v.getWidth();
        if(v.btnArribaIzda.getText().equals(name))
            v.setLocation(0, 0);
        else if(v.btnArribaDcha.getText().equals(name))
            v.setLocation(ancho, 0);
        else if(v.btnAbajoIzda.getText().equals(name))
            v.setLocation(0, alto);
        else if(v.btnAbajoDcha.getText().equals(name))
            v.setLocation(ancho, alto);
    }//Metodo para cambiar la ubicacion pantalla

    public void itemStateChanged(ItemEvent e){
        if(v.btnCentro.isSelected()){
            v.btnCentro.setText(v.sSmall);
            v.setSize(v.dMax);
            if(v.getLocation().x == ancho)
            setLocationButtons(v.btnName);            
        } 
        else if(!v.btnCentro.isSelected()){
            v.btnCentro.setText(v.sBig);
            v.setSize(v.dIni);
            setLocationButtons(v.btnName);
        };
    }//Escuchador itemStateChanged
}
