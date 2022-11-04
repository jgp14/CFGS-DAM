package practica4_masEventos;

import java.awt.*;
import javax.swing.*;

public class VentanaColor extends JFrame {
    //Atributos de la VentanaColor    
    private Container cp;
    JPanel p1, p2, p3, p4;
    JScrollBar[] sbs = new JScrollBar[3];
    int X = 13, Y = 6;
    JButton[] botones = new JButton[X];
    JTextField[] tfs = new JTextField[Y];
    private Font f1; 
    Color colorFondo;
    String[] colorNames = {"negro", "gris oscuro", 
    "gris", "gris claro", "blanco", "magenta", "azul", 
    "cian", "verde", "amarillo", "naranja", "rojo", "rosa"};
    Color[] colores = {Color.BLACK, Color.DARK_GRAY, 
        Color.GRAY, Color.LIGHT_GRAY, Color.WHITE, 
        Color.MAGENTA, Color.BLUE, Color.CYAN, 
        Color.GREEN, Color.YELLOW, Color.ORANGE, 
        Color.RED, Color.pink};

    public VentanaColor(){ //Constructor ventana
        super("Colores");
        setSize(720, 510);
        cp = getContentPane();
        cp.setLayout(new BorderLayout());
                
        p1 = new JPanel(); //Genramos todo el panel de izquierda
        p1.setLayout(new GridLayout(1,3));
        for(int i = 0; i < 3; i++){
            sbs[i] = new JScrollBar
            (JScrollBar.VERTICAL,0,0,0,255);            
            p1.add(sbs[i]);
            sbs[i].addAdjustmentListener(new ManejadorColor(this));
        }

        p2 = new JPanel(); //Generamos todo el panel del centro
        colorFondo = Color.BLACK;
        p2.setBackground(colorFondo);

        //Generamos todo el panel de la derecha
        p3 = new JPanel(new GridLayout(X,1));  
        for(int i = 0; i < X; i++){            
            botones[i] = new JButton(colorNames[i]);            
            if(i == 0) botones[i].setForeground(Color.WHITE);;
            botones[i].setBackground(colores[i]);
            botones[i].addActionListener(new ManejadorColor(this));
            p3.add(botones[i]);            
        }
        //Generamos todo el panel de abajo
        p4 = new JPanel(new GridLayout(1,6)); 
        tfs[0] = new JTextField("rojo");
        f1 = new Font
        (tfs[0].getFont().getFontName(), Font.PLAIN, 20);
        tfs[0].setBackground(Color.RED);        
        tfs[2] = new JTextField("verde");
        tfs[2].setBackground(Color.GREEN);
        tfs[4] = new JTextField("azul");
        tfs[4].setBackground(Color.BLUE);
        for(int i = 0; i < Y; i++){
            if(i % 2 == 0)
                tfs[i].setEditable(false);
            else if (i % 2 != 0)
                tfs[i] = new JTextField();    
                tfs[i].addKeyListener(new ManejadorColor(this));             
            tfs[i].setFont(f1);  
            p4.add(tfs[i]);
        }
        
        cp.add(p1, BorderLayout.WEST); //Añadimos paneles
        cp.add(p2, BorderLayout.CENTER);
        cp.add(p3, BorderLayout.EAST);
        cp.add(p4, BorderLayout.SOUTH); 
    }
    
}