package p1_empiezaSwing;

import javax.swing.*;
import java.awt.*;

//Clase MiVentanaBorder que actua como Modelo
public class MiVentanaBorder extends JFrame{
    private Container cp;
    JTextField txt1, txt2, txt3, txt4;
    JLabel etiqueta;
    JButton boton1, boton2;
    private JPanel panel1, panel2, panel3;

    public MiVentanaBorder(){
        super("Mi primera ventana");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cp = getContentPane();
        cp.setLayout(new BorderLayout());
        paneles();//Creacion de paneles
        textFields();//Creacion de cuadros de texto
        //Creacion de etiqueta
        etiqueta = new JLabel("Selecciona: ");
        botones();//Creacion de botones
        addPaneles();
        addContainer();//Añadir al panel
    }
    
    private void paneles(){
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel1.setLayout(new BorderLayout());
    }
    
    private void textFields(){
        txt1 = new JTextField(24);
        txt2 = new JTextField(24);
        txt3 = new JTextField(24);
        txt4 = new JTextField(24);
    }
    
    private void botones(){
        boton1 = new JButton("Comprobar");
        boton2 = new JButton("Salir");
        //Añadimos el escuchador
        //boton1.addActionListener(new ManejadorEventos(this));
        //boton2.addActionListener(new ManejadorEventos(this));
    }
    
    private void addPaneles(){
        panel1.add(txt1, BorderLayout.NORTH);
        panel1.add(txt2, BorderLayout.WEST);
        panel1.add(txt3, BorderLayout.EAST);
        panel1.add(txt4, BorderLayout.SOUTH);
        panel2.add(etiqueta, BorderLayout.SOUTH);
        panel3.add(boton1, BorderLayout.WEST);
        panel3.add(boton2, BorderLayout.EAST);   
    }
    
    private void addContainer(){
        cp.add(panel1, BorderLayout.NORTH);
        cp.add(panel2, BorderLayout.CENTER);
        cp.add(panel3, BorderLayout.SOUTH);
    }
}
