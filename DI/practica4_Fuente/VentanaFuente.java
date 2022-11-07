package practica4_Fuente;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class VentanaFuente extends JFrame{
    private Container cp;
    GridBagConstraints gbc;
    JLabel title, style, size;
    JTextField tf;
    JCheckBox cb;
    JRadioButton rb1, rb2, rb3;
    ButtonGroup bg;
    JPanel pN, pS, p1, p2;

    public VentanaFuente(){
        super("Ventana tamaño fuente");
        setSize(470, 350);
        cp = getContentPane();
        cp.setLayout(new BorderLayout());

        pN = new JPanel();
        pN.setLayout(new GridLayout(2,1, 0,24));
        pN.setBorder(new EmptyBorder(10,12,10,12));
        title = new JLabel("Introduce cualquier texto");
        title.setFont(title.getFont().deriveFont(1, 22));
        title.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        pN.add(title);
        tf = new JTextField("");
        pN.add(tf);
        cp.add(pN, BorderLayout.NORTH);

        pS = new JPanel();
        pS.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(24, 30, 20, 30);

        p1 = new JPanel();
        cb = new JCheckBox("Cursiva");        
        p1.add(cb);      
        pS.add(p1);
        p1.setPreferredSize(new Dimension(90, 80));
        p1.setBorder(BorderFactory.createTitledBorder("Estilo"));
        
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
        pS.add(p2);

        cp.add(pS, BorderLayout.CENTER);

        //rb1.addFocusListener(new ManejadorFuente(this));
        rb1.addActionListener(new ManejadorFuente(this));
        rb2.addActionListener(new ManejadorFuente(this));
        rb3.addActionListener(new ManejadorFuente(this));
        cb.addItemListener(new ManejadorFuente(this));
    }

}
