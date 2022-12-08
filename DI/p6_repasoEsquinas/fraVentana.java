package p6_repasoEsquinas;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.DimensionUIResource;

public class fraVentana extends JFrame {
    //Declaramos los atributos
    Container cp;
    JPanel p1, p2, p3; 
    JButton btnArribaIzda, btnArribaDcha, 
    btnAbajoIzda, btnAbajoDcha;
    Dimension d, dIni, dMin, dMax;
    JToggleButton btnCentro;
    String sBig, sSmall, btnName;
    
    public fraVentana(){ 
        super("Dimensiones y posiciones – Centro – 300x300.");        
        setLocation(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        cp = getContentPane();
        cp.setLayout(new BorderLayout());
        
        //Poner dimensiones maxima y minima y de pantalla
        dMin = new DimensionUIResource(100, 100);
        setMinimumSize(dMin);
        dIni = new DimensionUIResource(300, 300); 
        dMax = new DimensionUIResource(600, 600);
        setSize(dIni);
        d = Toolkit.getDefaultToolkit().getScreenSize();
        
        p1 = new JPanel(new BorderLayout());//Panel arriba
        btnArribaIzda = new JButton("btnArribaIzda");
        p1.add(btnArribaIzda, BorderLayout.WEST);

        btnArribaDcha = new JButton("btnArribaDcha");
        p1.add(btnArribaDcha, BorderLayout.EAST);
        

        
        sBig = "Aumenta dimension";
        sSmall = "Disminuye dimension";
        btnName = "btnName";
        btnCentro = new JToggleButton(sBig);
        p1.add(btnCentro, BorderLayout.SOUTH);

        cp.add(p1, BorderLayout.NORTH);
        
        
        p3 = new JPanel(new BorderLayout());//Panel botones abajo
        btnAbajoIzda = new JButton("btnAbajoIzda");
        p3.add(btnAbajoIzda, BorderLayout.WEST);

        btnAbajoDcha = new JButton("btnAbajoDcha");
        p3.add(btnAbajoDcha, BorderLayout.EAST);
        cp.add(p3, BorderLayout.SOUTH);

        btnArribaIzda.addActionListener(new fraManejador(this));
        btnArribaDcha.addActionListener(new fraManejador(this));
        btnAbajoIzda.addActionListener(new fraManejador(this));
        btnAbajoDcha.addActionListener(new fraManejador(this));
        btnCentro.addItemListener(new fraManejador(this));
    }//Constructor de la ventana

}