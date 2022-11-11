package practica4_Fuente;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class VentanaFuente extends JFrame{
    /*private Container cp;
    GridBagConstraints gbc;
    JLabel title, style, size;
    JTextField tf;
    JCheckBox cb;
    JRadioButton rb1, rb2, rb3;
    ButtonGroup bg;
    JPanel pN, pS, p1, p2;

    public VentanaFuente(){
        //Crecion de contenedor
        super("Ventana tamaño fuente");
        setSize(470, 350);
        cp = getContentPane();
        cp.setLayout(new BorderLayout());

        //Creacion de Panel Norte, y elementos del mismo, label y textField
        pN = new JPanel();
        pN.setLayout(new GridLayout(2,1, 0,24));
        pN.setBorder(new EmptyBorder(10,16,10,16));
        title = new JLabel("Introduce cualquier texto");
        title.setFont(title.getFont().deriveFont(1, 22));
        title.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        pN.add(title);
        tf = new JTextField("");
        pN.add(tf);
        cp.add(pN, BorderLayout.NORTH);

        //Creacion de panel sur de tipo GridBagLayout, con constraints
        pS = new JPanel();
        pS.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(30, 14, 50, 96);

        //Creacion de panel para el checkbox con un marco
        p1 = new JPanel();
        cb = new JCheckBox("Cursiva");        
        p1.add(cb);              
        p1.setPreferredSize(new Dimension(90, 80));
        p1.setBorder(BorderFactory.createTitledBorder("Estilo"));
        pS.add(p1, gbc);

        //Creacion de panel del radioButton y ButtonGroup tipo GridLayout
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
        gbc.insets = new Insets(30, 96, 20, 14);
        pS.add(p2, gbc);

        //añadir panel sul al contenedor
        cp.add(pS, BorderLayout.CENTER);

        //Añadir los escuchadores al final
        rb1.addActionListener(new ManejadorFuente(this));
        rb2.addActionListener(new ManejadorFuente(this));
        rb3.addActionListener(new ManejadorFuente(this));
        cb.addItemListener(new ManejadorFuente(this));
    }*/

    private Container cp;
    GridBagConstraints gbc;
    JLabel title, style, size;
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

        //Creacion de la etiqueta
        title = new JLabel("Introduce cualquier texto");
        title.setFont(title.getFont().deriveFont(1, 22));
        title.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        gbc.gridx = 0; 
        gbc.gridy = 0; 
        cp.add(title, gbc);

        //Creacion del campo de texto para introducir palabras
        tf = new JTextField("");
        tf.setFont(tf.getFont().deriveFont(0,15));;
        gbc.gridx = 0; 
        gbc.gridy = 1; 
        gbc.insets = new Insets(10, 16, 40, 16);
        cp.add(tf, gbc);

        //Creacion de panel sur tambien de tipo GridBagLayout
        pS = new JPanel();
        pS.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(30, 14, 50, 96);

        //Creacion de panel para el checkbox con un marco
        p1 = new JPanel();
        cb = new JCheckBox("Cursiva");        
        p1.add(cb);              
        p1.setPreferredSize(new Dimension(90, 80));
        p1.setBorder(BorderFactory.createTitledBorder("Estilo"));
        pS.add(p1, gbc);

        //Creacion de panel del radioButton y ButtonGroup tipo GridLayout
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

        //añadir panel sul al contenedor
        gbc.insets = new Insets(0, 0, 20, 0);
        gbc.gridx = 0; 
        gbc.gridy = 2; 
        cp.add(pS, gbc);

        //Añadir los escuchadores al final
        rb1.addActionListener(new ManejadorFuente(this));
        rb2.addActionListener(new ManejadorFuente(this));
        rb3.addActionListener(new ManejadorFuente(this));
        cb.addItemListener(new ManejadorFuente(this));
    }
}
