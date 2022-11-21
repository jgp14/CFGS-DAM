package ejemplos_Layout;

import javax.swing.*;

public class Ejemplo_FlowLayout extends JFrame{
    public static void main(String[] args){
        Ejemplo_FlowLayout frame = new Ejemplo_FlowLayout();
        JPanel panel = new JPanel();
        JButton boton1 = new JButton("Boton 1");
        JButton boton2 = new JButton("Boton 2");
        JButton boton3 = new JButton("Boton 3");
        panel.add(boton1);
        panel.add(boton2);
        panel.add(boton3);
        frame.setContentPane(panel);
        frame.setSize(350,150);
        frame.setTitle("Prueba de FlowLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
