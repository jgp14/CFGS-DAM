package p4_masEventosFuente;

import java.awt.*;
import javax.swing.*;

public class VentanaFuente extends JFrame{
    private Container cp; //Atributos ventana
    GridBagConstraints gbc;
    JLabel title;
    JTextField tf;
    JCheckBox cb;
    JRadioButton rb1, rb2, rb3;
    ButtonGroup bg;
    JPanel pS, p1, p2 ;

    public VentanaFuente(){
        //Creacion contendor de tipo GridBagLayout, con constraints
        super("Ventana tamaño fuente");
        setSize(470, 350);
        cp = getContentPane();
        cp.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 16, 20, 16);
        title();
        tf();
        pS();
        p1();
        p2();
        addP1();
        listeners();  
    }
    
    private void title(){//Creacion de la etiqueta
        title = new JLabel("Introduce cualquier texto");
        title.setFont(title.getFont().deriveFont(1, 22));
        title.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        gbc.gridx = 0; 
        gbc.gridy = 0; 
        cp.add(title, gbc);
    }
    
    private void tf(){//Creacion del campo de texto para introducir palabras
        tf = new JTextField("");
        tf.setFont(tf.getFont().deriveFont(0,15));;
        gbc.gridx = 0; 
        gbc.gridy = 1; 
        gbc.insets = new Insets(10, 16, 40, 16);
        cp.add(tf, gbc);
    }
        
    private void pS(){//Creacion de panel sur tambien de tipo GridBagLayout
        pS = new JPanel();
        pS.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(30, 14, 50, 96);
    }
    
    private void p1(){//Creacion de panel para el checkbox con un marco
        p1 = new JPanel();
        cb = new JCheckBox("Cursiva");        
        p1.add(cb);              
        p1.setPreferredSize(new Dimension(90, 80));
        p1.setBorder(BorderFactory.createTitledBorder("Estilo"));
        pS.add(p1, gbc);
    }
    
    private void p2(){//Creacion de panel del radioButton y ButtonGroup
        p2 = new JPanel();
        p2.setLayout(new GridLayout(3,0));
        rb1 = new JRadioButton("12");
        rb2 = new JRadioButton("18");
        rb3 = new JRadioButton("24");
        bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        bg.add(rb3);
        p2.add(rb1);
        p2.add(rb2);
        p2.add(rb3);
        p2.setPreferredSize(new Dimension(140, 105));
        p2.setBorder(BorderFactory.createTitledBorder("Tamaño"));
        gbc.insets = new Insets(30, 90, 20, 14);
        pS.add(p2, gbc);
    }
    
    private void addP1(){//añadir panel sul al contenedor
        gbc.insets = new Insets(0, 0, 20, 0);
        gbc.gridx = 0; 
        gbc.gridy = 2; 
        cp.add(pS, gbc);
    }
    
    private void listeners(){//Añadir los escuchadores al final
        rb1.addActionListener(new ManejadorFuente(this));
        rb2.addActionListener(new ManejadorFuente(this));
        rb3.addActionListener(new ManejadorFuente(this));
        cb.addItemListener(new ManejadorFuente(this));
    }
    
}
