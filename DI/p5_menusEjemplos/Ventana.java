package p5_menusEjemplos;

import java.applet.*;
import java.awt.*;
import javax.swing.JButton;

public class Ventana extends Window {
    
    Ventana(Frame fr,int x,int y,int dx, int dy) {
        super(fr);
        Label lbl=new Label("Window",Label.CENTER);
        lbl.setBackground(Color.cyan);
        add("Center",lbl);
        setSize(dx,dy);
        setLocation(x,y);
        setVisible(true);
    }

}
