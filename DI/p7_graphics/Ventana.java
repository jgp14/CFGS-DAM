package p7_graphics;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.DimensionUIResource;

import java.awt.*;
import static java.awt.Font.PLAIN;

public class Ventana extends JFrame {
    private Container cp;
    DimensionUIResource dim;
    JPanel p1, p2, p3;
    PanelPunto panelPunto;
    JLabel cx1, cy1, cx2, cy2, distanceS;
    JTextField tx1, ty1, tx2, ty2;
    JButton calc, clean, paint;
    JComboBox cb;
    Double d;
    String[] colorNames = {"negro", "gris oscuro", 
    "gris", "gris claro", "blanco", "magenta", "azul", 
    "cian", "verde", "amarillo", "naranja", "rojo", "rosa"};
    Color[] colores = {Color.BLACK, Color.DARK_GRAY, 
        Color.GRAY, Color.LIGHT_GRAY, Color.WHITE, 
        Color.MAGENTA, Color.BLUE, Color.CYAN, 
        Color.GREEN, Color.YELLOW, Color.ORANGE, 
        Color.RED, Color.pink};

    public Ventana(){
        cp = getContentPane();    
        setTitle("Practica Graphics");
        dim = new DimensionUIResource(800, 800);
        setSize(dim);
        setResizable(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
         
        cp.setLayout(new BorderLayout());

        p1 = new JPanel(new GridLayout(2,4));
        cx1 = new JLabel("Coordenada x");
        p1.add(cx1);
        tx1 = new JTextField(8);
        p1.add(tx1);

        cy1 = new JLabel("Coordenada y");
        p1.add(cy1);
        ty1 = new JTextField(8);
        p1.add(ty1);

        cx2 = new JLabel("Coordenada x");
        p1.add(cx2);
        tx2 = new JTextField(8);
        p1.add(tx2);

        cy2 = new JLabel("Coordenada y");
        p1.add(cy2);
        ty2 = new JTextField(8);
        p1.add(ty2);
        
        cp.add(p1,BorderLayout.NORTH);

        
        panelPunto = new PanelPunto();
        panelPunto.setVisible(false);
        panelPunto.setBackground(Color.WHITE);


        d = 0.0;
        distanceS = new JLabel("Distancia entre puntos: "+d);
        panelPunto.add(distanceS);
        cp.add(panelPunto, BorderLayout.CENTER);

        p3 = new JPanel(new GridLayout(1,2));
        calc = new JButton("Calcular");
        p3.add(calc);
        clean = new JButton("Limpiar");
        p3.add(clean);
        
        cb = new JComboBox(colorNames);
        cb.setName("Dibujar");
        cb.setMaximumRowCount(16);
        cb.setForeground(Color.BLACK);
        cb.setBackground(Color.WHITE);
        
        p3.add(cb);
        cp.add(p3, BorderLayout.SOUTH);
        
        calc.addActionListener(new Manejador(this));
        clean.addActionListener(new Manejador(this));
        cb.addItemListener(new Manejador(this)); 
    }
    
 }