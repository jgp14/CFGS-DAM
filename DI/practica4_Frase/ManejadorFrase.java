package practica4_Frase;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManejadorFrase implements ActionListener {
    VentanaFrase ventanaFrase;
    Frase frase = new Frase("");

    //Constructores de el manejador
    public ManejadorFrase(){
        this.ventanaFrase = new VentanaFrase();
    }

    public ManejadorFrase(VentanaFrase ventanaFrase){
        this.ventanaFrase = ventanaFrase;
    }

    public void actionPerformed(ActionEvent e){ 
        JButton btnLlamada = (JButton) e.getSource();
        Integer nLetras = 0, nPalabras = 0;
        if(btnLlamada.getText().toString().equals("Procesar frase")){
            this.frase.setCadena(ventanaFrase.textoFrase.getText().toString());
            nLetras = this.frase.contarLetras();
            nPalabras = this.frase.contarPalabras();
            ventanaFrase.textoLetras.setText(nLetras.toString());
            ventanaFrase.textoPalabras.setText(nPalabras.toString());
        }
    }
    
}
