package ejemplos_Layout;

import java.awt.Container;
//import javax.swing.*;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;

public class BotonVentana extends JFrame{
    public BotonVentana(){
        super("Boton");
        setSize(200, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        JButton boton = new JButton("Pulsame!");
        boton.addActionListener(new EventoBotonPulsado());
        cp.add(boton);
    }
}
