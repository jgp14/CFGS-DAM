package p1_empiezaSwing;

import java.awt.Container;

import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;

//Clase MiVentanaFlow que actua como Modelo
public class MiVentanaFlow extends JFrame{
    private Container cp;
    JTextField txt1, txt2, txt3, txt4;
    JLabel etiqueta;
    JButton boton1, boton2;
    
    public MiVentanaFlow() {
        super("Mi primera ventana");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cp = getContentPane();
        cp.setLayout(new FlowLayout());
        textFields();
        //Creacion de etiqueta
        etiqueta = new JLabel("Selecciona: ");
        botones();
        addToContainter();
    }
    
    private void textFields(){//Creacion de cuadros de texto
        txt1 = new JTextField(30);
        txt2 = new JTextField(30);
        txt3 = new JTextField(30);
        txt4 = new JTextField(30);
    }
    
    private void botones(){//Creacion de botones y listeners
        boton1 = new JButton("Comprobar");
        boton2 = new JButton("Salir");
        //Añadimos escuchadores
        boton1.addActionListener(new ManejadorEventos(this));
        boton2.addActionListener(new ManejadorEventos(this));
    }
    
    private void addToContainter(){//Añadir al contenedor los elementos
        cp.add(txt1);
        cp.add(txt2);
        cp.add(txt3);
        cp.add(txt4);
        cp.add(etiqueta);
        cp.add(boton1);
        cp.add(boton2);
    }
    
}
