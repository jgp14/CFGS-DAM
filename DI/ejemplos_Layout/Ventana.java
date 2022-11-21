package ejemplos_Layout;

//import java.applet.*;
import java.awt.*;

public class Ventana extends Window{
    Ventana(Frame fr,int x,int y,int dx, int dy) {
        super(fr);
        Label lbl=new Label("Window",Label.CENTER);
        lbl.setBackground(Color.cyan);
        add("Center",lbl);
        pack();
        setSize(dx,dy);
        setLocation(x,y);
        //show();
    }
}
