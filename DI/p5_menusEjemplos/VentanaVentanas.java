package p5_menusEjemplos;

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class VentanaVentanas extends JFrame{
    private Container cp;
    JButton ventanaB, dialogoB, marcoB;
    
    public VentanaVentanas(){ //Creamos la ventana con ventanas
        super("Ventanas");
        setSize(280, 100);
        cp = getContentPane();
        cp.setLayout(new FlowLayout());
        botones();
        listeners();    
    }

    private void botones(){//Creamos los botones y añadimos a cp
        ventanaB = new JButton("ventana");
        dialogoB = new JButton("dialogo");
        marcoB = new JButton("marco");
        cp.add(ventanaB);
        cp.add(dialogoB);
        cp.add(marcoB);
    }

    private void listeners(){//Ponemos los listeners
        ventanaB.addActionListener(new ManejadorVentanas(this));
        dialogoB.addActionListener(new ManejadorVentanas(this));
        marcoB.addActionListener(new ManejadorVentanas(this));
    }
    
}
