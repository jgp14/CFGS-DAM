package p7_graphics;

import java.awt.*;
import javax.swing.*;

public class PanelPunto extends JPanel{

    private static final Integer r = 5; //Radio Punto
    private static final Integer m = 20; //Margenes
    Punto p1 = new Punto();
    Punto p2 = new Punto();
    Integer side = 600;
    Color color = Color.RED;
    
    @Override
    public void paint(Graphics g){
        super.paint(g);

        //Para poder modificar más propiedades con Graphics 2d
        Graphics2D g2d = (Graphics2D) g;
        //Cuadrado (relleno y borde)
        g2d.setColor(color);
        g2d.fillRect(m+(int) p1.obtenerX(), m+(int) p1.obtenerY(), side, side);
        g2d.setColor(Color.BLACK);
        g2d.drawRect(m+(int) p1.obtenerX(), m+(int) p1.obtenerY(), side, side);  
        g2d.setColor(Color.BLUE);
        g2d.fillOval(m+(int) p1.obtenerX()-r, m+(int) p1.obtenerY()-r, 2*r, 2*r);
        g2d.fillOval(m+(int) p2.obtenerX()-r, m+(int) p2.obtenerY()-r, 2*r, 2*r);
    }
    
    
/* 
    private int calcSide(){
        int side = 0; 
        if((p2.obtenerX()-p1.obtenerX())>(p2.obtenerY()-p1.obtenerY()))
            side = (int)(p2.obtenerX()-p1.obtenerX());
        else 
            side = (int)(p2.obtenerY()-p1.obtenerY());
        return side;
    }
 */

    public Punto getP1() {
        return p1;
    }

    public Punto getP2() {
        return p2;
    }

    public Integer getSide() {
        return side;
    }

    public Color getColor() {
        return color;
    }

    public void setP1(Punto p1) {
        this.p1 = p1;
    }

    public void setP2(Punto p2) {
        this.p2 = p2;
    }

    public void setSide(Integer side) {
        this.side = side;
    }

    public void setColor(Color color) {
        this.color = color;
    }
  
}
