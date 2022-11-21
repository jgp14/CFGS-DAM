package ejemplos_Layout;

//import java.applet.*;
import java.awt.*;

public class Dialogo extends Dialog{
    Dialogo(Frame madre,String título,boolean modal,int x,int y,int
    dx,int dy) {
        super(madre,título,modal);
    Label lbl=new Label("Dialog",Label.CENTER);
    lbl.setBackground(Color.yellow);
    add("Center",lbl);
    pack();
    setSize(dx,dy);
    setLocation(x,y);
    setVisible(true);

    }

}
