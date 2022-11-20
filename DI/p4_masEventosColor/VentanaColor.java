package p4_masEventosColor;

import java.awt.*;
import javax.swing.*;

public class VentanaColor extends JFrame {
    //Atributos de la VentanaColor    
    private Container cp;
    JPanel p1, p2, p3, p4;
    JScrollBar[] sbs = new JScrollBar[3];
    int X = 13, Y = 3;
    JButton[] botones = new JButton[X];
    JTextField[] tfs = new JTextField[Y];
    JLabel[] ls = new JLabel[Y];
    private Font f1; 
    Color colorF;
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
        panel1();        
        panel2();
        panel3();
        panel4();
        cp.add(p1, BorderLayout.WEST); //Añadimos paneles
        cp.add(p2, BorderLayout.CENTER);
        cp.add(p3, BorderLayout.EAST);
        cp.add(p4, BorderLayout.SOUTH); 
    }
    
    private void panel1(){//Genramos todo el panel de izquierda
        p1 = new JPanel(); 
        p1.setLayout(new GridLayout(1,3));
        for(int i = 0; i < 3; i++){
            sbs[i] = new JScrollBar
            (JScrollBar.VERTICAL,255,30,0,285);            
            p1.add(sbs[i]);
            sbs[i].addAdjustmentListener(new ManejadorColor(this));
        }
    }
    
    private void panel2(){//Generamos todo el panel del centro
        p2 = new JPanel(); 
        colorF = p2.getBackground();
        p2.setBackground(colorF);
    }
    
    private void panel3(){//Generamos todo el panel de la derecha
        p3 = new JPanel(new GridLayout(X,1));  
        for(int i = 0; i < X; i++){            
            botones[i] = new JButton(colorNames[i]);            
            if(i == 0) botones[i].setForeground(Color.WHITE);;
            botones[i].setBackground(colores[i]);
            botones[i].addActionListener(new ManejadorColor(this));
            p3.add(botones[i]);            
        }
    }
    
    private void panel4(){//Generamos todo el panel de abajo
        p4 = new JPanel(new GridLayout(1,6)); 
        ls[0] = new JLabel("rojo");
        f1 = new Font
        (ls[0].getFont().getFontName(), Font.PLAIN, 20);
        ls[0].setBackground(Color.RED);        
        ls[1] = new JLabel("verde");
        ls[1].setBackground(Color.GREEN);
        ls[2] = new JLabel("azul");
        ls[2].setBackground(Color.BLUE);        
        for(int i = 0; i < Y; i++){                           
            ls[i].setFont(f1);
            ls[i].setOpaque(true);
            tfs[i] = new JTextField();    
            tfs[i].addFocusListener(new ManejadorColor(this));  
            tfs[i].setFont(f1);              
            p4.add(ls[i]);
            p4.add(tfs[i]);
        }
    }
    
}