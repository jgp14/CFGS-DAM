package p5_menusEjemplos;

import java.applet.*;
import java.awt.*;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;

public class Dialogo extends JDialog {
    Dialogo(Frame madre,String título,boolean modal,int x,int y,int dx,int dy) {
        super(madre,título,modal);
        Label lbl=new Label("Dialog",Label.CENTER);
        lbl.setBackground(Color.yellow);
        add("Center",lbl);
        setSize(dx,dy);
        setLocation(x,y);
        setVisible(true);
    }

}
